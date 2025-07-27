package LocadoraDeFilmes.GUI;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class TelaFuncionarios extends JFrame{

    JTable tabela;
    DefaultTableModel modelo;

    public TelaFuncionarios() {
        setTitle("Gerenciar Funcionários");
        setSize(700, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        modelo = new DefaultTableModel(new String[]{
                "ID", "Nome", "Telefone", "Função"
        }, 0);

        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 20, 640, 200);
        add(scroll);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(20, 240, 120, 30);
        btnAdicionar.addActionListener(e -> {
            new FormularioFuncionario(this, null, dados -> modelo.addRow(dados));
        });

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(160, 240, 120, 30);
        btnAlterar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha != -1) {
                String[] dadosOriginais = new String[4];
                for (int i = 0; i < 4; i++) {
                    dadosOriginais[i] = (String) modelo.getValueAt(linha, i);
                }

                new FormularioFuncionario(this, dadosOriginais, dadosAtualizados -> {
                    for (int i = 0; i < 4; i++) {
                        modelo.setValueAt(dadosAtualizados[i], linha, i);
                    }
                });
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um funcionário para alterar.");
            }
        });

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(300, 240, 120, 30);
        btnDeletar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha != -1) modelo.removeRow(linha);
        });

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(440, 240, 120, 30);

        add(btnAdicionar);
        add(btnAlterar);
        add(btnDeletar);
        add(btnBuscar);
        add(scroll);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
