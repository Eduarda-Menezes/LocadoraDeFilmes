package LocadoraDeFilmes.Negocios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import LocadoraDeFilmes.Modelos.Cliente;
import LocadoraDeFilmes.Modelos.Filme;
import LocadoraDeFilmes.Modelos.Funcionario;
import LocadoraDeFilmes.Modelos.SolicitacaoDeAluguel;

public class Relatorio {
    private int id;
    private String tipo;
    private String dataGeracao;
    private String periodo;
    private Object dados; // Pode ser String ou ArrayList
    private Funcionario geradoPor;

    //Construtor
    public Relatorio(int id, String tipo, String periodo, Funcionario geradoPor) {
        this.id = id;
        this.tipo = tipo;
        this.periodo = periodo;
        this.dataGeracao = java.time.LocalDate.now().toString();
        this.geradoPor = geradoPor;
    }

    //Getters e Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDataGeracao() { return dataGeracao; }

    public void setDataGeracao(String dataGeracao) { this.dataGeracao = dataGeracao; }

    public String getPeriodo() { return periodo; }

    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public Object getDados() { return dados; }

    public void setDados(Object dados) { this.dados = dados; }

    public Funcionario getGeradoPor() { return geradoPor; }

    public void setGeradoPor(Funcionario geradoPor) { this.geradoPor = geradoPor; }

    //Metodos

    public ArrayList<Filme> gerarMaisAlugados(String periodo) {
        return new ArrayList<>();
    }

    public ArrayList<Cliente> gerarClientesMaisAtivos() {
        return new ArrayList<>();
    }

    public ArrayList<SolicitacaoDeAluguel> gerarLocacoesPorCliente(Cliente cliente) {
        return cliente.consultarHistorico();
    }

    public Map<String, ArrayList<Cliente>> gerarPorFaixaEtaria() {
        Map<String, ArrayList<Cliente>> mapa = new HashMap<>();
        return mapa;
    }

    public String gerarMelhorMes() {
        return "Maio";
    }
}
