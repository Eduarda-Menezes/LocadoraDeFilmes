package LocadoraDeFilmes.GUI;
import javax.swing.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Locadora de Filmes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnClientes = new JButton("Clientes");
        btnClientes.setBounds(130, 30, 120, 30);
        btnClientes.addActionListener(e -> new TelaClientes());

        JButton btnFilmes = new JButton("Filmes");
        btnFilmes.setBounds(130, 80, 120, 30);
        btnFilmes.addActionListener(e -> new TelaFilmes());

        JButton btnFuncionarios = new JButton("Funcionários");
        btnFuncionarios.setBounds(130, 130, 120, 30);
        btnFuncionarios.addActionListener(e -> new TelaFuncionarios());

        add(btnClientes);
        add(btnFilmes);
        add(btnFuncionarios);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }

}
