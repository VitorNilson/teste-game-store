import React, { Component, useEffect, useState } from 'react';
import {
  Row,
  CardBody,
  Container,
  Col,
  Nav,
  NavItem,
  NavLink,
  Jumbotron,
  Card,
  CardHeader,
  Form
 } from 'reactstrap';



import api from '../../resources/api_produtos';
import apiCart from '../../resources/api_cart';
import axios from 'axios';
import Header from '../Header/header'
import Filter from './filter'


const Main = () =>{

//Recebe duas APIs

  const[product, setProduct] = useState([]);
  const[cart, setCart] = useState([]);


  const fetchData = () =>{
    const productApi = api.get('');
    const cartApi = apiCart.get('');


    axios.all([productApi, cartApi]).then(
      axios.spread((...allData) =>{
        const allProductData = allData[0].data.content;
        const allDataCart = allData[1].data;

        setProduct(allProductData);
        setCart(allDataCart);
   

  
      })
    )
  }

  useEffect(() =>{
    fetchData()
  }, [])



   return (
   
    <div>    
       <Header></Header> 
        <Container>          
          <Jumbotron><h1>Produtos</h1></Jumbotron>
          <Row>
            <Col xs="3">
            <Filter></Filter>
            </Col>
              <Col xs="9">
                <div>
                  {/*A API é recebida e então mapeada para receber os elementos*/}
                {product.map(produto => (
                
                    <Card className="mb-3"> 
                      <CardHeader key={produto.id} className="d-flex justify-content-between">              
                        <span>
                          {produto.name}  
                        </span>
                        <div>
                            <nav>
                              <Form method="POST" action={"http://localhost:8080/comprar/" + produto.id}>                            
                                  <input type="submit" className="btn btn-secondary"  value="Comprar" ></input>                             
                                </Form>
                            </nav>
                        </div>       
                      </CardHeader>        
                      <CardBody>
                        <Row>                      
                          <div className="col-12 col-sm-8 mb-3">  
                            <Row>                             
                              <div key={produto.id}>
                                      <div >
                                        Nome: {produto.name}
                                      </div> 
                                      <div > 
                                        Preço: R$ {produto.price}                          
                                      </div>
                                      <div>
                                        Score: {produto.score} &#9734; &#9734; &#9734;
                                      </div>   
                                </div>                          
                            </Row>   
                          </div>               
                          <div className="col-12 col-md-4">            
                            <figure key={produto.id}>
                              <img className="img-thumbnail"src={produto.image} />
                            </figure>                    
                          </div>         
                        </Row>
                      </CardBody>
                    </Card>        
                    ))}
                </div>
              </Col>
          </Row>          
        </Container> 
    </div>
  );
}


export default Main;