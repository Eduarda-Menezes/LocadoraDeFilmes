package LocadoraDeFilmes.GUI;
import LocadoraDeFilmes.Modelos.Funcionario;
import LocadoraDeFilmes.Repositorios.FuncionariosRepositorio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class TelaFuncionarios extends JFrame {

    // Campos do formulário
    private JTextField campoNome = new JTextField(20);
    private JTextField campoCpf = new JTextField(20);
    private JTextField campoTelefone = new JTextField(20);
    private JTextField campoFuncao = new JTextField(20);

    // Área de exibição
    private JTextArea areaTexto = new JTextArea(10, 50);

    public TelaFuncionarios() {
        super("Gerenciamento de Funcionários");
        setLayout(new BorderLayout());

        // Painel de formulário
        JPanel painelFormulario = new JPanel(new GridLayout(5, 2));
        painelFormulario.add(new JLabel("Nome:"));
        painelFormulario.add(campoNome);
        painelFormulario.add(new JLabel("CPF:"));
        painelFormulario.add(campoCpf);
        painelFormulario.add(new JLabel("Telefone:"));
        painelFormulario.add(campoTelefone);
        painelFormulario.add(new JLabel("Função:"));
        painelFormulario.add(campoFuncao);

        // Painel de botões
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar Todos");
        JButton btnBuscar = new JButton("Buscar por CPF");
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
        btnCadastrar.addActionListener(e -> cadastrarFuncionario());
        btnListar.addActionListener(e -> listarFuncionarios());
        btnBuscar.addActionListener(e -> buscarPorCpf());
        btnRemover.addActionListener(e -> removerPorId());

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centraliza na tela
        setVisible(true);
    }

    private void cadastrarFuncionario() {
        try {
            FuncionariosRepositorio.criarEContratar(
                    campoNome.getText(),
                    campoTelefone.getText(),
                    campoFuncao.getText(),
                    campoCpf.getText()
            );
            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: funcionário com este CPF já existe.");
        }
    }

    private void listarFuncionarios() {
        ArrayList<Funcionario> lista = FuncionariosRepositorio.listarTodos();
        if (lista.isEmpty()) {
            areaTexto.setText("Nenhum funcionário cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder("Lista de Funcionários:\n");
            for (Funcionario f : lista) {
                sb.append("ID: ").append(f.getId())
                        .append(" | Nome: ").append(f.getNome())
                        .append(" | CPF: ").append(f.getCpf())
                        .append(" | Telefone: ").append(f.getTelefone())
                        .append(" | Função: ").append(f.getFuncao())
                        .append("\n");
            }
            areaTexto.setText(sb.toString());
        }
    }

    private void buscarPorCpf() {
        String cpf = JOptionPane.showInputDialog(this, "Digite o CPF:");
        if (cpf == null || cpf.isBlank()) return;

        try {
            Funcionario f = FuncionariosRepositorio.buscarPorCpf(cpf);
            areaTexto.setText(
                    "Funcionário encontrado:\n" +
                            "ID: " + f.getId() + "\n" +
                            "Nome: " + f.getNome() + "\n" +
                            "Telefone: " + f.getTelefone() + "\n" +
                            "Função: " + f.getFuncao()
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Funcionário não encontrado.");
        }
    }

    private void removerPorId() {
        String input = JOptionPane.showInputDialog(this, "Digite o ID do funcionário:");
        if (input == null || input.isBlank()) return;

        try {
            int id = Integer.parseInt(input);
            FuncionariosRepositorio.demitir(id);
            JOptionPane.showMessageDialog(this, "Funcionário removido com sucesso.");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Funcionário com esse ID não encontrado.");
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoCpf.setText("");
        campoTelefone.setText("");
        campoFuncao.setText("");
    }

    public static void main(String[] args) {
        new TelaFuncionarios();
    }
}