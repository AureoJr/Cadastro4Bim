package br.univel.view.interfaces;

/**
 * 
 *  Interface para validação de componentes
 * 
 * @author aureo
 *
 */
public interface IValidator {

	/**
	 * implementar as validações necessárias para validar o cadastro
	 * 
	 * @return true|false para as informações apresentadas
	 */
	public boolean validarCampos();
	
	public void preencherCampos();
	
	public void limparCampos();
}
