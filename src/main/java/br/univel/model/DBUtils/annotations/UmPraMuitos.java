package br.univel.model.DBUtils.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 	Anotação para identificar relações do tipoum para muitos
 * 
 * @author aureo
 * @since 29/10/2015 21:07
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface UmPraMuitos {

	public String coluna() default "";
	
	
}
