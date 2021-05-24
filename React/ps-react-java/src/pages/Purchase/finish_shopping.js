import React, { Component, useState, useEffect } from 'react';
import InputMask from 'react-input-mask'
import {
  InputGroup,
  InputGroupAddon,
  Input,
  Button,
  Row,
  Col,
  Card,
  CardBody,
  CardTitle,
  Container,
  Nav,
  NavItem,
  NavLink,
  Table,
  Jumbotron,
  Form,
  FormGroup,
  Label
 } from 'reactstrap';

 
 import api from '../../resources/api_produtos';
 import apiCartSize from '../../resources/api_cart';
 import Header from '../Header/header'
 import axios from 'axios';
 import Prices from '../Price/prices'
 import ShippingPrice from '../Price/shipping_price'

 // Tela de finalizar a compra
 class FinishShopping extends Component{


    render(){

        return(
            <div>
            <Header></Header>
            <Container> 
                <Jumbotron>
                    <h1>Finalizar compra</h1>
                    <div>
                    <Prices></Prices>
                    <ShippingPrice></ShippingPrice>
                    </div>
                </Jumbotron>

                <Form action="http://localhost:8080/carrinho/finalizar-compra" method="POST">
                <Row form>
                    <Col md={6}>
                    <FormGroup>
                        <Label for="name">Nome</Label>
                        <Input type="text" name="name" id="name" placeholder="Nome Completo" />
                    </FormGroup>
                    </Col>
                    <Col md={6}>
                    <FormGroup>
                        <Label for="cpf">CPF</Label>                        
                        <InputMask className="form-control"mask="999.999.999-99" type="text" name="cpf" id="cpf"/>
                      </FormGroup>
                    </Col>
                </Row>
                <FormGroup>
                    <Label for="address">Endereço</Label>
                    <Input type="text" name="address" id="address" placeholder="Logradouro: Avenida / Rua, Número"/>
                </FormGroup>
                <FormGroup>
                    <Label for="complement">Complemento</Label>
                    <Input type="text" name="complement" id="complement" placeholder="Apartamento, Quadra / Lote"/>
                </FormGroup>
                <Row form>
                    <Col md={6}>
                    <FormGroup>
                        <Label for="city">Cidade</Label>
                        <Input type="text" name="city" id="city"/>
                    </FormGroup>
                    </Col>
                    <Col md={4}>
                    <FormGroup>
                        <Label for="state">Estado</Label>
                        <Input type="text" name="state" id="state"/>
                    </FormGroup>
                    </Col>
                    <Col md={2}>
                    <FormGroup>
                        <Label for="cep">CEP</Label>
                        <InputMask className="form-control" mask="99.999-999" type="text" name="cep" id="cep"/>
                    </FormGroup>  
                    </Col>
                    <Col md={2}>
                        <FormGroup>
                            <Label for="creditcardnumer">Número cartão crédito</Label>
                            <InputMask className="form-control" mask="9999 9999 9999 9999"type="text" name="creditcardnumber" id="creditcardbumber"/>
                        </FormGroup>
                    </Col>
                    <Col md={2}>
                        <FormGroup>
                            <Label for="creditcardexpiry">Validade</Label>
                            <InputMask className="form-control" mask="99/9999" type="text" name="creditcardexpiry" id="creditcardexpiry" />
                        </FormGroup>
                    </Col>
                    <Col md={1}>
                    <FormGroup>
                        <Label for="creditcardcvv">CVV</Label>
                        <InputMask className="form-control" mask="999" type="text" name="creditcardcvv" id="creditcardcvv" />
                    </FormGroup>
                    </Col>
                </Row>
   
                <Button type="submit">Finalizar compra</Button>
                </Form>
            </Container>
            </div>
        )
    }
 }

 export default FinishShopping;