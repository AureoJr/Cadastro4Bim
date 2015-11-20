package br.univel.model;

import java.sql.Date;
import java.util.List;

import br.univel.model.DBUtils.annotations.Coluna;
import br.univel.model.DBUtils.annotations.Id;
import br.univel.model.DBUtils.annotations.Tabela;
import br.univel.model.DBUtils.annotations.UmPraMuitos;
import br.univel.model.DBUtils.annotations.UmPraUm;

/**
 * 
 *  Tabela para representar as vendas
 * 
 * @author aureo
 * @since 19/11/2015 21:47
 */

@Tabela(nome = "venda")
public class Venda {

	@Id
	private Integer id;
	
	@Coluna(nome = "timestamp")
	private Date timestamp;
	
	@UmPraUm(coluna = "id_cliente")
	private Cliente cliente;
	
	@UmPraMuitos(coluna = "id_venda")
	private List<ItemVenda> listaItemVenda;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemVenda> getListaItemVenda() {
		return listaItemVenda;
	}

	public void setListaItemVenda(List<ItemVenda> listaItemVenda) {
		this.listaItemVenda = listaItemVenda;
	}

	
}
