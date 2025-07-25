package LocadoraDeFilmes.Modelos;

import java.util.ArrayList;

import LocadoraDeFilmes.Negocios.Comprovante;
import LocadoraDeFilmes.Negocios.Multa;

public class SolicitacaoDeAluguel {
    private int id;
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Filme> filmes;
    private String dataLocacao;
    private String dataPrevistaDevolucao;
    private String dataDevolucao;
    private String status; // "ativa", "finalizada", "cancelada"
    private Multa multa;
    private String justificativaCancelamento;
    private String formaDePagamento;
    private static int idContador = 0;

    //Construtor
    public SolicitacaoDeAluguel(int id, Cliente cliente, Funcionario funcionario, ArrayList<Filme> filmes,
                                String dataLocacao, String dataPrevistaDevolucao) {
        this.id = idContador++;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.filmes = filmes;
        this.dataLocacao = dataLocacao;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.status = "ativa";
        this.multa = null;
    }

    //Getters e Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Funcionario getFuncionario() { return funcionario; }

    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public ArrayList<Filme> getFilmes() { return filmes; }

    public void setFilmes(ArrayList<Filme> filmes) { this.filmes = filmes; }

    public String getDataLocacao() { return dataLocacao; }

    public void setDataLocacao(String dataLocacao) { this.dataLocacao = dataLocacao; }

    public String getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }

    public void setDataPrevistaDevolucao(String dataPrevistaDevolucao) { this.dataPrevistaDevolucao = dataPrevistaDevolucao; }

    public String getDataDevolucao() { return dataDevolucao; }

    public void setDataDevolucao(String dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Multa getMulta() { return multa; }

    public void setMulta(Multa multa) { this.multa = multa; }

    public String getJustificativaCancelamento() { return justificativaCancelamento; }

    public void setJustificativaCancelamento(String justificativaCancelamento) { this.justificativaCancelamento = justificativaCancelamento; }

    public String getFormaDePagamento() { return formaDePagamento; }

    public void setFormaDePagamento(String formaDePagamento) { this.formaDePagamento = formaDePagamento; }

    //Metodos

    public String verificarStatus() { return status; }

    //Muda o status de uma compra ativa para canceelada
    public boolean cancelarLocacao(String justificativa) {
        if (status.equals("ativa")) {
            this.status = "cancelada";
            this.justificativaCancelamento = justificativa;
            return true;
        }
        return false;
    }

    //Simulação de uma compra
    public float simularValor(int qtdDias) {
        float valorBasePorFilmePorDia = 3.0f;
        return filmes.size() * qtdDias * valorBasePorFilmePorDia;
    }

    //Verifica a solicitação do pagamento, mudando o status de acordo com a compra
    public boolean solicitarPagamento() {
        if (status.equals("ativa")) {
            this.status = "finalizada";
            return true;
        }
        return false;
    }


    public Comprovante gerarComprovante() { return new Comprovante(this); }

    //Gera a multa de acordo com a devolução
    public float gerarMulta() {
        if (this.dataDevolucao != null && this.multa != null) {
            return multa.getValorTotal();
        }
        return 0;
    }
}
