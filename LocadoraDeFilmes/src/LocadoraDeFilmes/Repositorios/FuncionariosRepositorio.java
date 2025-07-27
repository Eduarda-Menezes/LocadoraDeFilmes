package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.Funcionario;
import java.util.ArrayList;

public class FuncionariosRepositorio {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void contratar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void demitir(int id) {
        funcionarios.removeIf(f -> f.getId() == id);
    }

    public Funcionario buscarPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    public ArrayList<Funcionario> listarTodos() {
        return funcionarios;
    }
}
