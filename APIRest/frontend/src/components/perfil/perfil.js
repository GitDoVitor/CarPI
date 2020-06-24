import Cabeca from '../cabecada/cabecada';
import Footer from '../rodape/Rodape';
import Divisor from '../divisor/Divisor';
import './perfil.scss';

function perfil () {
    return(
        <div>
            <Cabeca />
            <div className="toppag">
                <h1>Meu Perfil</h1>
            </div>
            <h3>Reveja ou edite suas informações de perfil</h3>
            <div className="divi">
                <div className="info">
                    <h6><strong>Suas informações</strong></h6>
                    <p>Gustavo Artmann</p>
                    <p>Email aleatório</p>
                    <p>Telefone de alguém</p>
                </div>
                <div className="casa">
                    <h6><strong>Endereços registrados</strong></h6>
                    <p>Cidade - Estado</p>
                    <p>Rua, Bairro, CEP</p>
                    <p>Complemento</p>
                </div>
                <button className="botona">Editar informações</button>
            </div>
            <Divisor />
            <h3>Relembre seus ultimos pedidos</h3>
            <div className="ultimo">
                <div className="pedido">
                    <p>Não foram feitos pedidos ainda</p>
                </div>
            </div>
            <Footer />
        </div>
    )
}

export default perfil;
