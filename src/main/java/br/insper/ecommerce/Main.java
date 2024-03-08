package br.insper.ecommerce;

import br.insper.ecommerce.cliente.Cliente;
import br.insper.ecommerce.cliente.ClienteService;
import br.insper.ecommerce.compra.Compra;
import br.insper.ecommerce.compra.CompraService;
import br.insper.ecommerce.compra.Item;
import br.insper.ecommerce.pagamento.Boleto;
import br.insper.ecommerce.pagamento.CartaoCredito;
import br.insper.ecommerce.pagamento.MeioPagamento;
import br.insper.ecommerce.pagamento.Pix;
import br.insper.ecommerce.produto.Produto;
import br.insper.ecommerce.produto.ProdutoService;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String opcao = "0";


        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();


        while (!opcao.equalsIgnoreCase("4")) {

            System.out.println("""
                    1 - Cadastrar Cliente
                    2 - Listar Clientes
                    3 - Excluir Cliente
                    4 - Sair
                    5 - Cadastrar Produto
                    6 - Listar Produtos
                    7 - Excluir Produto
                    8 - Cadastrar Compra
                    9 - Listar Compra
                    """);
            opcao = scanner.nextLine();
            if (opcao.equalsIgnoreCase("1")) {

                System.out.println("Digite o nome do cliente:");
                String nome = scanner.nextLine();
                System.out.println("Digite o CPF do cliente;");
                String cpf = scanner.nextLine();

                clienteService.cadastrarCliente(nome, cpf);
            }

            if (opcao.equalsIgnoreCase("2")) {

                clienteService.listarCliente();

            }

            if (opcao.equalsIgnoreCase("3")) {

                System.out.println("Digite o cpf do cliente para deletar:");
                String cpf = scanner.nextLine();

                clienteService.excluirCliente(cpf);


            }

            if (opcao.equalsIgnoreCase("5")) {

                System.out.println("Digite o nome do produto:");
                String nome = scanner.nextLine();
                System.out.println("Digite o preco do produto;");
                Double preco = scanner.nextDouble();

                produtoService.cadastrarProduto(nome, preco);
            }

            if (opcao.equalsIgnoreCase("6")) {

                produtoService.listarProdutos();


            }

            if (opcao.equalsIgnoreCase("7")) {

                System.out.println("Digite o nome do produto para deletar:");
                String nome = scanner.nextLine();

                produtoService.excluirProduto(nome);


            }



            if (opcao.equalsIgnoreCase("8")) {

                System.out.println("Digite o cpf do cliente:");
                String cpf = scanner.nextLine();
                Cliente cliente = clienteService.buscaCliente(cpf);

                System.out.println("Digite o meio de pagamento do cliente:");
                String meio = scanner.nextLine();

                MeioPagamento meioPagamento = null;
                if (meio.equalsIgnoreCase("pix")) {
                    Pix pix = new Pix();
                    System.out.println("Digite a chave do pix");
                    String chave = scanner.nextLine();
                    System.out.println("Digite a qrcode do pix");
                    String qrcode = scanner.nextLine();
                    meioPagamento = new Pix(true, LocalDateTime.now(),chave, qrcode );

                }
                if (meio.equalsIgnoreCase("cartão de crédito")) {
                    CartaoCredito cartaoCredito = new CartaoCredito();
                    System.out.println("Digite o numero do cartao");
                    String numeroCartao = scanner.nextLine();
                    System.out.println("Digite a bandeira do cartao");
                    String bandeira = scanner.nextLine();
                    meioPagamento = new CartaoCredito(true, LocalDateTime.now(), numeroCartao,bandeira);

                }
                if (meio.equalsIgnoreCase("boleto")) {
                    Boleto boleto = new Boleto();
                    System.out.println("Digite o codigo de barra");
                    String codigoBarra = scanner.nextLine();
                    meioPagamento = new Boleto(true, LocalDateTime.now(), codigoBarra);

                }

                Item item = new Item();

                System.out.println("Digite o nome do produto:");
                String nome = scanner.nextLine();
                Produto produto = produtoService.buscaProduto(nome);
                item.setProduto(produto);

                System.out.println("Digite a quantidade do produto:");
                Double quantidade = scanner.nextDouble();
                item.setQuantidade(quantidade);

                compraService.cadastrarCompra(cliente, meioPagamento, item);
            System.out.println("Compra cadastrada com sucesso");

            }

            if (opcao.equalsIgnoreCase("9")) {

                compraService.listarCompra();

            }

            }
        System.out.println("Você saiu");
    }


    }

