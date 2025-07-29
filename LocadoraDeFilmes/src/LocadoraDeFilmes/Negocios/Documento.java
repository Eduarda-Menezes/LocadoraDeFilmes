package LocadoraDeFilmes.Negocios;

public class Documento {
    private int id;
    protected String dataEmissao;
    private static int documentId = 0;

    public Documento(String dataEmissao){
        this.id = documentId++;
        this.dataEmissao = dataEmissao;
    }

    public int getId() { return id; }

    public String getDataEmissao() { return dataEmissao; }

    public void setDataEmissao(String dataEmissao) { this.dataEmissao = dataEmissao; }

    public void gerarPDF() {
        System.out.println("pdf criado");
    }

}
