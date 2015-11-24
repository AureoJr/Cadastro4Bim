package br.univel.model.DBUtils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InitDataBaseTest {

	private InitDataBase initDataBase;
	private String result;
	
	@Before
	public void setUp() throws Exception {
		
		System.out.print("Criação do banco Inicializada");
	}

	@After
	public void tearDown() throws Exception {
		result = initDataBase.criarbanco();
	}

	@Test
	public void test() {
		assertEquals(true, !result.isEmpty());
	}

}
