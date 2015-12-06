package br.univel.model;

import br.univel.model.DBUtils.annotations.Coluna;
import br.univel.model.DBUtils.annotations.Id;
import br.univel.model.DBUtils.annotations.Tabela;
import br.univel.model.DBUtils.annotations.UmPraUm;
import br.univel.model.enums.EnumGenero;


/**
 * Classe que representa a modelo do cliente 
 * 
 * @author Aureo
 * @since 27/10/2015 19:53  
 */
@Tabela(nome = "Cliente")
public class Cliente extends Entidade{
	
    @Id
	private Integer id;
    
    @Coluna(nome ="telefone")
	private String telefone;
    
    @Coluna(nome ="endereco")
	private String endereco;
    
    @Coluna(nome ="id_cidade", tipo ="integer")
    @UmPraUm(coluna="id")
	private Cidade cidade;
    
    @Coluna(nome ="email")
	private String email;
    
    @Coluna(nome ="genero")
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
	
	@Override
	public String toString() {
	
		return "Cliente";
	}
	
}
