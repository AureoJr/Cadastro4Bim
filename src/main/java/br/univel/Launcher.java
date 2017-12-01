package br.univel;

import br.univel.ui.main.MainWindow;

/**
 * 
 * Start application 
 * 
 * @author aureojr
 * @since 21/09/2016
 *
 */
public class Launcher {
	
	public static void main(String[] args) throws ClassNotFoundException {
		// Bootstraping CDI
//		StartMain.main(args);
		// Initializing UI of system
//		MainWindow.start();
		Class.forName("org.h2.Driver");
		MainWindow.start();
	}
}
