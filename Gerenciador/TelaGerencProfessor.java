package Gerenciador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class TelaGerencProfessor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerencProfessor window = new TelaGerencProfessor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaGerencProfessor() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(24, 198, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnCadastroDeProfessor = new JButton("Cadastro de \r\n Professor\r\r\n");
		btnCadastroDeProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaCadastroProfessor();
				frame.dispose();
				
			}
		});
		btnCadastroDeProfessor.setBounds(24, 88, 180, 30);
		frame.getContentPane().add(btnCadastroDeProfessor);
		
		JButton btnConsultaDeProfessor = new JButton("Consulta de Professor\r\n");
		btnConsultaDeProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaConsultaProfessor();
				frame.dispose();
				
			}
		});
		btnConsultaDeProfessor.setBounds(323, 88, 180, 30);
		frame.getContentPane().add(btnConsultaDeProfessor);
		
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
