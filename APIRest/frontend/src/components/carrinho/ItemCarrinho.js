export default function ItemCarrinho({ item, value }) {
  const { id, nome, img, preco, total, quantia } = item;
  const { adicionar, retirar, removerItem } = value;
  return (
    <div className="row my-2 text-center">
      <div className="col-10 mx-auto col-lg-2">
        <img
          src={img}
          style={{ width: "5rem", height: "5rem" }}
          className="img-fluid"
          alt="Lanche"
        />
      </div>
      <div className="col-10 mx-auto col-lg-2">
        <span className="d-lg-none">Produto: </span>
        {nome}
      </div>
      <div className="col-10 mx-auto col-lg-2">
        <span className="d-lg-none">Valor: </span>
        <span>R$</span>
        {preco}
        <span>,00</span>
      </div>
      <div className="col-10 mx-auto col-lg-2 my-2 my-lg-0">
        <div className="d-flex justify-content-center">
          <div>
            <span className="btn btn-black mx-1" onClick={() => retirar(id)}>
              -
            </span>
            <span className="btn btn-black mx-1">{quantia}</span>
            <span className="btn btn-black mx-1" onClick={() => adicionar(id)}>
              +
            </span>
          </div>
        </div>
      </div>
      <div className="col-10 mx-auto col-lg-2">
        <div className="carrinho-icon" onClick={() => removerItem(id)}>
          <i className="fas fa-trash"></i>
        </div>
      </div>
      <div className="col-10 mx-auto col-lg-2">
        <strong className="d-lg-none">Valor Total: </strong>
        <strong>
          <span>R$</span>
          {total}
          <span>,00</span>
        </strong>
      </div>
    </div>
  );
}
