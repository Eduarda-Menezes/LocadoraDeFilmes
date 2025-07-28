package LocadoraDeFilmes.GUI;
import LocadoraDeFilmes.Repositorios.FilmeRepositorio;
import LocadoraDeFilmes.Modelos.Filme;
import LocadoraDeFilmes.Modelos.TipoDeFilme;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class TelaFilmes extends JFrame {

    // Campos do formulário
    private JTextField campoNome = new JTextField(20);
    private JTextField campoGenero = new JTextField(20);
    private JTextField campoDuracao = new JTextField(10);

    // Área de exibição
    private JTextArea areaTexto = new JTextArea(10, 50);

    // Repositórios
    private FilmeRepositorio filmeRepositorio = new FilmeRepositorio();
    private ArrayList<TipoDeFilme> tiposDeFilmes = new ArrayList<>();

    public TelaFilmes() {
        super("Gerenciamento de Filmes");
        setLayout(new BorderLayout());

        // Painel de formulário
        JPanel painelFormulario = new JPanel(new GridLayout(4, 2));
        painelFormulario.add(new JLabel("Título:"));
        painelFormulario.add(campoNome);
        painelFormulario.add(new JLabel("Gênero:"));
        painelFormulario.add(campoGenero);
        painelFormulario.add(new JLabel("Duração (min):"));
        painelFormulario.add(campoDuracao);

        // Painel de botões
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar Todos");
        JButton btnBuscar = new JButton("Buscar por ID");
        JButton btnRemover = new JButton("Remover por ID");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnRemover);

        // Área de texto com scroll
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        // Adiciona componentes ao JFrame
        add(painelFormulario, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        // Ações dos botões
        btnCadastrar.addActionListener(e -> cadastrarFilme());
        btnListar.addActionListener(e -> listarFilmes());
        btnBuscar.addActionListener(e -> buscarPorId());
        btnRemover.addActionListener(e -> removerPorId());

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centraliza
        setVisible(true);
    }

    private void cadastrarFilme() {
        String nome = campoNome.getText();
        String genero = campoGenero.getText();
        String duracaoStr = campoDuracao.getText();

        if (nome.isBlank() || genero.isBlank() || duracaoStr.isBlank()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        try {
            int duracao = Integer.parseInt(duracaoStr);
            TipoDeFilme tipo = new TipoDeFilme(nome, duracao, genero);
            tiposDeFilmes.add(tipo);

            Filme novoFilme = new Filme();
            tipo.adicionarFilmeAoEstoque(novoFilme);
            filmeRepositorio.adicionar(novoFilme);

            JOptionPane.showMessageDialog(this, "Filme cadastrado com sucesso! ID: " + novoFilme.getId());
            limparCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Duração inválida.");
        }
    }

    private void listarFilmes() {
        StringBuilder sb = new StringBuilder("Lista de Filmes:\n");
        for (TipoDeFilme tipo : tiposDeFilmes) {
            for (Filme f : tipo.verificarFilmesEmEstoque()) {
                sb.append("ID: ").append(f.getId())
                        .append(" | Título: ").append(tipo.getNome())
                        .append(" | Gênero: ").append(tipo.getGenero())
                        .append(" | Duração: ").append(tipo.getDuracao()).append("min")
                        .append("\n");
            }
        }

        if (sb.toString().equals("Lista de Filmes:\n")) {
            areaTexto.setText("Nenhum filme cadastrado.");
        } else {
            areaTexto.setText(sb.toString());
        }
    }

    private void buscarPorId() {
        String input = JOptionPane.showInputDialog(this, "Digite o ID do filme:");
        if (input == null || input.isBlank()) return;

        try {
            int id = Integer.parseInt(input);
            for (TipoDeFilme tipo : tiposDeFilmes) {
                String resultado = tipo.verificarPorId(id);
                if (!resultado.equals("Filme não encontrado.")) {
                    areaTexto.setText("Filme encontrado:\n" + resultado);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Filme não encontrado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void removerPorId() {
        String input = JOptionPane.showInputDialog(this, "Digite o ID do filme:");
        if (input == null || input.isBlank()) return;

        try {
            int id = Integer.parseInt(input);
            Filme filmeRemover = filmeRepositorio.buscarPorId(id);

            if (filmeRemover != null) {
                // Remove dos estoques
                for (TipoDeFilme tipo : tiposDeFilmes) {
                    tipo.verificarFilmesEmEstoque().remove(filmeRemover);
                    tipo.alugados.remove(filmeRemover);
                }
                filmeRepositorio.remover(id);
                JOptionPane.showMessageDialog(this, "Filme removido com sucesso.");
            } else {
                JOptionPane.showMessageDialog(this, "Filme não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoGenero.setText("");
        campoDuracao.setText("");
    }

    public static void main(String[] args) {
        new TelaFilmes();
    }
}