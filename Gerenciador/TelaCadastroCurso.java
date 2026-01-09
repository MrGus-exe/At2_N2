package Gerenciador;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroCurso {

    private JFrame frame;
    private JTextField txtNome;
    private JTextField txtCargaHoraria;
    private JTextField txtMatricula;
    private JButton btnNewButton;
    private JLabel lblCargaHoraria;

    public TelaCadastroCurso() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Campo para o nome do curso
        JLabel lblNome = new JLabel("Nome curso:");
        lblNome.setBounds(10, 40, 100, 20);
        frame.getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 40, 200, 20);
        frame.getContentPane().add(txtNome);

        // Campo para a carga horária do curso
        lblCargaHoraria = new JLabel("Carga Horária:");
        lblCargaHoraria.setBounds(10, 70, 100, 20);
        frame.getContentPane().add(lblCargaHoraria);

        txtCargaHoraria = new JTextField();
        txtCargaHoraria.setBounds(130, 70, 200, 20);
        frame.getContentPane().add(txtCargaHoraria);

        // Campo para a matrícula do professor ou responsável (caso queira associar a um professor)
        txtMatricula = new JTextField();
        txtMatricula.setBounds(130, 100, 200, 20);
        frame.getContentPane().add(txtMatricula);

        // Botão para salvar o curso
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(117, 149, 100, 30);
        frame.getContentPane().add(btnSalvar);

        // Botão para voltar
        btnNewButton = new JButton("Voltar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaGerencCurso();  // Tela de gerenciamento de cursos
                frame.dispose();
            }
        });
        btnNewButton.setBounds(225, 149, 105, 30);
        frame.getContentPane().add(btnNewButton);

        // Ação para salvar o curso
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCurso = txtNome.getText().trim();
                String cargaHoraria = txtCargaHoraria.getText().trim();
                String matriculaProfessor = txtMatricula.getText().trim();

                // Verificar se todos os campos foram preenchidos
                if (nomeCurso.isEmpty() || cargaHoraria.isEmpty() || matriculaProfessor.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
                    return;
                }

                // Montando a string que será salva no arquivo
                String linha = nomeCurso + ";" + cargaHoraria + ";" + matriculaProfessor;

                // Adicionando a linha ao arquivo
                GerencArquivos.adicionarLinha("dados/cursos.txt", linha);
                
                JOptionPane.showMessageDialog(frame, "Curso cadastrado com sucesso!");

                // Voltar para a tela de gerenciamento de cursos
                new TelaGerencCurso();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
