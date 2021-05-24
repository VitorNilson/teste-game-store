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

import apiTotalShipping from '../../resources/api_cart_shipping_price';

// Component que recebe o preço total do frete
class   ShippingPrice extends Component{

    state = {
        frete: [],
      }
    
      async componentDidMount(){
        const response = await apiTotalShipping.get('');
        this.setState({frete: response.data});    
      } 
    
      render(){
    
        const{frete} = this.state;
    
        return(
         <div>
             <p>Valor total de frete: R$ {frete} </p>
         </div>
         )}   
}

export default ShippingPrice;
