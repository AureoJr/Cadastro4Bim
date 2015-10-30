package br.univel.model.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.univel.model.DBUtils.enums.EnumBDsDisponiveis;

/**
 * 
 * Gerenciamento de conexão com os bancos armazenados na Enum
 * {@link br.univel.model.DBUtils.enums.EnumBDsDisponiveis }
 * 
 * @author aureo
 *
 */
public class Conexao {

	private String DBUser;
	private String DBPass;
	private String DBName;
	private String DBhost;
	private String DBPort;
	private EnumBDsDisponiveis DBSelecionado;

	private static Connection conexao;

	private Conexao() {

		initialize();

	}

	private void initialize() {
		// dados padroes para efetuar testes
		DBUser = "postg";
		DBPass = "postg";
		DBName = "trabalho";
		DBhost = "localhost";
		DBPort = "5432";
		DBSelecionado = EnumBDsDisponiveis.POSTGRESQL;

	}

	public Connection abrirConexao() throws SQLException {

		conexao = DriverManager.getConnection(DBSelecionado.getStrConnection()
				+ DBhost + ":" + DBPort + "/" + DBName, DBUser, DBPass);
		
		return conexao;
	}

	public void fecharConexao() {

	}

}
