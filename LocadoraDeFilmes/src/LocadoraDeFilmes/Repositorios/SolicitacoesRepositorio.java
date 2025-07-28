package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.Cliente;
import LocadoraDeFilmes.Modelos.Filme;
import LocadoraDeFilmes.Modelos.Funcionario;
import LocadoraDeFilmes.Modelos.SolicitacaoDeAluguel;
import java.util.ArrayList;

public class SolicitacoesRepositorio {
    public static ArrayList<SolicitacaoDeAluguel> solicitacoes = new ArrayList<>();

    public static void adicionar(SolicitacaoDeAluguel s) {
        solicitacoes.add(s);
    }

    public static void criarNovaSolicitacao(Cliente cliente, Funcionario funcionario, ArrayList<Filme> filmes,
                            String dataLocacao, String dataPrevistaDevolucao){

        SolicitacaoDeAluguel nova = new SolicitacaoDeAluguel(cliente, funcionario, filmes, dataLocacao, dataPrevistaDevolucao);
        adicionar(nova);
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

    public static ArrayList<SolicitacaoDeAluguel> listarTodos() {
        return solicitacoes;
    }
}
