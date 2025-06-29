package LocadoraDeFilmes.Negocios;

import LocadoraDeFilmes.Modelos.Funcionario;

import java.util.ArrayList;

public class GerenciadorDeFuncionarios {
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

    public void contratar(String nome, String telefone, String funcao) {
        int novoId = listaFuncionarios.size() + 1;
        Funcionario f = new Funcionario(novoId, nome, telefone, funcao);
        listaFuncionarios.add(f);
    }

    public void demitir(int id) {
        listaFuncionarios.removeIf(f -> f.getId() == id);
    }

    public Funcionario getFuncionario(int id) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    public ArrayList<Funcionario> listarTodos() {
        return listaFuncionarios;
    }
}
