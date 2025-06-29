package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.Funcionario;
import LocadoraDeFilmes.Modelos.SolicitacaoDeAluguel;
import java.util.ArrayList;

public class SolicitacoesRepositorio {
    private ArrayList<SolicitacaoDeAluguel> solicitacoes = new ArrayList<>();

    public void adicionar(SolicitacaoDeAluguel s) {
        solicitacoes.add(s);
    }

    public SolicitacaoDeAluguel buscarPorId(int id) {
        for (SolicitacaoDeAluguel s : solicitacoes) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public ArrayList<SolicitacaoDeAluguel> listarPorFuncionario(Funcionario f) {
        ArrayList<SolicitacaoDeAluguel> resultado = new ArrayList<>();
        for (SolicitacaoDeAluguel s : solicitacoes) {
            if (s.getFuncionario().getId() == f.getId()) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public ArrayList<SolicitacaoDeAluguel> listarTodos() {
        return solicitacoes;
    }
}
