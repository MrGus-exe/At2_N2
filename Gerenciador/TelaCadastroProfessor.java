package Gerenciador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroProfessor {

    private JFrame frame;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtMatricula;
    private JButton btnNewButton;

    public TelaCadastroProfessor() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 100, 20);
        frame.getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 10, 200, 20);
        frame.getContentPane().add(txtNome);

        JLabel lblIdade = new JLabel("Especialidade\r\n");
        lblIdade.setBounds(10, 70, 100, 20);
        frame.getContentPane().add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(130, 41, 200, 20);
        frame.getContentPane().add(txtIdade);

        JLabel lblMatricula = new JLabel("ID Professor");
        lblMatricula.setBounds(10, 39, 100, 20);
        frame.getContentPane().add(lblMatricula);

        txtMatricula = new JTextField();
        txtMatricula.setBounds(130, 70, 200, 20);
        frame.getContentPane().add(txtMatricula);
        

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(120, 110, 100, 30);
        frame.getContentPane().add(btnSalvar);
        
        btnNewButton = new JButton("Voltar\r\n");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		new TelaGerencProfessor();
        		frame.dispose();
        		
        	}
        });
        btnNewButton.setBounds(230, 110, 105, 30);
        frame.getContentPane().add(btnNewButton);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String idade = txtIdade.getText();
                String matricula = txtMatricula.getText();

                if (nome.isEmpty() || idade.isEmpty() || matricula.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
                    return;
                }

                String linha = nome + ";" + idade + ";" + matricula;
                GerencArquivos.adicionarLinha("dados/alunos.txt", linha);
                JOptionPane.showMessageDialog(frame, "Professor cadastrado com sucesso!");
                new TelaGerencProfessor();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}

