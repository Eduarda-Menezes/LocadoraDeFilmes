package LocadoraDeFilmes.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class FormularioCliente extends JDialog {
    private JTextField tfNome, tfCPF, tfTelefone, tfEmail, tfEndereco, tfNascimento;
    private JButton btnSalvar;

    public FormularioCliente(JFrame parent, String[] dadosOriginais, Consumer<String[]> callbackSalvar) {
        super(parent, "Formulário Cliente", true);
        setLayout(new GridLayout(8, 2, 5, 5));
        setSize(400, 300);
        setLocationRelativeTo(parent);

        tfNome = new JTextField();
        tfCPF = new JTextField();
        tfTelefone = new JTextField();
        tfEmail = new JTextField();
        tfEndereco = new JTextField();
        tfNascimento = new JTextField();

        if (dadosOriginais != null) {
            tfNome.setText(dadosOriginais[1]);
            tfCPF.setText(dadosOriginais[2]);
            tfTelefone.setText(dadosOriginais[3]);
            tfEmail.setText(dadosOriginais[4]);
            tfEndereco.setText(dadosOriginais[5]);
            tfNascimento.setText(dadosOriginais[6]);
        }

        add(new JLabel("Nome:")); add(tfNome);
        add(new JLabel("CPF:")); add(tfCPF);
        add(new JLabel("Telefone:")); add(tfTelefone);
        add(new JLabel("Email:")); add(tfEmail);
        add(new JLabel("Endereço:")); add(tfEndereco);
        add(new JLabel("Nascimento:")); add(tfNascimento);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            String[] dados = new String[]{
                    dadosOriginais != null ? dadosOriginais[0] : String.valueOf(System.currentTimeMillis()),
                    tfNome.getText(),
                    tfCPF.getText(),
                    tfTelefone.getText(),
                    tfEmail.getText(),
                    tfEndereco.getText(),
                    tfNascimento.getText()
            };
            callbackSalvar.accept(dados);
            dispose();
        });

        add(new JLabel());
        add(btnSalvar);
        setVisible(true);
    }
}
