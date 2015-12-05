package br.univel.model;

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
	
	@Coluna(nome = "hora_venda",tipo = "integer")
	private Integer horaVenda;
	
	@Coluna(nome = "id_cliente",tipo = "integer")
	@UmPraUm(coluna = "ID")
	private Cliente cliente;
	
//	@Coluna(nome = "id_cliente",tipo = "integer")
	@UmPraMuitos(coluna = "id_venda")
	private List<ItemVenda> listaItemVenda;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getHoraVenda() {
        return horaVenda;
    }

    
    public void setHoraVenda(Integer horaVenda) {
        this.horaVenda = horaVenda;
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
