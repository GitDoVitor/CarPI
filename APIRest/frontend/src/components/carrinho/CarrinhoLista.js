import ItemCarrinho from "./ItemCarrinho";

export default function CarrinhoLista({ value }) {
  const { carrinho } = value;
  console.log(value, carrinho);

  return (
    <div className="container-fluid">
      {carrinho.map(item => {
        return <ItemCarrinho key={item.id} item={item} value={value} />;
      })}
    </div>
  );
}
