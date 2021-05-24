import React, {Component} from 'react'
import apiCartSize from '../../resources/api_cart_size';
import {
    Row,
    CardBody,
    Container,
    Col,
    Nav,
    NavItem,
    NavLink,
   } from 'reactstrap';


// Cabeçalho das páginas
class Header extends Component{

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
                <div className="p-3 mb-2 bg-dark text-white d-flex justify-content-between">           
                  <div>
                    <Nav>
                      <NavItem>
                        <NavLink className="text-light" href="/"><strong>Game Store</strong></NavLink>                  
                      </NavItem>
                    </Nav>            
                  </div>
                  <div>              
                      <div>
                        <div>
                          <Nav>
                            <NavItem>
                              <NavLink className="text-light" href="/carrinho">Carrinho ( {carrinho} )</NavLink>                  
                            </NavItem>
                          </Nav>
                        </div>
                      </div>  
                  </div>  
                </div>
              </div>
         )}

    
    
}

export default Header;
