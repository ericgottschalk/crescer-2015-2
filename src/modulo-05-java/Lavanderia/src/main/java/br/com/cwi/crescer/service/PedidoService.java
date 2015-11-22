package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.domain.Pedido;

public class PedidoService {

	private PedidoDao dao;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao){
		this.dao = pedidoDao;
	}
	
	public Pedido findById(long id){
		return this.dao.findById(id);
	}
}
