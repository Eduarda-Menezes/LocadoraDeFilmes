package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.Funcionario;
import java.util.ArrayList;

public class FuncionariosRepositorio{
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void contratar(Funcionario funcionario) throws Exception{
        for (Funcionario f : funcionarios) {
            if (f.getCpf() == funcionario.getCpf()) throw new Exception();
        }
        funcionarios.add(funcionario);
    }

    public void demitir(int id) throws Exception{
        for (Funcionario f : funcionarios) {
            if (f.getId() == id){
                funcionarios.remove(f);
                return;
            }
        }
        throw new Exception();
    }

    public Funcionario buscarPorCpf(String cpf) throws Exception{
        for (Funcionario f : funcionarios) {
            if (f.getCpf() == cpf) return f;
        }
        throw new Exception();
    }

    public Funcionario buscarPorId(int id) throws Exception{
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) return f;
        }
        throw new Exception();
    }

    public ArrayList<Funcionario> listarTodos() {
        return funcionarios;
    }
}
