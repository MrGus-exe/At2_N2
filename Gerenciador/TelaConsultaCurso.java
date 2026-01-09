package Gerenciador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaConsultaCurso {

    private JFrame frame;
    private JTextField txtBusca;
    private JTable table;
    private JButton btnVoltar;

    public TelaConsultaCurso() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label de busca para curso
        JLabel lblBusca = new JLabel("Buscar pelo Nome do Curso:");
        lblBusca.setBounds(10, 10, 250, 20);
        frame.getContentPane().add(lblBusca);

        // Campo de texto para digitar a busca
        txtBusca = new JTextField();
        txtBusca.setBounds(210, 10, 200, 20);
        frame.getContentPane().add(txtBusca);

        // Botão de busca
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(420, 10, 100, 30);
        frame.getContentPane().add(btnBuscar);

        // Criando a tabela e o modelo
        String[] columnNames = {"Curso", "Carga Horária", "Turno"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 570, 250);
        frame.getContentPane().add(scrollPane);

        // Botão de voltar
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaGerencCurso();  // Volta para a tela de gerenciamento de cursos
                frame.dispose();
            }
        });
        btnVoltar.setBounds(420, 350, 100, 30);
        frame.getContentPane().add(btnVoltar);

        // Ação de busca
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busca = txtBusca.getText().toLowerCase();  // Obtém o texto da busca e converte para minúsculas
                List<String> linhas = GerencArquivos.lerArquivo("dados/cursos.txt");  // Lê o arquivo de cursos
                model.setRowCount(0);  // Limpa a tabela antes de adicionar novos dados

                boolean encontrado = false;

                // Loop pelas linhas do arquivo de cursos
                for (String linha : linhas) {
                    // Supondo que a linha tenha o formato "Nome do Curso; Carga Horária; Turno"
                    String[] dados = linha.split(";");
                    if (dados.length == 3) {  // Verifica se a linha tem 3 partes: nome, carga horária, turno
                        String nomeCurso = dados[0].trim();
                        String cargaHoraria = dados[1].trim() + " horas";  // Adiciona "horas" ao final
                        String turno = dados[2].trim();

                        // Se o nome do curso contém a busca, exibe as informações na tabela
                        if (nomeCurso.toLowerCase().contains(busca)) {
                            model.addRow(new String[]{nomeCurso, cargaHoraria, turno});
                            encontrado = true;
                        }
                    }
                }

                // Caso não tenha encontrado nenhum curso
                if (!encontrado) {
                    model.addRow(new String[]{"Nenhum resultado encontrado", "", ""});
                }
            }
        });

        frame.setVisible(true);
    }
}
