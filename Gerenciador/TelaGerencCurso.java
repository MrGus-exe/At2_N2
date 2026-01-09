package Gerenciador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGerencCurso {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerencCurso window = new TelaGerencCurso();
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
	public TelaGerencCurso() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 550, 400);
	  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		
				
				 btnVoltar.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	 JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
			                janelaPrincipal.setVisible(true);
			                frame.dispose(); // Fecha a janela atual
			            }
			        });
			   
				
		
		btnVoltar.setBounds(47, 262, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnCadastroDeCurso = new JButton("Cadastro de \r\n Curso\r\n\r\r\n");
		btnCadastroDeCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaCadastroCurso();
				frame.dispose();
				
			}
		});
		btnCadastroDeCurso.setBounds(47, 75, 180, 30);
		frame.getContentPane().add(btnCadastroDeCurso);
		
		JButton btnConsultaDeCurso = new JButton("Consulta de Curso\r\n");
		btnConsultaDeCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaConsultaCurso();
				frame.dispose();
				
			}
		});
		btnConsultaDeCurso.setBounds(327, 75, 180, 30);
		frame.getContentPane().add(btnConsultaDeCurso);
	}

}
