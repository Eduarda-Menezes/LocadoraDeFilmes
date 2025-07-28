package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.TipoDeFilme;
import LocadoraDeFilmes.Modelos.Cliente;
import LocadoraDeFilmes.Modelos.Filme;
import LocadoraDeFilmes.Modelos.Funcionario;

import java.util.ArrayList;

public class GerenciadorDeEstoque {
    private ArrayList<TipoDeFilme> estoqueDeTipos = new ArrayList<>();

    public void addTipo(TipoDeFilme tipo) {
        estoqueDeTipos.add(tipo);
    }

    public void criarNovoTipo(String nome, int duracao, String genero){
        TipoDeFilme tipo = new TipoDeFilme(nome, duracao, genero);
        addTipo(tipo);
    }

    public ArrayList<TipoDeFilme> getEstoque() {
        return estoqueDeTipos;
    }

    public TipoDeFilme getTipo(String nome) {
        for (TipoDeFilme tipo : estoqueDeTipos) {
            if (tipo.getNome().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        return null;
    }

    public String verificarPorId(int id) {
        for (TipoDeFilme tipo : estoqueDeTipos) {
            String resultado = tipo.verificarPorId(id);
            if (!resultado.equals("Filme não encontrado.")) {
                return resultado;
            }
        }
        return "Filme não encontrado.";
    }

    public Filme solicitarAluguel(String nomeTipo, Cliente cliente, Funcionario funcionario){
        TipoDeFilme tipo = getTipo(nomeTipo);
        if (tipo != null) {
            try{
                return tipo.solicitarAluguel(cliente, funcionario);
            }
            catch(Exception e){
                System.out.println("Não foi possível solicitar aluguel");
            }
            
        }
        return null;
    }

    public void retornoAluguel(int id) {
        for (TipoDeFilme tipo : estoqueDeTipos) {
            for (Filme f : tipo.alugados) {
                if (f.getId() == id) {
                    tipo.retornarFilme(f);
                    return;
                }
            }
        }
    }
}
