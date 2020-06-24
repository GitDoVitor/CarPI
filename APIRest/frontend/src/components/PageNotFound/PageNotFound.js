import {Component} from "react";

export default class PageNotFound extends Component {
  render() {
    return (
      <div className="container">
        <div className="row">
          <div className="col-10 mx-auto text-center text-uppercase pt-5">
            <h1 className="display-3">404</h1>
            <h1>Error</h1>
            <h2>Página Não Encontrada</h2>
            <h3 style={{background: 'none'}}>
              A URL Requisitada
              <span className="text-danger">
                "{this.props.location.pathname}"
              </span>
              Não Foi Encontrada
            </h3>
          </div>
        </div>
      </div>
    );
  }
}
