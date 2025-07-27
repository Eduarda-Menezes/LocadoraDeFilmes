package LocadoraDeFilmes.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class FormularioFuncionario extends JDialog {
    private JTextField tfNome, tfTelefone, tfFuncao;
    private JButton btnSalvar;

    public FormularioFuncionario(JFrame parent, String[] dadosOriginais, Consumer<String[]> callbackSalvar) {
        super(parent, "Formulário Funcionário", true);
        setLayout(new GridLayout(5, 2, 5, 5));
        setSize(350, 200);
        setLocationRelativeTo(parent);

        tfNome = new JTextField();
        tfTelefone = new JTextField();
        tfFuncao = new JTextField();

        if (dadosOriginais != null) {
            tfNome.setText(dadosOriginais[1]);
            tfTelefone.setText(dadosOriginais[2]);
            tfFuncao.setText(dadosOriginais[3]);
        }

        add(new JLabel("Nome:")); add(tfNome);
        add(new JLabel("Telefone:")); add(tfTelefone);
        add(new JLabel("Função:")); add(tfFuncao);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            String[] dados = new String[]{
                    dadosOriginais != null ? dadosOriginais[0] : String.valueOf(System.currentTimeMillis()),
                    tfNome.getText(),
                    tfTelefone.getText(),
                    tfFuncao.getText()
            };
            callbackSalvar.accept(dados);
            dispose();
        });

        add(new JLabel());
        add(btnSalvar);
        setVisible(true);
    }
}

