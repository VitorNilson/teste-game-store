import React, {Component} from 'react'
import {
    Row,
    CardBody,
    Container,
    Col,
    Nav,
    NavItem,
    NavLink,
    Card,
    CardTitle,
    CardHeader
   } from 'reactstrap';

import apiCartSize from '../../resources/api_cart_size';


// Filtro. Localização: página principal
class Filter extends Component{

  sortBy(){
    return '/?sortBy=name'
  }

     
    
      render(){    
        return(
          <div>
            <Card>
              <CardHeader>Filtros</CardHeader>
              <CardBody>
                <Nav>
                  <NavItem> 
                    <NavLink onClick={this.sortBy()}>De A-Z</NavLink>
                    <NavLink onClick={this.sortBy()}>Por preço</NavLink>
                    <NavLink onClick={this.sortBy()}>Por Score</NavLink>        
                  </NavItem>  
                </Nav>
              </CardBody>        
            </Card>     
          </div>
         )}

    
    
}

export default Filter;
