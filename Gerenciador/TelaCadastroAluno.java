package Gerenciador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TelaCadastroAluno {

    private JFrame frame;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtMatricula;
    private JTextField txtCurso;

    public TelaCadastroAluno() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Cadastro de Aluno");
        frame.setBounds(100, 100, 500, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(230, 230, 250)); // Cor de fundo suave
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblNome, gbc);

        txtNome = new JTextField(20);
        txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtNome, gbc);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblIdade, gbc);

        txtIdade = new JTextField(20);
        txtIdade.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtIdade, gbc);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblMatricula, gbc);

        txtMatricula = new JTextField(20);
        txtMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(txtMatricula, gbc);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblCurso, gbc);

        txtCurso = new JTextField(20);
        txtCurso.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(txtCurso, gbc);

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(230, 230, 250)); // Cor de fundo suave
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));
        btnSalvar.setBackground(new Color(100, 200, 100)); // Cor verde
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFocusPainted(false);
        btnSalvar.setPreferredSize(new Dimension(120, 30));
        buttonPanel.add(btnSalvar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setBackground(new Color(255, 100, 100)); // Cor vermelha
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setPreferredSize(new Dimension(120, 30));
        buttonPanel.add(btnVoltar);

        // Ação de salvar
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText().trim();
                String idade = txtIdade.getText().trim();
                String matricula = txtMatricula.getText().trim();
                String curso = txtCurso.getText().trim();

                if (nome.isEmpty() || idade.isEmpty() || matricula.isEmpty() || curso.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String linha = nome + ";" + idade + ";" + matricula + ";" + curso;

                // Cria o diretório, se necessário
                new File("dados").mkdirs();
                GerencArquivos.adicionarLinha("dados/alunos.txt", linha);

                JOptionPane.showMessageDialog(frame, "Aluno cadastrado com sucesso!");
                new TelaGerencAluno();
                frame.dispose();
            }
        });

        // Ação de voltar
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
