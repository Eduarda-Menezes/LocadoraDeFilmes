package LocadoraDeFilmes.Negocios;

import LocadoraDeFilmes.Modelos.SolicitacaoDeAluguel;

public class Comprovante extends Documento {
    private SolicitacaoDeAluguel locacao;
    private String dataEmissao;

    // Construtor
    public Comprovante(SolicitacaoDeAluguel locacao) {
        super(java.time.LocalDate.now().toString()); // valor passado diretamente
        this.dataEmissao = java.time.LocalDate.now().toString(); // ou guardar em uma variável local e reaproveitar
        this.locacao = locacao;
    }

    // Getters e Setters
    public SolicitacaoDeAluguel getLocacao() { return locacao; }

    public void setLocacao(SolicitacaoDeAluguel locacao) { this.locacao = locacao; }

    public String getDataEmissao() { return dataEmissao; }

    public void setDataEmissao(String dataEmissao) { this.dataEmissao = dataEmissao; }

    // Métodos
    public void gerarPDF() {
        System.out.println("Comprovante gerado em PDF para a locação " + locacao.verificarStatus());
    }

    public boolean enviarEmail() {
        System.out.println("E-mail enviado para o cliente: " + locacao.getCliente().getEmail());
        return true;
    }
}
