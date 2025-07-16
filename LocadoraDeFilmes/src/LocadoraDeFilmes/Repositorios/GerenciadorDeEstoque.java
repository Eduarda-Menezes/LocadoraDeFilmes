package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.TipoDeFilme;
import LocadoraDeFilmes.Modelos.Filme;
import java.util.ArrayList;

public class GerenciadorDeEstoque {
    private ArrayList<TipoDeFilme> estoqueDeTipos = new ArrayList<>();

    public void addTipo(TipoDeFilme tipo) {
        estoqueDeTipos.add(tipo);
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

    public Filme solicitarAluguel(String nomeTipo){
        TipoDeFilme tipo = getTipo(nomeTipo);
        if (tipo != null) {
            try{
                return tipo.solicitarAluguel();
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
