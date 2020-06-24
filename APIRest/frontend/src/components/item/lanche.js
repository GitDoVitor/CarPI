import {Component} from "react";
import styled from "styled-components";
import {Link} from "react-router-dom";
import {ProdutoConsumer} from "../databaseLanches/context";
import PropTypes from "prop-types";

export default class lanche extends Component {
  render() {
    const { id, nome, img, preco, noCarrinho } = this.props.produto;

    return (
      <PWrapper className="col-9 mx-auto col-md-6 col-lg-3">
        <div className="card mb-3">
          <ProdutoConsumer>
            {value => (
              <div
                className="img-container"
                onClick={() => {
                  value.handleDetalhes(id);
                }}
              >
                <Link to="/detalhes">
                  <img src={img} alt="Lanche" className="card-img-top" />
                </Link>
                <button
                  className="cart-btn"
                  disabled={noCarrinho ? true : false}
                  onClick={() => {
                    value.addCarrinho(id);
                    value.abrirModal(id);
                  }}
                >
                  {noCarrinho ? (
                    <p className="mb-0">No Carrinho</p>
                  ) : (
                    <i className="fas fa-cart-plus" />
                  )}
                </button>
              </div>
            )}
          </ProdutoConsumer>
          <div className="card-footer d-flex justify-content-between">
            <p className="align-self-center mb-0"> {nome} </p>
            <h5 className="mb-0">
              <span className="mr-1">R$</span> {preco}
              <span>,00</span>
            </h5>
          </div>
        </div>
      </PWrapper>
    );
  }
}

lanche.propTypes = {
  produto: PropTypes.shape({
    id: PropTypes.number,
    img: PropTypes.string,
    nome: PropTypes.string,
    preco: PropTypes.number,
    noCarrinho: PropTypes.bool
  }).isRequired
};

const PWrapper = styled.div`
  .card {
    border-color: transparent;
    transition: all 1s linear;
  }
  .card-footer {
    background-color: transparant;
    border-top: transparent;
    transition: all 1s linear;
  }
  &:hover {
    .card {
      border: 0.04rem solid rgba(0, 0, 0, 0.2);
      box-shadow: 2px 2px 5px 0px rgba(0, 0, 0, 0.2);
    }
    .card-footer {
      background: rgb(247, 247, 247);
    }
  }
  .img-container {
    position: relative;
    overflow: hidden;
  }
  .card-img-top {
    transition: all 1s linear;
  }
  .img-container:hover .card-img-top {
    transform: scale(1.2);
  }
  .cart-btn {
    position: absolute;
    bottom: 0;
    right: 0;
    padding: 0.2rem 0.4rem;
    background: #f7a40b;
    color: #00000;
    font-size: 1.4rem;
    border-radius: 2px 0 0 0;
    transform: translate(100%, 100%);
  }
  .img-container:hover .cart-btn {
    transform: translate(0, 0);
    transition: all 550ms linear;
    color: #00000;
  }
`;
