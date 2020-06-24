import ReactDOM from "react-dom";
import App from "./App";
import "./index.scss";
import {BrowserRouter as Router} from "react-router-dom";
import * as serviceWorker from "./serviceWorker";
import {ProdutoProvider} from "./components/databaseLanches/context";

ReactDOM.render(
  <ProdutoProvider>
    <Router>
      <App />
    </Router>
  </ProdutoProvider>,

  document.getElementById("root")
);

serviceWorker.unregister();
