package swing.conceito;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Observador {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Observador");
		
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(600, 400);
		janela.setLayout(new FlowLayout());
		janela.setLocationRelativeTo(null);
		
		JButton botao = new JButton("Clicar");
		janela.add(botao);
		
		/*Da pra fazer dessa forma*/
//		botao.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Evento aconteceu!");
//			}
//		});
		
		/*Ou dessa, já que o action listener é uma interface, com s'p um método*/
		botao.addActionListener(e -> {
			System.out.println("Evento Aconteceu!!!!");
		});
		
		janela.setVisible(true);
		
	}
}
