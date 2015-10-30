package br.univel.model.DBUtils.enums;

/**
 * 	Dados necessários para criar as conexões do banco de forma 
 * dinâmica
 * 
 * @author aureo
 * @since 29/10/2015 23:23
 */
public enum EnumBDsDisponiveis {

	POSTGRESQL("pgsql","PostgreSQL versão 9.1.18","org.postgresql.Driver","jdbc:postgresql://");
	
	private final String key,value,driver,strConnection;

	EnumBDsDisponiveis(String key, String value,String driver,String strConnection){
		this.key = key;
		this.value = value;
		this.driver = driver;
		this.strConnection = strConnection;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public String getDriver() {
		return driver;
	}

	public String getStrConnection() {
		return strConnection;
	}
	
	
	
}
