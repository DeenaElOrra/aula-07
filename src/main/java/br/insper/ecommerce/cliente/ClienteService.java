package br.insper.ecommerce.cliente;

import java.util.ArrayList;

public class ClienteService {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        if (nome.equals("") || cpf.equals("")) {
            System.out.println("Dados do cliente invalido.");
        } else {
            Cliente cliente = new Cliente(nome, cpf, null);
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso.");
        }
    }

    public void listarCliente() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
        }
    }

    public Cliente buscaCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cpf.equals(cliente.getCpf())) {
                return cliente;
            }
        }
        return null;
    }
    public void excluirCliente(String cpf) {
        Cliente clienteRemover = null;
        for (Cliente cliente : clientes) {
            if (cpf.equalsIgnoreCase(cliente.getCpf())) {
                clienteRemover = cliente;
            }
        }
        if (clienteRemover != null) {
            System.out.println("Cliente removido com sucesso");
            clientes.remove(clienteRemover);
        } else {

            System.out.println("Cliente não encontrado");
        }
    }
}

// no java , eu nao posso remover um cliente iterando na lista ao mesmo tempo. Primeiro eu tenho que iterar, depois remover.
