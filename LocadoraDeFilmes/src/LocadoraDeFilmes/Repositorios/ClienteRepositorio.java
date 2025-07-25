package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.Cliente;
import java.util.ArrayList;

public class ClienteRepositorio {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente) throws Exception{
        for (Cliente c : clientes) {
            if (c.getCpf() == cliente.getCpf()) throw new Exception();
        }
        clientes.add(cliente);
    }

    public void criarNovoCliente(String nome, String cpf, String telefone,
                   String email, String endereco, String dataNascimento){
        
        Cliente novo = new Cliente(nome, cpf, telefone, email, endereco, dataNascimento);
        try {
            adicionar(novo);
        } catch (Exception e) {
            System.out.println("cliente já existe");
        }
    }

    public void remover(int id) throws Exception{
        for (Cliente c : clientes) {
            if (c.getId() == id){
                clientes.remove(c);
                return;
            }
        }
        throw new Exception();
    }

    public Cliente buscarPorId(int id) throws Exception{
        for (Cliente c : clientes) {
            if (c.getId() == id) return c;
        }
        throw new Exception();
    }

    public Cliente buscarPorCpf(String cpf) throws Exception{
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        throw new Exception();
    }

    public ArrayList<Cliente> listarTodos() {
        return clientes;
    }
}
