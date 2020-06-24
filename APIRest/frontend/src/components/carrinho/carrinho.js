import React, {Component} from "react";
import Cabecada from "../cabecada/cabecada";
import ColunasCarrinho from "./ColunasCarrinho";
import CarrinhoVazio from "./CarrinhoVazio";
import {ProdutoConsumer} from "../databaseLanches/context";
import CarrinhoLista from "./CarrinhoLista";
import TotalCarrinho from "./TotalCarrinho";

export default class carrinho extends Component {
  render() {
    return (
      <React.Fragment>
        <Cabecada />
        <section>
          <ProdutoConsumer>
            {value => {
              const { carrinho } = value;
              if (carrinho.length > 0) {
                return (
                  <React.Fragment>
                    <h1 className="text-center mb-5">Seu Carrinho</h1>
                    <ColunasCarrinho />
                    <CarrinhoLista value={value} />
                    <TotalCarrinho value={value} />
                  </React.Fragment>
                );
              } else {
                return <CarrinhoVazio />;
              }
            }}
          </ProdutoConsumer>
        </section>
      </React.Fragment>
    );
  }
}
