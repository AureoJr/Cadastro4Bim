package br.univel.view.inside;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.univel.model.Cliente;
import br.univel.model.DBUtils.DB;
import br.univel.view.actions.ActionSalvar;
import br.univel.view.interfaces.IValidator;

/**
 * Cadastro de Cliente
 * 
 * @author Aureo Junior	
 * @since 03/12/2015 19:59
 *
 */
public class CadastroCliente extends JPanel implements IValidator{
             
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEndereco;
	private JTextField txtEmail;

	private Cliente clienteContexto;
	
	/**      
	 * Create the panel.
	 */
	public CadastroCliente() {
		clienteContexto = new Cliente();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 105, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblClientes = new GridBagConstraints();
		gbc_lblClientes.gridwidth = 3;
		gbc_lblClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblClientes.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientes.gridx = 2;
		gbc_lblClientes.gridy = 0;
		add(lblClientes, gbc_lblClientes);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 2;
		add(lblTelefone, gbc_lblTelefone);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereco");
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereco.gridx = 3;
		gbc_lblEndereco.gridy = 2;
		add(lblEndereco, gbc_lblEndereco);
		
		txtEndereco = new JTextField();
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.gridx = 4;
		gbc_txtEndereco.gridy = 2;
		add(txtEndereco, gbc_txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblUf = new JLabel("Uf");
		GridBagConstraints gbc_lblUf = new GridBagConstraints();
		gbc_lblUf.anchor = GridBagConstraints.EAST;
		gbc_lblUf.insets = new Insets(0, 0, 5, 5);
		gbc_lblUf.gridx = 1;
		gbc_lblUf.gridy = 3;
		add(lblUf, gbc_lblUf);
		
		JComboBox cbxUf = new JComboBox();
		GridBagConstraints gbc_cbxUf = new GridBagConstraints();
		gbc_cbxUf.insets = new Insets(0, 0, 5, 5);
		gbc_cbxUf.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxUf.gridx = 2;
		gbc_cbxUf.gridy = 3;
		add(cbxUf, gbc_cbxUf);
		
		JLabel lblCidade = new JLabel("Cidade");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 3;
		gbc_lblCidade.gridy = 3;
		add(lblCidade, gbc_lblCidade);
		
		JComboBox cbxCidades = new JComboBox();
		GridBagConstraints gbc_cbxCidades = new GridBagConstraints();
		gbc_cbxCidades.insets = new Insets(0, 0, 5, 5);
		gbc_cbxCidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxCidades.gridx = 4;
		gbc_cbxCidades.gridy = 3;
		add(cbxCidades, gbc_cbxCidades);
		
		JLabel lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 4;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 3;
		gbc_lblGenero.gridy = 4;
		add(lblGenero, gbc_lblGenero);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 0;
		panel.add(btnSalvar, gbc_btnSalvar);
		btnSalvar.setIcon(new ImageIcon(CadastroCliente.class.getResource("/icons/Accept-icon.png")));
		try{
			btnSalvar.addActionListener(new ActionSalvar(clienteContexto,this));
		} catch (Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		btnSalvar.setSelectedIcon(new ImageIcon(CadastroCliente.class.getResource("/icons/Accept-icon.png")));
		
		JButton btnCancel = new JButton("");
		btnCancel.setToolTipText("Cancelar");
		btnCancel.setIcon(new ImageIcon(CadastroCliente.class.getResource("/icons/cancel-icon.png")));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 0;
//		btnCancel.addActionListener(new ActionSalvar(clienteContexto,this));
		panel.add(btnCancel, gbc_btnCancel);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setIcon(new ImageIcon(CadastroCliente.class.getResource("/icons/search-icon.png")));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 0;
//		btnBuscar.addActionListener(new ActionSalvar(clienteContexto,this));
		panel.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnRemove = new JButton("");
		btnRemove.setToolTipText("Remover");
		btnRemove.setIcon(new ImageIcon(CadastroCliente.class.getResource("/icons/delete-1-icon.png")));
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.gridx = 4;
		gbc_btnRemove.gridy = 0;
//		btnRemove.addActionListener(new ActionSalvar(clienteContexto,this));
		panel.add(btnRemove, gbc_btnRemove);

	}
	
	@Override
	public String toString() {
		return "Cadastro de Cliente"; 
	}

	@Override
	public boolean validarCampos() {
		if(txtEmail.getText().isEmpty())
			return false;

		if(txtEndereco.getText().isEmpty())
			return false;		

		if(textField.getText().isEmpty())
			return false;		

		if(textField_1.getText().isEmpty())
			return false;				
		
		
		return true;
	}

	@Override
	public void preencherCampos() {
		DB db = new DB(new Cliente());
		clienteContexto = db.getById(clienteContexto .getId());
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}

}
