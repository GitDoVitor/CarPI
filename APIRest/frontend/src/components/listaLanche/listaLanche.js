import React, {Component} from "react";
import Lanche from "../item/lanche";
import {ProdutoConsumer} from "../databaseLanches/context";

export default class listaLanche extends Component {
  render() {
    return (
      <React.Fragment>
        <div className="py-5">
          <div className="container">
            <div className="row">
              <ProdutoConsumer>
                {value => {
                  return value.produtos.map( produto => {
										return <Lanche key={produto.id} produto={produto}/>
									} );
                }}
              </ProdutoConsumer>
            </div>
          </div>
        </div>
      </React.Fragment>
    );
  }
}
