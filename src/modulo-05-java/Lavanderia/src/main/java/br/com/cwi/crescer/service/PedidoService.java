package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.ItemDto;
import br.com.cwi.crescer.dto.PedidoDto;
import br.com.cwi.crescer.exception.EncerrarPedidoException;

@Service
public class PedidoService {

	private PedidoDao pedidoDao;
	private ClienteDao clienteDao;
	private ItemService itemService;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao, ClienteDao clienteDao,
						ItemService itemService){
		super();
		this.pedidoDao = pedidoDao;
		this.clienteDao = clienteDao;
		this.itemService = itemService;
	}
	
	public Long add(PedidoDto dto) {
		Pedido pedido = new Pedido();
		pedido.setCliente(this.clienteDao.findById(dto.getIdCliente()));
		pedido.setDataInclusao(new Date());
		pedido.setValorBruto(new BigDecimal(0));
		pedido.setSituacao(SituacaoPedido.PENDENTE);
		this.pedidoDao.add(pedido);
		return pedido.getIdPedido();
	}
	
	public void addItem(ItemDto dto) {
		Item item = this.itemService.add(dto);
		item.getPedido().setValorBruto(this.getValorBrutoPedido(item.getPedido()));
		this.pedidoDao.update(item.getPedido());
	}
	
	public void cancel(Long id) throws EncerrarPedidoException {
		Pedido pedido = this.pedidoDao.findById(id);
		if (pedido.getSituacao() == SituacaoPedido.CANCELADO || pedido.getSituacao() == SituacaoPedido.ENCERRADO){
			throw new EncerrarPedidoException("Pedido já está cancelado ou encerrado!");
		}
		pedido.setSituacao(SituacaoPedido.CANCELADO);
		this.pedidoDao.update(pedido);
	}
	
	public PedidoDto findById(Long id, Boolean verificar){
		Pedido pedido = this.pedidoDao.findById(id);
		if (verificar){
			this.verificar(pedido);
		}
		return this.peditoToDto(pedido);
	}

	private Boolean verificar(Pedido pedido) {
		Boolean processado = true;
		
		if (pedido.getIdPedido() != null && pedido.getItens().isEmpty()){
			processado = false;
		}
		
		for (Item item : pedido.getItens()){
			if (item.getSituacao() != SituacaoItem.PROCESSADO){
				processado = false;
			}
		}
		
		if (processado){
			pedido.setSituacao(SituacaoPedido.PROCESSADO);
			this.pedidoDao.update(pedido);
		}
		
		return processado;
	}

	public List<PedidoDto> find() {
		List<PedidoDto> list = new ArrayList<PedidoDto>();
		for (Pedido pedido : this.pedidoDao.find()){
			this.verificar(pedido);
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
	
	private BigDecimal getValorBrutoPedido(Pedido pedido){
		Double valor = 0D;
		for (Item item : pedido.getItens()){
			valor += item.getValorTotal().doubleValue();
		}
		
		return new BigDecimal(valor);
	}

	public void processarItens(PedidoDto dto) {
		this.itemService.processarItens(dto.getItens());
	}
	
	public void processarItem(Long idItem){
		this.itemService.processarItem(idItem);
	}

	public void finalizar(Long id) throws EncerrarPedidoException {
		Pedido pedido = this.pedidoDao.findById(id);
		if (pedido.getSituacao() != SituacaoPedido.PENDENTE){
			throw new EncerrarPedidoException("Pedido não está pendente para ser finalizado!");
		}
		pedido.setSituacao(SituacaoPedido.PROCESSANDO);
		this.pedidoDao.update(pedido);
	}
}
