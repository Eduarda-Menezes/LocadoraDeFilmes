package LocadoraDeFilmes.Modelos;

public class Multa {
    private int id;
    private int diasAtraso;
    private float valorPorDia;
    private float valorTotal;

    //Construtor
    public Multa(int id, int diasAtraso, float valorPorDia) {
        this.id = id;
        this.diasAtraso = diasAtraso;
        this.valorPorDia = valorPorDia;
        this.valorTotal = diasAtraso * valorPorDia;
    }

    //Getters e Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getDiasAtraso() { return diasAtraso; }

    public void setDiasAtraso(int diasAtraso) { this.diasAtraso = diasAtraso; }

    public float getValorPorDia() { return valorPorDia; }

    public void setValorPorDia(float valorPorDia) { this.valorPorDia = valorPorDia; }

    public float getValorTotal() { return valorTotal; }

    public void setValorTotal(float valorTotal) { this.valorTotal = valorTotal; }
}
