import {Component} from "react";

export default class Rodape extends Component {
  render() {
    return (
      <footer
        style={{ backgroundColor: "#d8d8d8" }}
        className="page-footer mt-5 pt-4"
      >
        <div className="container">
          <ul className="list-unstyled list-inline text-center">
            <li className="list-inline-item">
              <a href="https://www.facebook.com/Carburgeroficial/"className="btn-floating btn-lg btn-fb" target="_blank" rel="noopener noreferrer">
                <i className="fab fa-facebook-f"></i>
              </a>
            </li>
            <li className="list-inline-item">
              <a href="https://www.instagram.com/carburger.foz/?hl=pt-br"className="btn-floating btn-lg btn-ins text-danger" target="_blank" rel="noopener noreferrer">
                <i className="fab fa-instagram"></i>
              </a>
            </li>
            <li className="list-inline-item">
              <a href="https://www.whatsapp.com/business/"className="btn-floating btn-lg btn-whatsapp text-success" target="_blank" rel="noopener noreferrer">
                <i className="fab fa-whatsapp"></i>
              </a>
            </li>
          </ul>
        </div>
        <div className="footer-copyright text-center py-3">
          <a href="https://linktr.ee/carburger.foz" style={{color: 'black'}} target="_blank" rel="noopener noreferrer">© 2019 Copyright</a>
        </div>
      </footer>
    );
  }
}
