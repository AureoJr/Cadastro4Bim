package br.univel.model.DBUtils;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ReflectPermission;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.univel.model.DBUtils.annotations.Id;
import br.univel.model.DBUtils.annotations.Tabela;
import br.univel.model.DBUtils.enums.EnumBDsDisponiveis;

/**
 * 
 *  Classe responsavel por criar e resetar o banco de dados
 * 
 * @author aureo
 * @since 09/11/2015  02:39
 * 
 */
public class InitDataBase {

	public static String pacote = "br.univel.model"; 
	
	public static void main(String[] args) {
		
		InitDataBase init = new InitDataBase();
		
		
		try {
			init.criarbanco();
		} catch (ClassNotFoundException  | IOException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();	
		}

	}

	/**
	 * Cria todas as tabelas referencciadas no model
	 * @throws Exception 
	 */
	public void criarbanco() throws Exception{
		// Lista para armazenar as Classes
		List<Object> classes = new ArrayList<>();
		
		//Sufixo para definir os arquivos .class
		String suffix = ".class";
		
		//Script de criação das tabelas
		StringBuilder script = new StringBuilder();
		
		// Criando uma URL para adiquirir o arquivo(pasta) aprtir do pacote
		URL packageUrl = Thread.currentThread().getContextClassLoader().getResource(InitDataBase.pacote.replace(".", "/"));
		
		// Se o arquivo não for encontrado Fudeu Bahia 
		if(packageUrl == null){
			throw new IllegalArgumentException("Pacote "+InitDataBase.pacote+" não existe" );
		}
		
		
		// Recuperar os arquivos do pacotee 
		File[] arrayClasses = new File(packageUrl.getFile()).listFiles();
		
		//Adicionando o pacote com classes
		for (File classe : arrayClasses) {
			if(classe.getName().endsWith(suffix)){

			    String className = classe.getName().replaceAll(".class$", ""); // Não sei o que isso realmente faz
				classes.add(Class.forName(InitDataBase.pacote+"."+className));
				
			}
		}
		
		// iniciando o script 
		script.append("use ");
		script.append( new Conexao().getDBName());
		script.append("\n");
		
		//Criar scripts da tabela
		for (Object tabela : classes) {
			
			//Object obj = tbl.newInstance();
			
			Tabela novaTabela = tabela.getClass().getDeclaredAnnotation(Tabela.class);			
			
			if(novaTabela == null){
				throw new Exception("A classe " +tabela.getClass().getName()+" Não possui anotação");
			}
			script.append("CREATE TABLE ");
			script.append(novaTabela.nome().isEmpty() ?  tabela.getClass() : novaTabela.nome());
			script.append("{ \n");
			
			script.append(addTableFields(tabela));
		}
				
		
	}

	/**
	 * 	Método que cria os campos da tabela
	 * 
	 * @param tabela
	 * @return Retorna todas colunas que estão anotadas
	 */
	private String addTableFields(Object tabela) {
		StringBuilder colunaTabela = new StringBuilder();
		
		//Verificação para garantir que a tabela tem uma coluna ID
		if(!tabela.getClass().isAnnotationPresent(Id.class)){
			
		}
		
		//Lista para criar os campos
		List<Field> campos = new ArrayList<>();
		
		
		campos.addAll(Arrays.asList(tabela.getClass().getFields()));
		
		
		colunaTabela.append("");
		
		return colunaTabela.toString();
	}
	
}
	