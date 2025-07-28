package LocadoraDeFilmes.GUI;

import LocadoraDeFilmes.Modelos.*;
import LocadoraDeFilmes.Negocios.Relatorio;
import LocadoraDeFilmes.Negocios.Multa;
import LocadoraDeFilmes.Negocios.Comprovante;
import LocadoraDeFilmes.Repositorios.ClienteRepositorio;
import LocadoraDeFilmes.Repositorios.FuncionariosRepositorio;
import LocadoraDeFilmes.Repositorios.FilmeRepositorio;
import LocadoraDeFilmes.Repositorios.SolicitacoesRepositorio;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class TelaLocacao extends JFrame {

    // --- Aba Nova Locação ---
    private JTextField campoIdCliente = new JTextField(10);
    private JTextField campoIdFilme = new JTextField(10);
    private JTextField campoDataLocacao = new JTextField(10);
    private JTextField campoDataDevolucao = new JTextField(10);
    private JTextArea areaTextoLocacao = new JTextArea(8, 40);

    // --- Aba Comprovante ---
    private JTextField campoIdLocacao = new JTextField(10);
    private JTextArea areaTextoComprovante = new JTextArea(8, 40);

    // --- Aba Multa (layout básico) ---
    private JTextField campoDiasAtraso = new JTextField(10);
    private JTextField campoValorPorDia = new JTextField(10);
    private JTextField campoDataEmissaoMulta = new JTextField(10);
    private JTextArea areaTextoMulta = new JTextArea(8, 40);

    // --- Aba Relatório (layout básico) ---
    private JTextArea areaTextoRelatorio = new JTextArea(15, 40);

    public TelaLocacao() {
        super("Gerenciamento de Locação");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();

        abas.add("Nova Locação", criarPainelNovaLocacao());
        abas.add("Comprovante", criarPainelComprovante());
        abas.add("Multa", criarPainelMulta());
        abas.add("Relatório", criarPainelRelatorio());

        add(abas);

        setVisible(true);
    }

    private JPanel criarPainelNovaLocacao() {
        JPanel painel = new JPanel(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        painelFormulario.add(new JLabel("ID Cliente:"));
        painelFormulario.add(campoIdCliente);
        painelFormulario.add(new JLabel("ID Filme:"));
        painelFormulario.add(campoIdFilme);
        painelFormulario.add(new JLabel("Data Locação (dd/MM/yyyy):"));
        painelFormulario.add(campoDataLocacao);
        painelFormulario.add(new JLabel("Data Devolução Prevista (dd/MM/yyyy):"));
        painelFormulario.add(campoDataDevolucao);

        JButton btnRegistrar = new JButton("Registrar Locação");
        btnRegistrar.addActionListener(e -> registrarLocacao());

        JPanel painelBotao = new JPanel();
        painelBotao.add(btnRegistrar);

        areaTextoLocacao.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTextoLocacao);

        painel.add(painelFormulario, BorderLayout.NORTH);
        painel.add(painelBotao, BorderLayout.CENTER);
        painel.add(scroll, BorderLayout.SOUTH);

        return painel;
    }

    private void registrarLocacao() {
        try {
            int idCliente = Integer.parseInt(campoIdCliente.getText().trim());
            int idFilme = Integer.parseInt(campoIdFilme.getText().trim());
            String dataLocacao = campoDataLocacao.getText().trim();
            String dataDevolucao = campoDataDevolucao.getText().trim();

            // Buscar cliente e filme pelos IDs (supondo métodos em seus repositórios)
            Cliente cliente = ClienteRepositorio.buscarPorId(idCliente);
            Filme filme = FilmeRepositorio.buscarPorId(idFilme);

            if (cliente == null) {
                areaTextoLocacao.setText("Cliente não encontrado com ID: " + idCliente);
                return;
            }
            if (filme == null) {
                areaTextoLocacao.setText("Filme não encontrado com ID: " + idFilme);
                return;
            }

            // Criar lista com o filme para o método de criação da solicitação
            ArrayList<Filme> filmes = new ArrayList<>();
            filmes.add(filme);

            // Criar nova solicitação de locação
            SolicitacoesRepositorio.criarNovaSolicitacao(cliente, null, filmes, dataLocacao, dataDevolucao);
            areaTextoLocacao.setText("Locação registrada com sucesso!\nCliente: " + cliente.getNome() + "\nFilme: " + TipoDeFilme.getNome());

            limparCamposNovaLocacao();

        } catch (NumberFormatException nfe) {
            areaTextoLocacao.setText("IDs inválidos. Informe números válidos.");
        } catch (Exception ex) {
            areaTextoLocacao.setText("Erro ao registrar locação: " + ex.getMessage());
        }
    }

    private void limparCamposNovaLocacao() {
        campoIdCliente.setText("");
        campoIdFilme.setText("");
        campoDataLocacao.setText("");
        campoDataDevolucao.setText("");
    }

    private JPanel criarPainelComprovante() {
        JPanel painel = new JPanel(new BorderLayout());

        JPanel painelInput = new JPanel(new FlowLayout());
        painelInput.add(new JLabel("ID da Locação:"));
        painelInput.add(campoIdLocacao);
        JButton btnGerar = new JButton("Gerar Comprovante");
        btnGerar.addActionListener(e -> gerarComprovante());
        painelInput.add(btnGerar);

        areaTextoComprovante.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTextoComprovante);

        painel.add(painelInput, BorderLayout.NORTH);
        painel.add(scroll, BorderLayout.CENTER);

        return painel;
    }

    private void gerarComprovante() {
        try {
            int idLocacao = Integer.parseInt(campoIdLocacao.getText().trim());
            SolicitacaoDeAluguel locacao = SolicitacoesRepositorio.listarTodos()
                    .stream()
                    .filter(s -> s.getId() == idLocacao)
                    .findFirst()
                    .orElse(null);

            if (locacao == null) {
                areaTextoComprovante.setText("Locação não encontrada para ID: " + idLocacao);
                return;
            }

            Comprovante comprovante = new Comprovante(locacao);
            comprovante.gerarPDF();
            comprovante.enviarEmail();

            areaTextoComprovante.setText("Comprovante gerado para locação ID: " + idLocacao + "\nCliente: " + locacao.getCliente().getNome());

            limparCamposComprovante();

        } catch (NumberFormatException nfe) {
            areaTextoComprovante.setText("ID inválido. Informe um número válido.");
        } catch (Exception ex) {
            areaTextoComprovante.setText("Erro ao gerar comprovante: " + ex.getMessage());
        }
    }

    private void limparCamposComprovante() {
        campoIdLocacao.setText("");
    }

    private JPanel criarPainelMulta() {
        JPanel painel = new JPanel(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
        painelFormulario.add(new JLabel("Dias de Atraso:"));
        painelFormulario.add(campoDiasAtraso);
        painelFormulario.add(new JLabel("Valor por Dia:"));
        painelFormulario.add(campoValorPorDia);
        painelFormulario.add(new JLabel("Data de Emissão:"));
        painelFormulario.add(campoDataEmissaoMulta);

        JButton btnCalcularMulta = new JButton("Calcular Multa");
        btnCalcularMulta.addActionListener(e -> calcularMulta());

        JPanel painelBotao = new JPanel();
        painelBotao.add(btnCalcularMulta);

        areaTextoMulta.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTextoMulta);

        painel.add(painelFormulario, BorderLayout.NORTH);
        painel.add(painelBotao, BorderLayout.CENTER);
        painel.add(scroll, BorderLayout.SOUTH);

        return painel;
    }

    private void calcularMulta() {
        try {
            int diasAtraso = Integer.parseInt(campoDiasAtraso.getText().trim());
            float valorPorDia = Float.parseFloat(campoValorPorDia.getText().trim());
            String dataEmissao = campoDataEmissaoMulta.getText().trim();

            Multa multa = new Multa(diasAtraso, valorPorDia, dataEmissao);
            areaTextoMulta.setText("Multa calculada:\nDias Atraso: " + multa.getDiasAtraso()
                    + "\nValor por Dia: " + multa.getValorPorDia()
                    + "\nValor Total: " + multa.getValorTotal());

            limparCamposMulta();

        } catch (NumberFormatException nfe) {
            areaTextoMulta.setText("Digite valores válidos para dias e valor por dia.");
        }
    }

    private void limparCamposMulta() {
        campoDiasAtraso.setText("");
        campoValorPorDia.setText("");
        campoDataEmissaoMulta.setText("");
    }

    private JPanel criarPainelRelatorio() {
        JPanel painel = new JPanel(new BorderLayout());

        JButton btnGerarRelatorio = new JButton("Gerar Relatório (exemplo)");
        btnGerarRelatorio.addActionListener(e -> gerarRelatorio());

        JPanel painelBotao = new JPanel();
        painelBotao.add(btnGerarRelatorio);

        areaTextoRelatorio.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTextoRelatorio);

        painel.add(painelBotao, BorderLayout.NORTH);
        painel.add(scroll, BorderLayout.CENTER);

        return painel;
    }

    private void gerarRelatorio() {
        // Exemplo simples de relatório que une dados
        StringBuilder sb = new StringBuilder("Relatório de Locações\n\n");

        ArrayList<SolicitacaoDeAluguel> todasLocacoes = SolicitacoesRepositorio.listarTodos();
        if (todasLocacoes.isEmpty()) {
            sb.append("Nenhuma locação registrada.");
        } else {
            for (SolicitacaoDeAluguel s : todasLocacoes) {
                sb.append("ID: ").append(s.getId())
                        .append(" | Cliente: ").append(s.getCliente().getNome())
                        .append(" | Filme(s): ");

                for (Filme f : s.getFilmes()) {
                    sb.append(f.getId()).append(", ");
                }
                sb.append(" | Data Locação: ").append(s.getDataLocacao())
                        .append(" | Data Prev. Devolução: ").append(s.getDataPrevistaDevolucao())
                        .append("\n");
            }
        }

        areaTextoRelatorio.setText(sb.toString());
    }

    public static void main(String[] args) {
        new TelaLocacao();
    }
}

