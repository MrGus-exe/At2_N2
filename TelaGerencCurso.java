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
		
		JButton btnVoltar = new JButton("New button");
		
				
				 btnVoltar.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	 JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
			                janelaPrincipal.setVisible(true);
			                frame.dispose(); // Fecha a janela atual
			            }
			        });
			   
				
		
		btnVoltar.setBounds(57, 83, 89, 23);
		frame.getContentPane().add(btnVoltar);
	}

}
