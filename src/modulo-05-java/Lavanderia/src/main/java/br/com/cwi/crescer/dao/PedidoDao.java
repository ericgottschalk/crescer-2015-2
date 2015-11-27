package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;

@Repository
public class PedidoDao extends BaseDao<Pedido>{

	public Pedido findById(Long id){
    	return this.manager.find(Pedido.class, id);
    }
}
