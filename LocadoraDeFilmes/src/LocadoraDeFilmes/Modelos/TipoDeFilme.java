package LocadoraDeFilmes.Modelos;

import java.util.ArrayList;

import LocadoraDeFilmes.Repositorios.SolicitacoesRepositorio;


// Classe dos tipo de Filmes
public class TipoDeFilme {
    private static String nome;
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
    public static String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getDuracao() { return duracao; }

    public void setDuracao(int duracao) { this.duracao = duracao; }

    public String getGenero() { return genero; }

    public void setGenero(String genero) { this.genero = genero; }

    public int getQtd() { return emEstoque.size(); }

    //Metodos das Classe

    //Metodo de Solicitar aluguel de um filme, retirando ele na lista de estoque em seguida e adicionando na lista de alugados
    public Filme solicitarAluguel(Cliente cliente, Funcionario funcionario) throws Exception{
        if (!emEstoque.isEmpty()) {
            ArrayList<Filme> listaFilmes = new ArrayList<>();
            Filme filme = emEstoque.remove(0);
            listaFilmes.add(filme);
            SolicitacoesRepositorio.criarNovaSolicitacao(cliente, funcionario, listaFilmes, "01/01/2000", "03/01/2000");
            alugados.add(filme);
            return filme;
        }
        throw new Exception();
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

    public void adicionarFilmeAoEstoque(Filme filme) { 
        emEstoque.add(filme); 
    }

    public void criarEAdicionar(){
        Filme filme = new Filme();
        adicionarFilmeAoEstoque(filme);
    }

    //Tira o filme da lisat de alugados para o estoque
    public void retornarFilme(Filme filme) {
        if (alugados.remove(filme)) {
            emEstoque.add(filme);
        }
    }

    //Verifica se tem o filme em estoque
    public ArrayList<Filme> verificarFilmesEmEstoque() {
        return emEstoque;
    }
}
