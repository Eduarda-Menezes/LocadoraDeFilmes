package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.Cliente;
import java.util.ArrayList;

public class ClienteRepositorio {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }

    public void remover(int id) {
        clientes.removeIf(c -> c.getId() == id);
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    public ArrayList<Cliente> listarTodos() {
        return clientes;
    }
}
