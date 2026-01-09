package Gerenciador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaConsultaProfessor {

    private JFrame frame;
    private JTextField txtBusca;
    private JTable table;
    private JButton btnNewButton;

    public TelaConsultaProfessor() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblBusca = new JLabel("Buscar por nome ou ID:");
        lblBusca.setBounds(10, 10, 200, 20);
        frame.getContentPane().add(lblBusca);

        txtBusca = new JTextField();
        txtBusca.setBounds(210, 10, 200, 20);
        frame.getContentPane().add(txtBusca);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(210, 40, 100, 30);
        frame.getContentPane().add(btnBuscar);

        // Criando a tabela
        String[] columnNames = {"Nome", "ID", "Curso"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 450, 250);
        frame.getContentPane().add(scrollPane);

        btnNewButton = new JButton("Voltar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaGerencProfessor();
                frame.dispose();
            }
        });
        btnNewButton.setBounds(326, 41, 100, 29);
        frame.getContentPane().add(btnNewButton);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busca = txtBusca.getText().toLowerCase();
                List<String> linhas = GerencArquivos.lerArquivo("dados/alunos.txt");

                // Limpa a tabela
                model.setRowCount(0);

                for (String linha : linhas) {
                    if (linha.toLowerCase().contains(busca)) {
                        String[] dados = linha.split(";");
                        model.addRow(dados);
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}
