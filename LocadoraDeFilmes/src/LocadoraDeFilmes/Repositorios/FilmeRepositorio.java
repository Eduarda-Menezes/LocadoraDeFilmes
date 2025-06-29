package LocadoraDeFilmes.Repositorios;

import LocadoraDeFilmes.Modelos.Filme;
import java.util.ArrayList;

public class FilmeRepositorio {
    private ArrayList<Filme> filmes = new ArrayList<>();

    public void adicionar(Filme filme) {
        filmes.add(filme);
    }

    public void remover(int id) {
        filmes.removeIf(f -> f.getId() == id);
    }

    public Filme buscarPorId(int id) {
        for (Filme f : filmes) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    public ArrayList<Filme> listarTodos() {
        return filmes;
    }
}
