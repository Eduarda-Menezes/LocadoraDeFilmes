package LocadoraDeFilmes.Modelos;

public class Filme {
    private int id;
    private static int filmeId = 0;

    public Filme() {
        id = filmeId++;
    } // Construtor vazio

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
