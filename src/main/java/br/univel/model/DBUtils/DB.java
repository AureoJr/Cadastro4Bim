package br.univel.model.DBUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univel.model.DBUtils.annotations.Coluna;
import br.univel.model.DBUtils.annotations.Tabela;

/**
 * Classe responsável por cuidar da camada do banco de dados TODO criar pacote
 * de exeptions
 * 
 * @author aureo
 * @since 29/10/2015 21:21
 */
public class DB {

	/**
	 * Define uma {@code Tabela} para ser manipulada no contexto atual
	 * 
	 * @see br.univel.model.DBUtils.Tabela
	 */
	private Object contexto;

	/**
	 * Para facilitar a legibilidade do codigo
	 */
	private static boolean conectado = false;



	private static Connection conn;
	
	private Conexao conexao;

	/**
	 * Inicializar defaults
	 */
	private void init() {
		// Primeiro Teste com a conxao do banco
		verificaConexao();
	}

	private void verificaConexao() {
		try {
			if(conn == null){
				conexao = new Conexao();
			}
			conn = conexao.abrirConexao();
			if(conn != null){
				conectado = true;
				conn.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	   
	public DB() {
		init();
	}

	/**
	 * Permite inicializar o a classe com um contexto
	 * 
	 * @param tabela
	 */
	public DB(Object tabela) {
		contexto = tabela;
		init();
	}

	/**
	 * 
	 * Método listar, funcionamento parecido com um <b>"Select * from"</b>
	 * 
	 * 
	 * @return Lista de Objetos no contexto
	 * @throws Exception
	 *             Quando o contexto não estiver definido
	 */
	public List<Object> listar() throws Exception {
		if (contexto == null) {
			throw new Exception("Contexto não definido");
		}

		Tabela tabela = contexto.getClass().getDeclaredAnnotation(Tabela.class);

		if (tabela == null) {
			throw new Exception("Essa classe não foi definida como uma tabela.");
		}

		List<Object> retorno = new ArrayList<>();
		
		PreparedStatement st = conn.prepareStatement(criarSelect(contexto, tabela));
		ResultSet result = st.executeQuery();

		while (result.next()) {
			Object obj = Class.forName(contexto.getClass().getName());

			for (Field field : contexto.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				System.out.println(field.getName());
				if (field.get(obj) instanceof Integer) {
					field.set((Integer) obj, result.getObject(field.getName()));
				}
				if (field.get(obj) instanceof String) {
					field.set((String) obj, result.getObject(field.getName()));
				}

				field.set(obj, result.getObject(field.getName()));
			}

			retorno.add(obj);

		}

		return null;
	}

	/**
	 * Controi uma select
	 * 
	 * @param contexto
	 * @param tabela
	 * @return Query
	 */
	private String criarSelect(Object contexto, Tabela tabela) {
		StringBuilder sb = new StringBuilder();
		sb.append("Select ");
		sb.append(campos(contexto));
		sb.append(" from ");
		sb.append(tabela.nome().isEmpty() ? contexto.getClass()
				.getCanonicalName() : tabela.nome());

		return sb.toString();
	}

	/**
	 * recupera os campos da tabela
	 * 
	 * @param contexto
	 * @return String com os campos da tabela
	 */
	private String campos(Object ctx) {
		StringBuilder sb = new StringBuilder();
		for (Field campo : ctx.getClass().getFields()) {
			campo.setAccessible(true);

			if (campo.isAnnotationPresent(Coluna.class)) {
				Coluna coluna = campo.getClass().getAnnotation(Coluna.class);

				if (!coluna.nome().isEmpty()) {
					sb.append(coluna.nome());
				} else {
					sb.append(campo.getName());
				}

				sb.append(",");

			}

		}

		return sb.toString().substring(sb.toString().lastIndexOf(','),
				sb.toString().length());
	}

	public Object getContexto() {
		return contexto;
	}

	/**
	 * Permite alterar a tabela e aproveita a mesma instância
	 * 
	 * @param contexto
	 */
	public void setContexto(Object contexto) {
		this.contexto = contexto;
	}

	/**
	 * variável que determina se a conexão já foi inicializada
	 * 
	 */
	public boolean isConectado() {
		return conectado;
	}

}
