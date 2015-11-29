package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.PedidoDto;

@Service
public class PedidoService {

	private PedidoDao pedidoDao;
	private ClienteDao clienteDao;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao, ClienteDao clienteDao){
		super();
		this.pedidoDao = pedidoDao;
		this.clienteDao = clienteDao;
	}
	
	public Long add(PedidoDto dto) {
		Pedido pedido = new Pedido();
		pedido.setCliente(this.clienteDao.findById(dto.getIdCliente()));
		pedido.setDataInclusao(new Date());
		pedido.setValorBruto(new BigDecimal(0));
		pedido.setSituacao(SituacaoPedido.PENDENTE);
		return this.pedidoDao.add(pedido);
	}
	
	public PedidoDto findById(Long id){
		return this.peditoToDto(this.pedidoDao.findById(id));
	}

	public List<PedidoDto> find() {
		List<PedidoDto> list = new ArrayList<PedidoDto>();
		for (Pedido pedido : this.pedidoDao.find()){
			list.add(this.peditoToDto(pedido));
		}
		
		return list;
	}
	
	public List<PedidoDto> findFilter(PedidoDto dto) {
		List<PedidoDto> list = new ArrayList<PedidoDto>();
		if (dto.getCliente().getCpf() != null){
			for (Pedido pedido : this.pedidoDao.findByCpfSituacao(dto.getCliente().getCpf(), dto.getSituacao())){
				list.add(this.peditoToDto(pedido));
			}
		} else{
			for (Pedido pedido : this.pedidoDao.findBySituacao(dto.getSituacao())){
				list.add(this.peditoToDto(pedido));
			}
		}
			
		return list;
	}
	
	public List<PedidoDto> findBySituacao(SituacaoPedido situacao){
		List<PedidoDto> list = new ArrayList<PedidoDto>();
		for (Pedido pedido : this.pedidoDao.findBySituacao(situacao)){
			list.add(this.peditoToDto(pedido));
		}
		
		return list;
	}
	
	private PedidoDto peditoToDto(Pedido pedido){
		PedidoDto dto = new PedidoDto();
		dto.setIdPedido(pedido.getIdPedido());
		dto.setCliente(pedido.getCliente());
		dto.setDataEntrega(pedido.getDataEntrega());
		dto.setDataInclusao(pedido.getDataInclusao());
		dto.setIdCliente(pedido.getCliente().getIdCliente());
		dto.setItens(pedido.getItens());
		dto.setValorBruto(pedido.getValorBruto());
		dto.setValorTotal(pedido.getValorTotal());
		dto.setValorDesconto(pedido.getValorDesconto());
		dto.setSituacao(pedido.getSituacao());
		return dto;
	}
}
