package br.univel.model;

import java.math.BigDecimal;

import br.univel.model.enums.EnumCategoriaProduto;
import br.univel.model.enums.EnumTipoUnidade;

public class Produto {

	 	private Integer id;
	 	private Integer codigoDeBarras;
	 	private EnumCategoriaProduto enumCategoriaProduto;
	 	private String descricao;
	 	private EnumTipoUnidade enumTipoUnidade;
	 	private BigDecimal custo;
	 	private BigDecimal margemLucro;
		
	 	public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getCodigoDeBarras() {
			return codigoDeBarras;
		}
		public void setCodigoDeBarras(Integer codigoDeBarras) {
			this.codigoDeBarras = codigoDeBarras;
		}
		public EnumCategoriaProduto getEnumCategoriaProduto() {
			return enumCategoriaProduto;
		}
		public void setEnumCategoriaProduto(EnumCategoriaProduto enumCategoriaProduto) {
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
