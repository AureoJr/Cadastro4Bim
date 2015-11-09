package br.univel.model.DBUtils;

import java.io.File;
import java.lang.reflect.ReflectPermission;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *  Classe responsavel por criar e resetar o banco de dados
 * 
 * @author aureo
 * @since 09/11/2015  02:39
 *
 */
public class InitDataBase {

	public static String pacote = "br.unive.model"; 
	
	public static void main(String[] args) {
		

	}

	/**
	 * Cria todas as tabelas referencciadas no model
	 * @throws ClassNotFoundException 
	 */
	public void criarbanco() throws ClassNotFoundException{
		// Lista para armazenar as Classes
		List<Class<?>> classes = new ArrayList<>();
		
		//Sufixo para definir os arquivos .class
		String suffix = ".class";
		
		// Criando uma URL para adiquirir o arquivo(pasta) aprtir do pacote
		URL packageUrl = Thread.currentThread().getContextClassLoader().getResource(InitDataBase.pacote);
		
		// Se o arquivo não for encontrado Fudeu Bahia 
		if(packageUrl == null){
			throw new IllegalArgumentException("Pacote "+InitDataBase.pacote+" não existe" );
		}
		
		File pacote = new File(InitDataBase.pacote);
		
		for (File classe : pacote.listFiles()) {
			if(classe.getName().endsWith(suffix)){
				classes.add(Class.forName(classe.getName()));
			}
		}
		
		// cONTINUA NO PROXIMO EPISÓDO
				
		
	}
	
}
