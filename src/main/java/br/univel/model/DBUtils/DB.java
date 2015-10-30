package br.univel.model.DBUtils;

import java.lang.annotation.Annotation;
import java.util.List;

import br.univel.model.DBUtils.annotations.Tabela;

/**
 * Classe responsável por cuidar da camada do banco de dados
 * TODO criar pacote de exeptions
 * 
 * @author aureo
 * @since 29/10/2015 21:21
 */
public class DB {

	/**
	 * Define uma {@code Tabela} para ser manipulada no
	 * contexto atual
	 * 
	 * @see br.univel.model.DBUtils.Tabela
	 */
	private Object contexto;

	/**
	 * Para facilitar a legibilidade do codigo
	 */
	private static boolean conectado = false;
	
	
	private Conexao conn;
	
	/**
	 * Inicializar defaults
	 */
	private void init(){
		
	}
	
	public DB(){
		init();
	}

	/**
	 * Permite inicializar o a classe com um contexto
	 * 
	 * @param tabela 
	 */
	public DB(Object tabela){
		contexto = tabela;
		init();
	}
	
	/**
	 * 
	 *  Método listar, funcionamento parecido com um <b>"Select * from"</b>
	 * 
	 * @return Lista de Objetos no contexto
	 * @throws Exception Quando o contexto não estiver definido
	 */
	public List<Object> listar() throws Exception{
		if(contexto == null){
			throw new Exception("Contexto não definido");
		}
		
		Annotation tabela = contexto.getClass().getDeclaredAnnotation(Tabela.class);
		
		if(tabela == null){
			throw new Exception("Essa classe não foi definida como uma tabela");
		}
		
		return null;
	}
	
	
	public Object getContexto() {
		return contexto;
	}

	/**
	 * permite alterar a tabela e aproveita a mesma instância
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
