package Gerenciador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaConsultaAluno {

    private JFrame frame;
    private JTextField txtBusca;
    private JTable table;
    private JButton btnVoltar;

    public TelaConsultaAluno() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Consulta de Alunos");
        frame.setBounds(100, 100, 600, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Painel principal com bordas
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(230, 230, 250)); // Cor de fundo suave
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Rótulo de busca
        JLabel lblBusca = new JLabel("Buscar por nome ou matrícula:");
        lblBusca.setFont(new Font("Gotham", Font.PLAIN, 14));
        lblBusca.setBounds(10, 10, 200, 20);
        panel.add(lblBusca);

        // Campo de busca
        txtBusca = new JTextField();
        txtBusca.setFont(new Font("Gotham", Font.PLAIN, 14));
        txtBusca.setBounds(210, 10, 200, 20);
        panel.add(txtBusca);

        // Botão de busca
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Gotham", Font.BOLD, 14));
        btnBuscar.setBackground(new Color(100, 200, 100)); // Cor verde
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBounds(420, 10, 100, 30);
        panel.add(btnBuscar);

        // Criando a tabela e o modelo
        String[] columnNames = {"Nome", "Idade", "Matrícula", "Curso"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Redimensionamento automático das colunas
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        // Painel de rolagem para a tabela
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 60, 560, 280);
        panel.add(scrollPane);

        // Botão de voltar
        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setBackground(new Color(255, 100, 100)); // Cor vermelha
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBounds(420, 350, 100, 30);
        panel.add(btnVoltar);

        // Ação do botão de busca
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busca = txtBusca.getText().toLowerCase().trim();
                List<String> linhas = GerencArquivos.lerArquivo("dados/alunos.txt");

                // Limpa a tabela antes de adicionar novos dados
                model.setRowCount(0);

                boolean encontrado = false;

                for (String linha : linhas) {
                    if (linha.toLowerCase().contains(busca)) {
                        // Organizando os dados na tabela
                        String[] dados = linha.split(";");
                        model.addRow(dados);
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    model.addRow(new String[]{"Nenhum resultado encontrado", "", "", ""});
                }
            }
        });

        // Ação do botão de voltar
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaGerencAluno();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
