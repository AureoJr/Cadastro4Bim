package br.univel.model;

import br.univel.model.DBUtils.annotations.Coluna;
import br.univel.model.DBUtils.annotations.Id;
import br.univel.model.DBUtils.annotations.Tabela;

@Tabela(nome = "cidade")
public class Cidade {

	@Id(nome = "id")
	private Integer id;

	@Coluna(nome = "uf")
	private String uf;

	@Coluna(nome = "nome")
	private String nomeCidade;

	@Coluna(nome = "uf_abreviado")
	private String ufAbreviado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getUfAbreviado() {
		return ufAbreviado;
	}

	public void setUfAbreviado(String ufAbreviado) {
		this.ufAbreviado = ufAbreviado;
	}

	@Override
	public String toString() {
		return "Cidade";
	}
}
