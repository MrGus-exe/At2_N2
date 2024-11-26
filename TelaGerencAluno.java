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
        lblNewLabel.setBounds(162, 25, 200, 30);
        panel.add(lblNewLabel);

        // Botão para voltar à janela principal
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(40, 300, 120, 30);
        panel.add(btnVoltar);

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
