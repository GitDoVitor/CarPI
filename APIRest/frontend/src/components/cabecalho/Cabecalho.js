import "./cabecalho.scss";
import logo from "../../img/foda-min.png";
import {NavLink} from "react-router-dom";

const Cabecalho = () => (
  <header className="header1" style={{ position: "absolute" }}>
    <div className="logo">
      <a href="/">
        <img src={logo} alt="logo" />
      </a>
    </div>
    <nav>
      <ul className="menu">
        <li>
          <NavLink to="/cardapio">
            <p className="opcao1">
              <i className="fas fa-book-open"></i> Car-dápio
            </p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/carrinho">
            <p className="opcao3">
              <i className="fas fa-shopping-cart"></i> Carrinho
            </p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/login">
            <p className="opcao2">
              <i className="fas fa-user"></i> Login
            </p>
          </NavLink>
        </li>
      </ul>
    </nav>
  </header>
);

export default Cabecalho;
