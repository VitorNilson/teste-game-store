import React, {Component} from 'react'
import {
    Row,
    CardBody,
    Container,
    Col,
    Nav,
    NavItem,
    NavLink,
   } from 'reactstrap';

import apiTotalPrice from '../../resources/api_cart_total_price';

// Component que recebe o preço total do carrinho
class Prices extends Component{

    state = {
        carrinho: [],
      }
    
      async componentDidMount(){
        const response = await apiTotalPrice.get('');
        this.setState({carrinho: response.data});    
      }

      render(){
    
        const{carrinho} = this.state;
        console.log(carrinho)
    
        return(
         <div>
             <p>Valor total no carrinho: R$ {carrinho} </p>
         </div>
         )}
}

export default Prices;
