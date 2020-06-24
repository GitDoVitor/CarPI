import React, {Component} from "react";
import Landing from "./components/landing/Landing";
import Cardapio from "./components/cardapio/cardapio";
import Detalhes from "./components/detalhes/detalhes";
import Carrinho from "./components/carrinho/carrinho";
import Login from "./components/login/Login";
import Cadastro from "./components/cadastro/Cadastro";
import PNF from "./components/PageNotFound/PageNotFound";
import Perfil from "./components/perfil/perfil";
import {Route, Switch} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.css";
import Modal from './components/modal/modal';

import AOS from "aos";
import "aos/dist/aos.css";

export default class App extends Component {
  componentDidMount() {
    AOS.init({
      duration: 2000
    });
  }
  render() {
    return (
      <React.Fragment>
        <Switch>
          <Route exact path="/" component={Landing} />
          <Route path="/cardapio" component={Cardapio} />
          <Route path="/detalhes" component={Detalhes} />
          <Route path="/carrinho" component={Carrinho} />
          <Route path="/login" component={Login} />
          <Route path="/cadastro" component={Cadastro} />
          <Route path="/perfil" component={Perfil} />
          <Route component={PNF} />
        </Switch>
        <Modal />
      </React.Fragment>
    );
  }
}
