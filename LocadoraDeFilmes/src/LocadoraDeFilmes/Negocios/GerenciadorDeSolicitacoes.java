package LocadoraDeFilmes.Negocios;

import LocadoraDeFilmes.Modelos.Funcionario;
import LocadoraDeFilmes.Modelos.SolicitacaoDeAluguel;
import java.util.ArrayList;

public class GerenciadorDeSolicitacoes {
    private ArrayList<SolicitacaoDeAluguel> listaSolicitacoes = new ArrayList<>();

    public void adicionar(SolicitacaoDeAluguel s) {
        listaSolicitacoes.add(s);
    }

    public SolicitacaoDeAluguel verificar(int id) {
        for (SolicitacaoDeAluguel s : listaSolicitacoes) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public ArrayList<SolicitacaoDeAluguel> verificarPorFuncionario(Funcionario f) {
        ArrayList<SolicitacaoDeAluguel> resultado = new ArrayList<>();
        for (SolicitacaoDeAluguel s : listaSolicitacoes) {
            if (s.getFuncionario().getId() == f.getId()) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public ArrayList<SolicitacaoDeAluguel> listarTodas() {
        return listaSolicitacoes;
    }
}
