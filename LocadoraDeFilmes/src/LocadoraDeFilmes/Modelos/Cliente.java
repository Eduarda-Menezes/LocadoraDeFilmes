package LocadoraDeFilmes.Modelos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private String dataNascimento; // formato: "dd/MM/yyyy"
    private ArrayList<SolicitacaoDeAluguel> historicoLocacoes = new ArrayList<>();
    private ArrayList<Integer> historicoAtrasos = new ArrayList<>();
    private static int clienteIdContador = 0;

    //Construtor
    public Cliente(String nome, String cpf, String telefone,
                   String email, String endereco, String dataNascimento) {
        this.id = clienteIdContador++;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    //Getters e Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }


    //Metodos

    //Valida o CPF pela quantidade de carcters
    public boolean validarCPF() { return cpf != null && cpf.length() == 11; }

    //Valida o endereço pelo tamnho de caracters
    public boolean validarEndereco() { return endereco != null && endereco.length() >= 5; }

    // Cálculo da idade (faixa etária)

    // Trasforma a idade no formato dd/MM/yyyy e faz o calculo com o ano atual
    public int verificarFaixaEtaria() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate nascimento = LocalDate.parse(this.dataNascimento, formatter);
            LocalDate hoje = LocalDate.now();
            return Period.between(nascimento, hoje).getYears();
        } catch (Exception e) {
            System.out.println("Erro ao calcular idade: data inválida.");
            return -1;
        }
    }

    // Bloqueio para menores de 18 anos
    public boolean podeAlugarFilme18Anos() {
        int idade = verificarFaixaEtaria();
        return idade >= 18;
    }


    public ArrayList<SolicitacaoDeAluguel> consultarHistorico() { return historicoLocacoes; }

    public ArrayList<Integer> consultarAtrasos() { return historicoAtrasos; }

    public void adicionarLocacao(SolicitacaoDeAluguel locacao) { historicoLocacoes.add(locacao); }

    public void registrarAtraso(int dias) { historicoAtrasos.add(dias); }

}
