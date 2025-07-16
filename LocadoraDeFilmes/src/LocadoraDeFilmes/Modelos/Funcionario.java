package LocadoraDeFilmes.Modelos;

public class Funcionario {
    private String nome;
    private int id;
    private String telefone;
    private String funcao;
    private String cpf;

    //Construtor
    public Funcionario(int id, String nome, String telefone, String funcao, String cpf) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.funcao = funcao;
        this.cpf = cpf;
    }

    //Getters e Setters
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getFuncao() { return funcao; }

    public void setFuncao(String funcao) { this.funcao = funcao; }

    public String getCpf(){ return cpf; }
}
