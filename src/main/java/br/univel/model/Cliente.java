package br.univel.model;

import br.univel.model.enums.EnumGenero;


/**
 * Classe que representa a modelo do cliente 
 * 
 * @author Aureo
 * @since 27/10/2015 19:53  
 */
public class Cliente extends Entidade{
	
	private Integer id;
	private String telefone;
	private String endereco;
	private Cidade cidade;
	private String email;
	private EnumGenero enumGenero;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EnumGenero getEnumGenero() {
		return enumGenero;
	}
	public void setEnumGenero(EnumGenero enumGenero) {
		this.enumGenero = enumGenero;
	}
	
	
}
