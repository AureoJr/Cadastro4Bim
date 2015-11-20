package br.univel.model.DBUtils.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 	Anotação para relacionamento do tipo um para um
 * 
 * @author aureo
 * @since 19/11/2015 21:43
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface UmPraUm {

	public String coluna() default "";
	
	
}
