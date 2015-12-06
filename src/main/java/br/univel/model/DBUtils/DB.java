package br.univel.model.DBUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.model.Cliente;
import br.univel.model.DBUtils.annotations.Coluna;
import br.univel.model.DBUtils.annotations.Id;
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

	private boolean debug = false;

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
			if (conn == null) {
				conexao = new Conexao();
			}
			conn = conexao.abrirConexao();
			if (conn != null) {
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
		debug("Contexto : " + contexto.toString());
		Tabela tabela = contexto.getClass().getDeclaredAnnotation(Tabela.class);

		if (tabela == null) {
			throw new Exception("Essa classe não foi definida como uma tabela.");
		}

		List<Object> retorno = new ArrayList<>();
		debug("Iniciando a Criação da sql");
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

		return retorno;
	}

	/**
	 * Exibe os detalhes da sql
	 * 
	 * @param string
	 *            Mensagem para exibir no log
	 */
	private void debug(String string) {
		if (debug)
			System.out.println(string);
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
		sb.append(tabela.nome().isEmpty() ? contexto.getClass().getCanonicalName() : tabela.nome());
		debug(sb.toString());
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

		return sb.toString().substring(sb.toString().lastIndexOf(','), sb.toString().length());
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

	/**
	 * Exibe as SQL's
	 * 
	 * @param debug
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * 
	 * @return status da depuração
	 */
	public boolean getDebug() {
		return debug;
	}

	/**
	 * Método responsável por persistir os dados no banco
	 * 
	 * @throws Exception
	 */
	public void salvar() throws Exception {
		if (contexto == null) {
			throw new Exception("Contexto não definido");
		}
		debug("Contexto : " + contexto.toString());
		Tabela tabela = contexto.getClass().getDeclaredAnnotation(Tabela.class);

		if (tabela == null) {
			throw new Exception("Essa classe não foi definida como uma tabela.");
		}

		debug("Iniciando a Criação da sql");
		PreparedStatement ps = conn.prepareStatement(criarInsert(contexto, tabela));

		int i = 1;
		for (Field coluna : contexto.getClass().getDeclaredFields()) {

			if (coluna.isAnnotationPresent(Coluna.class)) {
				coluna.setAccessible(true);
				ps.setObject(i, coluna.get(contexto));
				i++;
			}
		}

		ps.executeUpdate();

	}

	public Object atualizar() throws Exception {

		Class<?> clazz = contexto.getClass();

		Tabela tabela = clazz.getAnnotation(Tabela.class);

		StringBuilder colunaBuilder = new StringBuilder();

		for (Field coluna : clazz.getDeclaredFields()) {
			coluna.setAccessible(true);
			if (coluna.isAnnotationPresent(Coluna.class)) {

				colunaBuilder.append(coluna.getName());
				colunaBuilder.append(" = ? , ");

			}
		}

		String colunas = colunaBuilder.toString();

		colunas = colunas.substring(0, colunas.length() - 2);

		PreparedStatement ps = conn.prepareStatement("Update " + tabela.nome() + " set " + colunas + "where id = ?");

		int i = 1;

		for (Field coluna : clazz.getDeclaredFields()) {
			coluna.setAccessible(true);
			if (coluna.isAnnotationPresent(Coluna.class)) {
				ps.setObject(i, coluna.get(contexto));
				i++;

			}
		}
		
		Field colunaid = clazz.getDeclaredField("id");
		colunaid.setAccessible(true);
		ps.setObject(i, colunaid.get(contexto));
		ps.executeUpdate();
		
		return contexto;
	}

	/**
	 * Deletar dados :D
	 * 
	 * @throws Exception
	 *             Tudo pode acontecer aqui o.O
	 */
	public void deletar() throws Exception {
		Tabela tabela = contexto.getClass().getAnnotation(Tabela.class);

		String strDelete = "Delete from " + tabela.nome() + " where id = ?";
		PreparedStatement ps = conn.prepareStatement(strDelete);

		for (Field campo : contexto.getClass().getFields()) {
			if (campo.isAnnotationPresent(Id.class)) {
				ps.setInt(1, (Integer) campo.get(campo));
				break;
			}
		}

		ps.executeUpdate();

	}

	/**
	 * 
	 * @param contexto
	 *            Tabela no contexto
	 * @param tabela
	 *            Anotação presente na Classe
	 * @see {@link br.univel.model.DBUtils.annotations.Tabela}
	 * @return
	 */
	private String criarInsert(Object contexto2, Tabela tabela) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(tabela.nome().isEmpty() ? contexto.getClass().getCanonicalName() : tabela.nome());
		sb.append(" (");
		sb.append(campos(contexto));
		sb.append(" )");
		sb.append(" values ( ");
		sb.append(inserValues());
		sb.append(")");

		debug(sb.toString());
		return sb.toString();

	}

	/**
	 * as interrogações de um prepared statment
	 * 
	 * @return String
	 */
	private String inserValues() {
		StringBuilder sb = new StringBuilder();
		for (Field campo : contexto.getClass().getFields()) {
			campo.setAccessible(true);

			if (campo.isAnnotationPresent(Coluna.class)) {

				sb.append("?,");

			}

		}

		return sb.toString().substring(sb.toString().lastIndexOf(','), sb.toString().length());
	}

	/**
	 * Método responsável por persistir os dados no banco, sem contexto definido
	 * 
	 * @throws Exception
	 */
	public void salvar(Object contexto) throws Exception {
		this.contexto = contexto;
		salvar();
	}

	public Cliente getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
