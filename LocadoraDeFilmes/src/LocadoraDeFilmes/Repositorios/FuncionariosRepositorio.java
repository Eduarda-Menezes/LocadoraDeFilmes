package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.Funcionario;
import java.util.ArrayList;

public class FuncionariosRepositorio{
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void contratar(Funcionario funcionario) throws Exception{
        for (Funcionario f : funcionarios) {
            if (f.getCpf() == funcionario.getCpf()) throw new Exception();
        }
        funcionarios.add(funcionario);
    }

    public static void criarEContratar(String nome, String telefone, String funcao, String cpf){
        Funcionario funcionario = new Funcionario(nome, telefone, funcao, cpf);
        try {
            contratar(funcionario);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("funcionario já existe");
        }
    }

    public static void demitir(int id) throws Exception{
        for (Funcionario f : funcionarios) {
            if (f.getId() == id){
                funcionarios.remove(f);
                return;
            }
        }
        throw new Exception();
    }

    public static Funcionario buscarPorCpf(String cpf) throws Exception{
        for (Funcionario f : funcionarios) {
            if (f.getCpf() == cpf) return f;
        }
        throw new Exception();
    }

    public static Funcionario buscarPorId(int id) throws Exception{
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) return f;
        }
        throw new Exception();
    }

    public static ArrayList<Funcionario> listarTodos() {
        return funcionarios;
    }
}
