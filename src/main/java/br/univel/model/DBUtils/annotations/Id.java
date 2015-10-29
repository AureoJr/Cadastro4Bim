package br.univel.model.DBUtils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Anotação responsável por garantir que a tabela contenha
 * o campo ID e em casos que o campo id possui outro nome.
 * OBS: essa anotação descarta a anotação coluna
 * 
 * @author Aureo
 * @since 29/10/2015 21:12
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Id {

	public String nome() default ""; 
}
