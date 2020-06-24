import {Component} from "react";
import styled from "styled-components";
import {ProdutoConsumer} from "../databaseLanches/context";
import {Link} from "react-router-dom";

export default class modal extends Component {
  render() {
    return (
      <ProdutoConsumer>
        {value => {
          const { modalAberto, fecharModal } = value;
          const { img, nome, preco } = value.modalProduto;

          if (!modalAberto) {
            return null;
          } else {
            return (
              <ModalContainer>
                <div className="container">
                  <div className="row">
                    <div
                      id="modal"
                      className="col-8 mx-auto col-md-6 col-lg-4 text-center py-5"
                      style={{borderRadius: '3px'}}
                    >
                      <h5>Adicionado ao Carrinho</h5>
                      <img src={img} className="img-fluid" alt="Lanche" style={{borderRadius: '3px'}}/>
                      <h5>{nome}</h5>
                      <h5 className="text-muted">
                        <span>Valor: </span>
                        <span>R$</span>
                        {preco}
                        <span>,00</span>
                      </h5>
                      <Link to="/cardapio">
                        <Botola onClick={() => fecharModal()}>
                          Continuar Comprando
                        </Botola>
                      </Link>
                      <Link to="/carrinho">
                        <Botola className="px-4" onClick={() => fecharModal()}>
                          Direto Ao Carrinho
                        </Botola>
                      </Link>
                    </div>
                  </div>
                </div>
              </ModalContainer>
            );
          }
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

const ModalContainer = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.3);
  display: flex;
  align-items: center;
  justify-content: center;

  #modal {
    background: white;
  }
`;
