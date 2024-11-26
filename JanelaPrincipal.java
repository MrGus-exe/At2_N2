package Gerenciador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class JanelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.setBounds(173, 163, 96, 23);
		btnProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnProfessor);
		btnProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TelaGerencProfessor();
				frame.dispose();
				
			}
			
			
		});
	
		
		JButton btnAluno1 = new JButton("Aluno");
		btnAluno1.setBounds(10, 163, 96, 23);
		btnAluno1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnAluno1);
		btnAluno1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TelaGerencAluno();
				frame.dispose();
				
			}
		});
		
		JButton btnCurso = new JButton("Curso");
		btnCurso.setBounds(328, 163, 96, 23);
		btnCurso.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnCurso);
		
		JLabel lblNewLabel = new JLabel("Gerenciador boladão meu pau na sua mão");
		lblNewLabel.setBounds(106, 36, 226, 14);
		panel.add(lblNewLabel);
		btnCurso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaGerencCurso();
				frame.setVisible(false);
				
			}
		});
	
	}

	public void setVisible(boolean b) {
		 boolean visible = true;
		frame.setVisible(visible);
		
	}
}
