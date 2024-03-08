package br.insper.ecommerce.compra;

import br.insper.ecommerce.cliente.Cliente;
import br.insper.ecommerce.pagamento.MeioPagamento;

import java.util.ArrayList;

public class CompraService {

    private ArrayList<Compra> compras = new ArrayList<>();

    public void cadastrarCompra(Cliente cliente, MeioPagamento meioPagamento, Item item){
        Compra compra = new Compra(null, cliente, meioPagamento);
        compra.calculaPrecoTotal();
        compra.adicionarItem(item);
        compras.add(compra);

    }
    public void listarCompra(){
        System.out.println("Lista de compra:");
        for (Compra compra : compras) {
            System.out.println("Preço total: " + compra.getPrecoTotal());
            System.out.println("Cliente: " + compra.getCliente());
            System.out.println("Meio de pagamento: " + compra.getMeioPagamento());
        }
    }

}
