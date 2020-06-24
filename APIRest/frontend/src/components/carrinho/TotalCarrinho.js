import React from "react";
import {Link} from "react-router-dom";

export default function TotalCarrinho({value}) {
  const { carrinhoTotal,carrinhoSubTotal, limparCarrinho, carrinhoTaxa } = value;
  return (
    <React.Fragment>
      <div className="container">
        <div className="row">
          <div className="col-10 mt-2 ml-sm-5 ml-md-auto col-sm-8 text-right">
          <h5 className="mr-5 mb-2">
              <span>SubTotal: </span>
              <strong>
                <span>R$ </span>
                {carrinhoSubTotal}
              </strong>
            </h5>
            <h5 className="mr-5 mb-5">
              <span>Taxas: </span>
              <strong>
                <span>R$ </span>
                {carrinhoTaxa}
              </strong>
            </h5>
            <h5 className="mr-5 mb-2">
              <span>Total: </span>
              <strong>
                <span>R$ </span>
                {carrinhoTotal}
              </strong>
            </h5>
            <Link to="/cardapio">
              <button
                className="btn btn-outline-danger text-uppercase mb-3 px-5"
                type="button"
                onClick={() => limparCarrinho()}
              >
                Limpar Carrinho
              </button>
            </Link>
            <button
              className="btn btn-success text-uppercase ml-5 mb-3 px-5"
              type="button"
            >
              Finalizar Pedido
            </button>
          </div>
        </div>
      </div>
    </React.Fragment>
  );
}
