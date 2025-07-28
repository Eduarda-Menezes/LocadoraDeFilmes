package LocadoraDeFilmes.Negocios;

import LocadoraDeFilmes.Modelos.SolicitacaoDeAluguel;

public class Comprovante extends Documento {
    private SolicitacaoDeAluguel locacao;
    private String dataEmissao;

    //Construtor
    public Comprovante(SolicitacaoDeAluguel locacao, String dataEmissao) {
        super(dataEmissao);
        this.locacao = locacao;
        this.dataEmissao = java.time.LocalDate.now().toString();
    }

    //Getters e Setters
    public SolicitacaoDeAluguel getLocacao() { return locacao; }

    public void setLocacao(SolicitacaoDeAluguel locacao) { this.locacao = locacao; }

    public String getDataEmissao() { return dataEmissao; }

    public void setDataEmissao(String dataEmissao) { this.dataEmissao = dataEmissao; }

    //Metodos
    public void gerarPDF() {
        // Simulação apenas
        System.out.println("Comprovante gerado em PDF para a locação " + locacao.verificarStatus());
    }

    public boolean enviarEmail() {
        // Simulação de envio
        System.out.println("E-mail enviado para o cliente: " + locacao.getCliente().getEmail());
        return true;
    }
}
