package br.univel.view;
import java.awt.BorderLayout;
import java.awt.Component;

public class TelaCadastroCliente extends MolduraAbstrata {

	private static final String PACKAGE = "br.univel.view.inside";
	
	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		try {
			super.add((Component) Class.forName(PACKAGE+"").newInstance(), BorderLayout.CENTER);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
