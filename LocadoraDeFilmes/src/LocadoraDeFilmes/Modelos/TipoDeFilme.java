package LocadoraDeFilmes.Modelos;

import java.util.ArrayList;


// Classe dos tipo de Filmes
public class TipoDeFilme {
    private String nome;
    private int duracao;
    private String genero;
    private ArrayList<Filme> emEstoque = new ArrayList<>();
    public ArrayList<Filme> alugados = new ArrayList<>();

    //Construtor
    public TipoDeFilme(String nome, int duracao, String genero) {
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
    }

    //Getters e Setters
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getDuracao() { return duracao; }

    public void setDuracao(int duracao) { this.duracao = duracao; }

    public String getGenero() { return genero; }

    public void setGenero(String genero) { this.genero = genero; }

    public int getQtd() { return emEstoque.size(); }

    //Metodos das Classe

    //Metodo de Solicitar aluguel de um filme, retirando ele na lista de estoque em seguida e adicionando na lista de alugados
    public Filme solicitarAluguel() {
        if (!emEstoque.isEmpty()) {
            Filme filme = emEstoque.remove(0);
            alugados.add(filme);
            return filme;
        }
        return null;
    }

    //Verificação de ID, se o id estiver no estoque vai retornar o filme e seus atributos
    public String verificarPorId (int id) {
        for (Filme f : emEstoque) {
            if (f.getId() == id) {
                return "Título: " + nome + ", Gênero: " + genero +
                        ", Duração: " + duracao + "min";
            }
        }
        return "Filme não encontrado.";
    }

    public void adicionarFilmeAoEstoque(Filme filme) { emEstoque.add(filme); }

    //Tira o filme da lisat de alugados para o estoque
    public void retornarFilme(Filme filme) {
        if (alugados.remove(filme)) {
            emEstoque.add(filme);
        }
    }
}
