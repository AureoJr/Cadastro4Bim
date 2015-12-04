package br.univel.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.univel.view.TelaPrincipal;

/**
 * Para menter o código mais limpo a classe ActionListener será criada
 * adicionar as Tabs
 * 
 * @author aureo
 * @since 04/12/2015 01:25
 *
 */
public class ActionAddTab implements ActionListener {

	private TelaPrincipal mainFrame;
	private String aba;
	
	public ActionAddTab(TelaPrincipal mainFrame, String aba) {
	
		this.mainFrame = mainFrame;
		this.aba = aba;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO criar exceções personalizadas
		try {
			mainFrame.abrirTela(aba);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}

}
