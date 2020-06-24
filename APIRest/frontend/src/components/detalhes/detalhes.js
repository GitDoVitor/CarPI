import React, {Component} from "react";
import {ProdutoConsumer} from "../databaseLanches/context";
import {Link} from "react-router-dom";
import Cabecada from "../cabecada/cabecada";
import styled from "styled-components";

export default class detalhes extends Component {
  render() {
    return (
      <ProdutoConsumer>
        {value => {
          const {
            id,
            img,
            info,
            nome,
            noCarrinho
          } = value.ProdutoDetalhado;
          return (
            <React.Fragment>
              <Cabecada />
              <div className="container py-3">
                <div className="row">
                  <div className="col-10 mx-auto col-md-6 my-3">
                    <img
                      src={img}
                      className="img-fluid"
                      alt="Lanche"
                      style={{ borderRadius: "3px" }}
                    />
                  </div>
                  <div className="col-10 mx-auto col-md-6 my-3">
                    <h1 className="text-center">{nome}</h1>
                    <p className="font-weight-bold mt-3 mb-0 text-center">
                      Ingredientes
                    </p>
                    <p className="text-muted lead text-center">{info}</p>
                    <div className="text-center" style={{ marginTop: "100px" }}>
                      <Link to="/cardapio">
                        <Botola>Voltar ao Car-dápio</Botola>
                      </Link>
                      <Botola
                        disabled={noCarrinho ? true : false}
                        onClick={() => {
                          value.addCarrinho(id);
                          value.abrirModal(id);
                        }}
                      >
                        {noCarrinho
                          ? "Já Adicionado ao Carrinho"
                          : "Adicionar ao Carrinho"}
                      </Botola>
                    </div>
                  </div>
                </div>
              </div>
            </React.Fragment>
          );
        }}
      </ProdutoConsumer>
    );
  }
}

const Botola = styled.button`
  font-family: "Roboto", san-serif;
  text-transform: capitalize;
  font-size: 1.4rem;
  background: #e49707;
  border: none;
  padding: 0.2rem 0.5rem;
  cursor: pointer;
  margin: 0.2rem 0.5rem 0.2rem 0;
  transition: all 500ms ease-in-out;
  border-radius: 0.2rem;

  &:hover {
    background: #ffba3a;
  }
  %:focus {
    outline: none;
  }
`;
