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

import br.univel.model.DBUtils.annotations.Coluna;
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
	public String criarbanco() throws Exception{
		// Lista para armazenar as Classes
		List<Class<?>> classes = new ArrayList<>();
		
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

			    String className = classe.getName().replaceAll(".class$", ""); 
				classes.add(Class.forName(InitDataBase.pacote+"."+className));
				System.out.println(Class.forName(InitDataBase.pacote+"."+className).getName());	
			}
		}
		
		// iniciando o script 
		script.append("use ");
		script.append( new Conexao().getDBName());
		script.append("\n");
		
		//Criar scripts da tabela
		for (Class<?> obj : classes) {
			
			Object tabela = Class.forName(obj.getName()).newInstance();
			
			
			System.out.println(tabela.getClass().getName());
			
			Tabela novaTabela = tabela.getClass().getDeclaredAnnotation(Tabela.class);
			
			if(novaTabela != null){
			
			
				script.append("CREATE TABLE ");
				script.append(novaTabela.nome().isEmpty() ?  tabela.getClass() : novaTabela.nome());
				script.append("{ \n");
				
				script.append(addTableFields(tabela));
			}
		}
				
		System.out.println(script.toString());
		return script.toString();
		
	}

	/**
	 * 	Método que cria os campos da tabela
	 * 
	 * @param tabela
	 * @return Retorna todas colunas que estão anotadas
	 * @throws Exception 
	 */
	private String addTableFields(Object tabela) throws Exception {
		StringBuilder colunaTabela = new StringBuilder();
		
		Field[] campos = tabela.getClass().getDeclaredFields();
		 
		boolean possuiID = false;
		
		//Verificação para garantir que a tabela tem uma coluna ID
		for(Field campo : campos){
			if(campo.isAnnotationPresent(Id.class)){
				possuiID = true;
				break;
			}
		}
		
		if(!possuiID){
			throw new Exception("A Classe "+tabela.getClass().getName()+" não possui ID");
		}		
		
		Id idTabela = campos.getClass().getAnnotation(Id.class);
		
		colunaTabela.append(idTabela != null? idTabela.nome() : "ID ");
		colunaTabela.append("integer, \n");
		
		
		
		for(Field field : campos){
			Coluna coluna = field.getDeclaredAnnotation(Coluna.class);
			if(coluna != null){
				colunaTabela.append(!coluna.nome().isEmpty() ? coluna.nome() : field.getName());
				colunaTabela.append(" ");
				colunaTabela.append(coluna.tipo());
				if(coluna.nullable()){
					colunaTabela.append(" NOT NULL");
				}
				colunaTabela.append(" , \n");
				
				
				//TODO Implementar os métodos que validam os tipos 
			}
		}
		
		colunaTabela.append("primary key(ID)); \n");
		
		return colunaTabela.toString();
	}
	
}
	