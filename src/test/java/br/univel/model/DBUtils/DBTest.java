package br.univel.model.DBUtils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Teste para conexão
 * @author anxsjunior
 *
 */
public class DBTest {

	private DB db;
	
	private int teste;
	

	@Before
	public void setUp() throws Exception {
		db = new DB();
		System.out.println("Banco de Dados Inicializado");
	}

	@After
	public void tearDown() throws Exception {
		if(db.isConectado()){
			System.out.println("Banco Conectado");
			teste = 1;
		}
	}

	@Test
	public void test() {
		assertEquals(1, teste);
	}

}
