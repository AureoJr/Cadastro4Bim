package br.univel.model.DBUtils.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 *  Anotação para tratar o nome das tabelas no banco de dados 
 *  associadas ao modelo.
 * 
 * @author aureo
 * @since 29/10/2015 21:00
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

	public String nome() default "";
}
