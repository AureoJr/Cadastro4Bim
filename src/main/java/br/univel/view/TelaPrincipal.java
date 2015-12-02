package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXBusyLabel;

import br.univel.model.DBUtils.DB;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;		
	private BlockPanel glass;
	
	private static String ADD_ICON = "/icons/add-1-icon.png";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {

//		blockParaLogin();
//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
//
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCliente.setIcon(new ImageIcon(TelaPrincipal.class.getResource(ADD_ICON)));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTela();
			}

		});
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmUsurio = new JMenuItem("Usuário");
		mntmCliente.setIcon(new ImageIcon( TelaPrincipal.class.getResource(ADD_ICON)));
		mnCadastros.add(mntmUsurio);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmCliente.setIcon(new ImageIcon( TelaPrincipal.class.getResource(ADD_ICON)));
		mnCadastros.add(mntmProduto);
//		
//		JMenuItem mntmBloquear = new JMenuItem("BLOQUEAR");
//		mntmBloquear.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				block();
//			}
//		});
//		mnCadastros.add(mntmBloquear);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void block() {
		setGlassPane(glass);
		glass.setVisible(true);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i =0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				glass.setVisible(false);
			}
		}).start();
	}
 
	private void blockParaLogin() {
				
		DB db = new DB();
		
		if(db.isConectado()){
			System.out.print("! Conectou Saporra! !");
		} else {
			JOptionPane.showMessageDialog(this, "Lamento mas não foi possível fazer a conexão com o banco");
		}
		
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glass = new BlockPanel();
		};
//
//		
//		//---- USAR A INDICAÇÃO DE PROGRESSO.
		JXBusyLabel busy = new JXBusyLabel();
		busy.setBusy(true);
		glass = new BlockPanel(busy);
//		//-----------------------------------
//		
//		//---- USAR O PAINEL DE LOGIN.
		PainelLogin painelLogin = new PainelLogin(acaoOk);
		glass = new BlockPanel(painelLogin);
//		//--c---------------------------------
//
		setGlassPane(glass);

		glass.setVisible(true);
	}

	private void abrirTela() {
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);
			}
		};
		telaCadastroCliente.setCloseAction(action);

		tabbedPane.addTab("Tela ", telaCadastroCliente);
	}

}
