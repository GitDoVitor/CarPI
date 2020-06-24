import {Component} from 'react';
import Divisor from '../divisor/Divisor';
import Cabecalho from '../cabecalho/Cabecalho';
import Rodape from '../rodape/Rodape';
import Rest from '../../img/rest.jpg';
import IMG from '../../img/local.jpg';
import './landing.scss';


class App extends Component {
	render() {
    	return (
      		<div>
				<Cabecalho />
				<div className="chamada">
					<h1>
          				<strong> Os Melhores Hambúrgueres da Cidade!</strong>
        			</h1>
				</div>
				<div className="chamadaPromo">
      <div className="content">
        <h1>Todo Dia Uma Promoção Diferente</h1>
        <p>
          Eu laborum tempor quis deserunt enim cillum consectetur laboris
          voluptate dolore eu incididunt nostrud sint. Id nisi velit ea nisi non
          laboris id. Ea eu mollit deserunt ullamco deserunt fugiat. Pariatur
          velit magna irure amet.
        </p>
      </div>
    </div>				
				<Divisor />
				<div className="wrap">
            <div className="text">
                <h1>Algumas Curiosidades Sobre Nós</h1>
                <p> Eu eiusmod laboris labore consectetur laboris aute velit incididunt reprehenderit nostrud. Veniam commodo
                mnim ut veniam nulla Lorem ea magna dolore nostrud.</p>
            </div>
            <div data-aos="fade-left">
                <img src={Rest} className="img1" alt="restaurante" />
            </div>
        </div>
		<div className="eve">
        <div
          data-aos="fade-right"
          data-aos-offset="300"
          data-aos-easing="ease-in-sine"
        >
          <img src={IMG} className="img" alt="restaurante" />
        </div>
        <div className="texto">
          <h1>Eventos Feitos Especialmente para Você</h1>
          <p>
            Eu eiusmod laboris labore consectetur laboris aute velit incididunt
            reprehenderit nostrud. Veniam commodo minim ut veniam nulla Lorem ea
            magna dolore nostrud.
          </p>
        </div>
      </div>

		<Rodape />
      		</div>
    	);
  	}
}



export default App;

