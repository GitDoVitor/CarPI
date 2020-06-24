import React, {Component} from "react";
import {ProdutoDetalhado, produtosLista} from "./database";

const ProdutoContext = React.createContext();

class ProdutoProvider extends Component {
  state = {
    produtos: [],
    ProdutoDetalhado: ProdutoDetalhado,
    carrinho: [],
    modalAberto: false,
    modalProduto: ProdutoDetalhado,
    carrinhoSubTotal: 0,
    carrinhoTotal: 0,
    carrinhoTaxa: 0
  };
  componentDidMount() {
    this.setProdutos();
  }
  setProdutos = () => {
    let tempProdutos = [];
    produtosLista.forEach(item => {
      const itemUnico = { ...item };
      tempProdutos = [...tempProdutos, itemUnico];
    });
    this.setState(() => {
      return { produtos: tempProdutos };
    });
  };

  getItem = id => {
    const produto = this.state.produtos.find(item => item.id === id);
    return produto;
  };

  handleDetalhes = id => {
    const produto = this.getItem(id);
    this.setState(() => {
      return { ProdutoDetalhado: produto };
    });
  };
  addCarrinho = id => {
    let tempProdutos = [...this.state.produtos];
    const index = tempProdutos.indexOf(this.getItem(id));
    const produto = tempProdutos[index];
    produto.noCarrinho = true;
    produto.quantia = 1;
    const preco = produto.preco;
    produto.total = preco;
    this.setState(
      () => {
        return {
          produto: tempProdutos,
          carrinho: [...this.state.carrinho, produto]
        };
      },
      () => {
        this.addTotal();
      }
    );
  };
  abrirModal = id => {
    const produto = this.getItem(id);
    this.setState(() => {
      return { modalProduto: produto, modalAberto: true };
    });
  };

  fecharModal = () => {
    this.setState(() => {
      return { modalAberto: false };
    });
  };

  adicionar = id => {
    let tempCarrinho = [...this.state.carrinho];
    const selecionadoProduto = tempCarrinho.find(item => item.id === id);

    const index = tempCarrinho.indexOf(selecionadoProduto);
    const produto = tempCarrinho[index];

    produto.quantia = produto.quantia + 1;
    produto.total = produto.quantia * produto.preco;

    this.setState(
      () => {
        return { carrinho: [...tempCarrinho] };
      },
      () => {
        this.addTotal();
      }
    );
  };

  retirar = id => {
    let tempCarrinho = [...this.state.carrinho];
    const selecionadoProduto = tempCarrinho.find(item => item.id === id);

    const index = tempCarrinho.indexOf(selecionadoProduto);
    const produto = tempCarrinho[index];

    produto.quantia = produto.quantia - 1;

    if (produto.quantia === 0) {
      this.removerItem(id);
    } else {
      produto.total = produto.quantia * produto.preco;

      this.setState(
        () => {
          return { carrinho: [...tempCarrinho] };
        },
        () => {
          this.addTotal();
        }
      );
    }
  };

  removerItem = id => {
    let tempProdutos = [...this.state.produtos];
    let tempCarrinho = [...this.state.carrinho];

    tempCarrinho = tempCarrinho.filter(item => item.id !== id);

    const index = tempProdutos.indexOf(this.getItem(id));
    let removidoProduto = tempProdutos[index];

    removidoProduto.noCarrinho = false;
    removidoProduto.quantia = 0;
    removidoProduto.total = 0;

    this.setState(
      () => {
        return {
          carrinho: [...tempCarrinho],
          produtos: [...tempProdutos]
        };
      },
      () => {
        this.addTotal();
      }
    );
  };

  limparCarrinho = () => {
    this.setState(
      () => {
        return { carrinho: [] };
      },
      () => {
        this.setProdutos();
        this.addTotal();
      }
    );
  };

  addTotal = () => {
    let SubTotal = 0;
    this.state.carrinho.map(item => (SubTotal += item.total));
    const tempTax = SubTotal * 0.1;
    const taxa = parseFloat(tempTax.toFixed(2));
    const total = SubTotal + taxa;
    this.setState(() => {
      return {
        carrinhoSubTotal: SubTotal,
        carrinhoTaxa: taxa,
        carrinhoTotal: total
      };
    });
  };
  render() {
    return (
      <ProdutoContext.Provider
        value={{
          ...this.state,
          handleDetalhes: this.handleDetalhes,
          addCarrinho: this.addCarrinho,
          abrirModal: this.abrirModal,
          fecharModal: this.fecharModal,
          adicionar: this.adicionar,
          retirar: this.retirar,
          removerItem: this.removerItem,
          limparCarrinho: this.limparCarrinho
        }}
      >
        {this.props.children}
      </ProdutoContext.Provider>
    );
  }
}

const ProdutoConsumer = ProdutoContext.Consumer;

export { ProdutoConsumer, ProdutoProvider };
