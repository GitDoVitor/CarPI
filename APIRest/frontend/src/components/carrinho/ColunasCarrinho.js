import {Component} from "react";

export default class ColunasCarrinho extends Component {
  render() {
    return (
      <div className="container-fluid text-center d-none d-lg-block">
        <div className="row">
          <div className="col-10 mx-auto col-lg-2">
            <p className="text-uppercase">Produto</p>
          </div>
          <div className="col-10 mx-auto col-lg-2">
            <p className="text-uppercase">Nome do Produto</p>
          </div>
          <div className="col-10 mx-auto col-lg-2">
            <p className="text-uppercase">Preço</p>
          </div>
          <div className="col-10 mx-auto col-lg-2">
            <p className="text-uppercase">Quantidade</p>
          </div>
          <div className="col-10 mx-auto col-lg-2">
            <p className="text-uppercase">Remover</p>
          </div>
          <div className="col-10 mx-auto col-lg-2">
            <p className="text-uppercase">Total por Item</p>
          </div>
        </div>
      </div>
    );
  }
}
