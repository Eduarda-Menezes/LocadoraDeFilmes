package LocadoraDeFilmes.Negocios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import LocadoraDeFilmes.Modelos.Cliente;
import LocadoraDeFilmes.Modelos.Filme;
import LocadoraDeFilmes.Modelos.Funcionario;
import LocadoraDeFilmes.Modelos.SolicitacaoDeAluguel;

public class Relatorio extends Documento{
    private String tipo;
    private String periodo;
    private Object dados; // Pode ser String ou ArrayList
    private Funcionario geradoPor;

    //Construtor
    public Relatorio(String tipo, String periodo, Funcionario geradoPor, String dataEmissao) {
        super(java.time.LocalDate.now().toString());
        this.tipo = tipo;
        this.periodo = periodo;
        this.geradoPor = geradoPor;
    }

    //Getters e Setters

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

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
