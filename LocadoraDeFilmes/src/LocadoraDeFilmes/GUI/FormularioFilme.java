package LocadoraDeFilmes.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class FormularioFilme extends JDialog {
    private JTextField tfTitulo, tfDuracao, tfGenero;
    private JButton btnSalvar;

    public FormularioFilme(JFrame parent, String[] dadosOriginais, Consumer<String[]> callbackSalvar) {
        super(parent, "Formulário Filme", true);
        setLayout(new GridLayout(5, 2, 5, 5));
        setSize(350, 200);
        setLocationRelativeTo(parent);

        tfTitulo = new JTextField();
        tfDuracao = new JTextField();
        tfGenero = new JTextField();

        if (dadosOriginais != null) {
            tfTitulo.setText(dadosOriginais[1]);
            tfDuracao.setText(dadosOriginais[2]);
            tfGenero.setText(dadosOriginais[3]);
        }

        add(new JLabel("Título:")); add(tfTitulo);
        add(new JLabel("Duração:")); add(tfDuracao);
        add(new JLabel("Gênero:")); add(tfGenero);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            String[] dados = new String[]{
                    dadosOriginais != null ? dadosOriginais[0] : String.valueOf(System.currentTimeMillis()),
                    tfTitulo.getText(),
                    tfDuracao.getText(),
                    tfGenero.getText()
            };
            callbackSalvar.accept(dados);
            dispose();
        });

        add(new JLabel());
        add(btnSalvar);
        setVisible(true);
    }
}
