package LocadoraDeFilmes.Modelos;

public interface Pessoa {
    
    public int getId();

    public void setId(int id);

    public String getNome();

    public void setNome(String nome);

    public String getCpf();

    public void setCpf(String cpf);

    public String getTelefone();

    public void setTelefone(String telefone);

    public boolean validarCPF();

}
