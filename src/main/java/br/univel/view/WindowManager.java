package br.univel.view;
import java.awt.BorderLayout;
import java.awt.Component;

/**
 * Um frame abstrado para inserir todas a telas cridas
 * 
 * @author Aureo Junior
 * @see 03/12/2015 20:47
 *
 */
public class WindowManager extends AbstractFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "br.univel.view.inside.";
	
	private String tela;

	private String nome ;
	
	public WindowManager(String tela) {
		super();
		System.out.println(tela);
		this.tela = tela;
	}

	@Override
	protected void configureFrame() {
		if(tela == null){
			return;
		}
		
		try {
			Component newInstance = (Component) Class.forName(PACKAGE+tela).newInstance();
			this.nome = newInstance.toString();
			super.add(newInstance, BorderLayout.CENTER);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
	
		return this.nome;
	}
	
}
