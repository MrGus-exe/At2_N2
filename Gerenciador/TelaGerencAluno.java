package Gerenciador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaGerencAluno {

    private JFrame frame;

    public TelaGerencAluno() {
        initialize();
        frame.setVisible(true); // Exibir a janela ao ser criada
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 550, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Gerenciamento de Alunos");
        lblNewLabel.setBounds(195, 33, 200, 30);
        panel.add(lblNewLabel);

        // Botão para voltar à janela principal
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(40, 300, 120, 30);
        panel.add(btnVoltar);
        
        // Botão para ir à tela de cadastro de aluno
        JButton btnCadAluno = new JButton("Cadastro de Aluno");
        btnCadAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroAluno(); // Abrir tela de cadastro
                frame.dispose();
            }
        });
        btnCadAluno.setBounds(40, 101, 127, 30);
        panel.add(btnCadAluno);
        
        // Botão para ir à tela de consulta de aluno
        JButton btnConsulAluno = new JButton("Consulta de Aluno");
        btnConsulAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaConsultaAluno(); // Abrir tela de consulta
                frame.dispose();
            }
        });
        btnConsulAluno.setBounds(372, 101, 127, 30);
        panel.add(btnConsulAluno);

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
                janelaPrincipal.setVisible(true);
                frame.dispose(); // Fecha a janela atual
            }
        });
    }
}
