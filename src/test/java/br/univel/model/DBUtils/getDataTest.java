package br.univel.model.DBUtils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.univel.model.Cliente;

public class getDataTest {

	private DB db;
	private List<Object> lista;
	
	@Before
	public void setUp() throws Exception {
		db = new DB(Cliente.class);
		if(db.isConectado()){
			System.out.println("Banco Conectado !");
			System.out.println("Contexto Cliente");
		}
	}

	@After
	public void tearDown() throws Exception {
		lista = db.listar();
		System.out.println("Listando os dados do cliente!");
	}

	@Test
	public void test() {
		assertEquals(true, lista != null);
	}

}

