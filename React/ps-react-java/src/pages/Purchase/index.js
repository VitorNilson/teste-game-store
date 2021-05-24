import React, { Component} from 'react';
import {
  Button, 
  Container,
  Nav,
  NavItem,
  NavLink,
  Table,
  Jumbotron
 } from 'reactstrap';


 import apiCartSize from '../../resources/api_cart';
 import Header from '../Header/header';
 import Prices from '../Price/prices';

 // Lista de produtos no carrinho
class CartList extends Component{

  state = {
    carrinho: [],
  }

  async componentDidMount(){
    const response = await apiCartSize.get('');
    this.setState({carrinho: response.data});    
  }
  
  render(){

    const{carrinho} = this.state;

    return(
      <div>

        <Header></Header>
        
        <div>
        <Container>
          <div>
            <Jumbotron>
              <h1>Produtos no carrinho</h1>
              <div className="d-flex justify-content-between">
              <Prices></Prices>  
                <Nav>
                  <NavItem>
                    <NavLink href="/finalizar-compra"><Button color="success">Finalizar compra</Button></NavLink>    
                  </NavItem>
                </Nav>     
              </div>
            </Jumbotron>
          </div>
                <Table>
                  <thead>
                    <tr>
                      <th>Id</th>
                      <th>Nome</th>
                      <th>Preço</th>
                      <th>Score</th>
                      <th>Imagem</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                      {carrinho.map(cart =>(
                        <tr>
                          <th scope="row">{cart.id}</th>
                          <td>{cart.name}</td>
                          <td>R$ {cart.price}</td>
                          <td>{cart.score}</td>
                          <td><img className=" im-thumbnail w-25 p-3" src={cart.image}></img></td>
                          <td className="align-middle">
                            <div>
                              <form action={"http://localhost:8080/carrinho/remover/"+(cart.id)} method="POST">
                                <Button type="submit" color="primary" size="sm">Remover</Button>
                              </form>
                            </div>
                          </td>              
                          </tr>
                      ))}          
                    </tbody>
                </Table>
        </Container>
        </div>
      </div>
    )
  }
}

export default CartList;
