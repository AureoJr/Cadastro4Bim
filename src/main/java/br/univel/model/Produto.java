package br.univel.model;

import java.math.BigDecimal;

import br.univel.model.DBUtils.annotations.Coluna;
import br.univel.model.DBUtils.annotations.Id;
import br.univel.model.DBUtils.annotations.Tabela;
import br.univel.model.enums.EnumCategoriaProduto;
import br.univel.model.enums.EnumTipoUnidade;

@Tabela(nome = "produto")
public class Produto {

	@Id
	private Integer id;
	
	@Coluna(nome = "codigo_barra")
	private Integer codigoBarra;
	
	@Coluna(nome = "categoria_produto")
	private EnumCategoriaProduto enumCategoriaProduto;
	
	@Coluna(nome ="descricao")
	private String descricao;
	
	@Coluna(nome="tipo_unidade")
	private EnumTipoUnidade enumTipoUnidade;
	
	@Coluna(nome="custo")
	private BigDecimal custo;
	
	@Coluna(nome = "margem_lucro")
	private BigDecimal margemLucro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	 
	public Integer getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarras(Integer codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public EnumCategoriaProduto getEnumCategoriaProduto() {
		return enumCategoriaProduto;
	}

	public void setEnumCategoriaProduto(
			EnumCategoriaProduto enumCategoriaProdurto) {
		this.enumCategoriaProduto = enumCategoriaProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EnumTipoUnidade getEnumTipoUnidade() {
		return enumTipoUnidade;
	}

	public void setEnumTipoUnidade(EnumTipoUnidade enumTipoUnidade) {
		this.enumTipoUnidade = enumTipoUnidade;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}
}
