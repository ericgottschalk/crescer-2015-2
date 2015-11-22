package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.domain.Pedido;

@Service
public class PedidoService {

	private PedidoDao dao;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao){
		super();
		this.dao = pedidoDao;
	}
	
	public Pedido findById(long id){
		return this.dao.findById(id);
	}
}
