package br.insper.ecommerce.compra;

import br.insper.ecommerce.cliente.Cliente;
import br.insper.ecommerce.produto.Produto;

public class Item {
    private Double quantidade;
    private Produto produto;

    public Item() {

    }

    public Item(Double quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
