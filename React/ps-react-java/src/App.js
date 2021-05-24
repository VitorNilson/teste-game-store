import React, { Component } from 'react'
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import Main from './pages/Main';
import CartList from './pages/Purchase/index';
import FinishShopping from './pages/Purchase/finish_shopping'

function App(){
  return(
    <BrowserRouter>
    <Switch>
        <Route  path="/" exact  component={Main}></Route>
        <Route path="/carrinho" exact component={CartList}></Route>
        <Route path="/finalizar-compra" exact component={FinishShopping}></Route>
    </Switch>
  </BrowserRouter>

  )
 
    }
  

export default App;
