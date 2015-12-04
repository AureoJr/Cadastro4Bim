package br.univel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *  Configuração para o padrão de telas 
 * 
 * @author Fernando Dagostini(https://github.com/fdagostini)
 * @author Aureo Junior (https://github.com/AureoJr) 
 * @seehttps://github.com/fdagostini/tads2a4bim/blob/master/cadastro/src/main/java/br/univel/cadastro/telalogin/MolduraAbstrata.java
 *
 */
public abstract class AbstractFrame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnFechar;

	protected abstract void configureFrame();
	
	public void setCloseAction(ActionListener action) {
		btnFechar.addActionListener(action);
	}
	
	/**
	 * Create the panel.
	 */
	public AbstractFrame() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCabecalho = new JLabel("Ratão do banhado Systems");
		GridBagConstraints gbc_lblCabecalho = new GridBagConstraints();
		gbc_lblCabecalho.insets = new Insets(0, 0, 0, 5);
		gbc_lblCabecalho.gridx = 0;
		gbc_lblCabecalho.gridy = 0;
		panel.add(lblCabecalho, gbc_lblCabecalho);
		
		btnFechar = new JButton("");
		btnFechar.setIcon(new ImageIcon(AbstractFrame.class.getResource("/icons/delete-icon.png")));
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.EAST;
		gbc_btnFechar.gridx = 1;
		gbc_btnFechar.gridy = 0;
		panel.add(btnFechar, gbc_btnFechar);

		
		configureFrame();
	}

}
