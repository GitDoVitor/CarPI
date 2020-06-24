import {Component} from "react";
import Cabecada from "../cabecada/cabecada";
import Lanches from "../listaLanche/listaLanche";
import Rodape from '../rodape/Rodape';

export default class cardapio extends Component {
  render() {
    return (
      <div>
        <Cabecada />
        <Lanches />
        <Rodape />
      </div>
    );
  }
}
