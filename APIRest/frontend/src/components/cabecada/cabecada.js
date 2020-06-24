import "./cabecada.scss";
import logo from "../../img/foda-min.png";
import {NavLink} from "react-router-dom";

const Cabecada = () => (
  <header className="header">
    <div className="logo">
      <a href="/">
        <img src={logo} alt="logo" />
      </a>
    </div>
    <nav>
      <ul className="lista">
        <li>
          <NavLink to="/cardapio">
            <p className="botola1">
              <i className="fas fa-book-open"></i> Car-dápio
            </p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/carrinho">
            <p className="botola2">
              <i className="fas fa-shopping-cart"></i> Carrinho
            </p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/login">
            <p className="botola3">
              <i className="fas fa-user"></i> Login
            </p>
          </NavLink>
        </li>
      </ul>
    </nav>
  </header>
);

export default Cabecada;
