package LocadoraDeFilmes.Negocios;

public class Multa extends Documento{
    private int diasAtraso;
    private float valorPorDia;
    private float valorTotal;

    //Construtor
    public Multa(int diasAtraso, float valorPorDia, String dataEmissao) {
        super(dataEmissao);
        this.diasAtraso = diasAtraso;
        this.valorPorDia = valorPorDia;
        this.valorTotal = diasAtraso * valorPorDia;
    }

    //Getters e Setters

    public int getDiasAtraso() { return diasAtraso; }

    public void setDiasAtraso(int diasAtraso) { this.diasAtraso = diasAtraso; }

    public float getValorPorDia() { return valorPorDia; }

    public void setValorPorDia(float valorPorDia) { this.valorPorDia = valorPorDia; }

    public float getValorTotal() { return valorTotal; }

    public void setValorTotal(float valorTotal) { this.valorTotal = valorTotal; }
}
