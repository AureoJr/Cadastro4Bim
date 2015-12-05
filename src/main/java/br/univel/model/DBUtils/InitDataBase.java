package br.univel.model.DBUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import br.univel.model.DBUtils.annotations.Coluna;
import br.univel.model.DBUtils.annotations.Id;
import br.univel.model.DBUtils.annotations.Tabela;
import br.univel.model.DBUtils.annotations.UmPraUm;
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
	private EnumBDsDisponiveis bancoUltilizado;
	
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

			}
		}
		
		// iniciando o script 
		if(bancoUltilizado == EnumBDsDisponiveis.MYSQL){
    		script.append("use ");
    		script.append( new Conexao().getDBName());
    		script.append("\n");
		}
		//Criar scripts da tabela
		for (Class<?> obj : classes) {
			
			Object tabela = Class.forName(obj.getName()).newInstance();
			
			Tabela novaTabela = tabela.getClass().getDeclaredAnnotation(Tabela.class);
			
			if(novaTabela != null){
			
			
				script.append("CREATE TABLE ");
				script.append(novaTabela.nome().isEmpty() ?  tabela.getClass() : novaTabela.nome());
				script.append("( \n");
				
				script.append(addTableFields(tabela));
			}
		}
				
		System.out.println(script.toString());
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
		
		boolean possuiFK = false;
		
		//Verificação para garantir que a tabela tem uma coluna ID
		for(Field campo : campos){
			if(campo.isAnnotationPresent(Id.class)){
				possuiID = true;
				
			}
            if(campo.isAnnotationPresent(UmPraUm.class)){
                possuiFK = true;
            
            }			
			
		}
		
		if(!possuiID){
			throw new Exception("A Classe "+tabela.getClass().getName()+" não possui ID");
		}		
		
		Id idTabela = campos.getClass().getAnnotation(Id.class);
		colunaTabela.append(" ");
		colunaTabela.append(idTabela != null? idTabela.nome() : "ID ");
		colunaTabela.append(" integer unique, \n");
		
		
		
		for(Field field : campos){
			Coluna coluna = field.getDeclaredAnnotation(Coluna.class);
			if(coluna != null){
			    colunaTabela.append(" ");
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
		
        if(possuiFK){
            for(Field f : campos){
                UmPraUm coluna = f.getDeclaredAnnotation(UmPraUm.class);
                if(coluna != null){
                    Coluna col = f.getDeclaredAnnotation(Coluna.class);
                    colunaTabela.append(" FOREIGN KEY(");
                    colunaTabela.append(col.nome());
                    colunaTabela.append(") REFERENCES ");
                    colunaTabela.append(f.getType().getDeclaredAnnotation(Tabela.class).nome());
                    colunaTabela.append("(");
                    colunaTabela.append(coluna.coluna());
                    colunaTabela.append("), \n");
                    
                }
            
            }
        }
		
		colunaTabela.append(" primary key(ID)\n); \n");
				
		return colunaTabela.toString();
	}

    
    public EnumBDsDisponiveis getBancoUltilizado() {
        return bancoUltilizado;
    }

    
    public void setBancoUltilizado(EnumBDsDisponiveis bancoUltilizado) {
        this.bancoUltilizado = bancoUltilizado;
    }
	
}
	
