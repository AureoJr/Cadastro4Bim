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

	Conexao() {

		initialize();

	}

	private void initialize() {
		// dados padroes para efetuar testes
		DBUser = "java";
		DBPass = "java2000";
		DBName = "java";
		DBhost = "127.0.0.1";
		DBPort = "5432";
		DBSelecionado = EnumBDsDisponiveis.POSTGRESQL;

	}

	public Connection abrirConexao() throws SQLException {
		return DriverManager.getConnection(DBSelecionado.getStrConnection()
				+ DBhost + ":" + DBPort + "/" + DBName, DBUser, DBPass);
	}

	public void fecharConexao() {

	}

	public String getDBUser() {
		return DBUser;
	}

	public void setDBUser(String dBUser) {
		DBUser = dBUser;
	}

	public String getDBPass() {
		return DBPass;
	}

	public void setDBPass(String dBPass) {
		DBPass = dBPass;
	}

	public String getDBName() {
		return DBName;
	}

	public void setDBName(String dBName) {
		DBName = dBName;
	}

	public String getDBhost() {
		return DBhost;
	}

	public void setDBhost(String dBhost) {
		DBhost = dBhost;
	}

	public String getDBPort() {
		return DBPort;
	}

	public void setDBPort(String dBPort) {
		DBPort = dBPort;
	}

	public EnumBDsDisponiveis getDBSelecionado() {
		return DBSelecionado;
	}

	public void setDBSelecionado(EnumBDsDisponiveis dBSelecionado) {
		DBSelecionado = dBSelecionado;
	}

	
}
