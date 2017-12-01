package br.univel.ui.main;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * 
 * starts ui of System 
 * 
 * @author aureojr
 * @since 23/11/2017
 */
public class MainWindow extends JFrame{
	public MainWindow() {
		getContentPane().setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		getContentPane().add(titlePanel, BorderLayout.NORTH);
		
		JLabel lblMainTitle = new JLabel("New label");
		lblMainTitle.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		titlePanel.add(lblMainTitle);
		
		JPanel menuBar = new JPanel();
		getContentPane().add(menuBar, BorderLayout.WEST);
		
		JPanel mainContentPanel = new JPanel();
		getContentPane().add(mainContentPanel, BorderLayout.CENTER);
		
	}

	private static final long serialVersionUID = 7750140125103001514L;

	public static void start() {
		
	}
	
}
