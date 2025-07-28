package LocadoraDeFilmes.GUI;
import LocadoraDeFilmes.Repositorios.ClienteRepositorio;
import LocadoraDeFilmes.Modelos.Cliente;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import LocadoraDeFilmes.Repositorios.ClienteRepositorio;

public class TelaClientes extends JFrame {

    // Campos do formulário
    private JTextField campoNome = new JTextField(20);
    private JTextField campoCpf = new JTextField(20);
    private JTextField campoTelefone = new JTextField(20);
    private JTextField campoEmail = new JTextField(20);
    private JTextField campoEndereco = new JTextField(20);
    private JTextField campoNascimento = new JTextField(10);

    // Área de exibição
    private JTextArea areaTexto = new JTextArea(10, 50);

    public TelaClientes() {
        super("Gerenciamento de Clientes");
        setLayout(new BorderLayout());

        // Painel de formulário
        JPanel painelFormulario = new JPanel(new GridLayout(7, 2));
        painelFormulario.add(new JLabel("Nome:"));
        painelFormulario.add(campoNome);
        painelFormulario.add(new JLabel("CPF:"));
        painelFormulario.add(campoCpf);
        painelFormulario.add(new JLabel("Telefone:"));
        painelFormulario.add(campoTelefone);
        painelFormulario.add(new JLabel("Email:"));
        painelFormulario.add(campoEmail);
        painelFormulario.add(new JLabel("Endereço:"));
        painelFormulario.add(campoEndereco);
        painelFormulario.add(new JLabel("Nascimento (dd/MM/yyyy):"));
        painelFormulario.add(campoNascimento);

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

        // Área de texto
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        // Adiciona componentes ao JFrame
        add(painelFormulario, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        // Ações dos botões
        btnCadastrar.addActionListener(e -> cadastrarCliente());
        btnListar.addActionListener(e -> listarClientes());
        btnBuscar.addActionListener(e -> buscarPorCpf());
        btnRemover.addActionListener(e -> removerPorId());

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centraliza na tela
        setVisible(true);
    }

    private void cadastrarCliente() {
        try {
            ClienteRepositorio.criarNovoCliente(
                    campoNome.getText(),
                    campoCpf.getText(),
                    campoTelefone.getText(),
                    campoEmail.getText(),
                    campoEndereco.getText(),
                    campoNascimento.getText()
            );
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: cliente com este CPF já existe.");
        }
    }

    private void listarClientes() {
        ArrayList<Cliente> lista = ClienteRepositorio.listarTodos();
        if (lista.isEmpty()) {
            areaTexto.setText("Nenhum cliente cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder("Lista de Clientes:\n");
            for (Cliente c : lista) {
                sb.append("ID: ").append(c.getId())
                        .append(" | Nome: ").append(c.getNome())
                        .append(" | CPF: ").append(c.getCpf())
                        .append(" | Telefone: ").append(c.getTelefone())
                        .append("\n");
            }
            areaTexto.setText(sb.toString());
        }
    }

    private void buscarPorCpf() {
        String cpf = JOptionPane.showInputDialog(this, "Digite o CPF:");
        if (cpf == null || cpf.isBlank()) return;

        try {
            Cliente c = ClienteRepositorio.buscarPorCpf(cpf);
            areaTexto.setText(
                    "Cliente encontrado:\n" +
                            "ID: " + c.getId() + "\n" +
                            "Nome: " + c.getNome() + "\n" +
                            "Telefone: " + c.getTelefone() + "\n" +
                            "Email: " + c.getEmail() + "\n" +
                            "Endereço: " + c.getEndereco()
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
        }
    }

    private void removerPorId() {
        String input = JOptionPane.showInputDialog(this, "Digite o ID do cliente:");
        if (input == null || input.isBlank()) return;

        try {
            int id = Integer.parseInt(input);
            ClienteRepositorio.remover(id);
            JOptionPane.showMessageDialog(this, "Cliente removido com sucesso.");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cliente com esse ID não encontrado.");
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoCpf.setText("");
        campoTelefone.setText("");
        campoEmail.setText("");
        campoEndereco.setText("");
        campoNascimento.setText("");
    }

    public static void main(String[] args) {
        new TelaClientes();
    }
}

