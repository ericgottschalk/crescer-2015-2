package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	public void finalizar(Long id) throws EncerrarPedidoException {
		Pedido pedido = this.pedidoDao.findById(id);
		if (pedido.getSituacao() != SituacaoPedido.PENDENTE){
			throw new EncerrarPedidoException("Pedido não está pendente para ser finalizado!");
		}
		pedido.setDataEntrega(this.getDataEntrega(pedido));
		pedido.setValorDesconto(this.getValorDesconto(pedido));
		pedido.setValorTotal(this.getValorFinal(pedido));
		pedido.setSituacao(SituacaoPedido.PROCESSANDO);
		this.pedidoDao.update(pedido);
	}
	
	public void encerrar(Long id) throws EncerrarPedidoException{
		Pedido pedido = this.pedidoDao.findById(id);
		if (pedido.getSituacao() != SituacaoPedido.PROCESSADO){
			throw new EncerrarPedidoException("Pedido não está processado para ser encerrado!");
		}
		pedido.setDataEntrega(new Date());
		pedido.setSituacao(SituacaoPedido.ENCERRADO);
		this.pedidoDao.update(pedido);
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
		if (pedido.getSituacao() != SituacaoPedido.ENCERRADO && pedido.getSituacao() != SituacaoPedido.CANCELADO){
			if (verificar)
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
			list.add(this.peditoToDto(pedido));
		}
		
		return list;
	}
	
	public List<PedidoDto> findFilter(PedidoDto dto) {
		List<PedidoDto> list = new ArrayList<PedidoDto>();
		if ((dto.getCliente().getCpf() != null && !dto.getCliente().getCpf().isEmpty()) && dto.getSituacao() != null){
			for (Pedido pedido : this.pedidoDao.findByCpfSituacao(dto.getCliente().getCpf(), dto.getSituacao())){
				list.add(this.peditoToDto(pedido));
			}
			
			return list;
		} 
		
		if (dto.getSituacao() != null){
			for (Pedido pedido : this.pedidoDao.findBySituacao(dto.getSituacao())){
				list.add(this.peditoToDto(pedido));
			}
			
			return list;
		}
	
		if (dto.getCliente().getCpf() != null){
			for (Pedido pedido : this.pedidoDao.findByCpf(dto.getCliente().getCpf())){
				list.add(this.peditoToDto(pedido));
			}
			
			return list;
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
	
	public BigDecimal getValorBrutoPedido(Pedido pedido){
		Double valor = 0D;
		for (Item item : pedido.getItens()){
			valor += item.getValorTotal().doubleValue();
		}
		
		return new BigDecimal(valor);
	}
	
	public BigDecimal getValorDesconto(Pedido pedido){
		List<Double> list = new ArrayList<Double>();
		Double desconto = 0D;
		Double pesoTotal = 0D;
		for (Item item : pedido.getItens()){
			pesoTotal += item.getPeso();
		}
		
		Calendar date =  Calendar.getInstance();
		date.setTime(pedido.getDataInclusao());
		int dia = date.get(Calendar.DAY_OF_WEEK);
		switch(dia){
			case 1:
			case 2:
			case 3:
				list.add(8D);
				break;
			case 4:
			case 5:
				list.add(4D);
				break;
				
			default:
				break;
		}
		
		if (pedido.getValorBruto().intValue() > 90 || pesoTotal > 15){
			list.add(4.87);
		}
		
		for (Double value : list){
			if (desconto < value){
				desconto = value;
			}
		}
		
		Double valor = (pedido.getValorBruto().doubleValue() * desconto) / 100;
		return new BigDecimal(valor);
	}
	
	public BigDecimal getValorFinal(Pedido pedido){
		BigDecimal desconto = pedido.getValorDesconto();
		Double valor = pedido.getValorBruto().doubleValue();
		Double valorFinal = valor - desconto.doubleValue();
		return new BigDecimal(valorFinal);
	}
	
	public Date getDataEntrega(Pedido pedido){
		int prazo = 0;
		for (Item item : pedido.getItens()){
			if (prazo < item.getProduto().getPrazo()){
				prazo = item.getProduto().getPrazo();
			}
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pedido.getDataInclusao()); 
		calendar.add(Calendar.DAY_OF_MONTH, prazo);
		return calendar.getTime();
	}

	public void processarItens(PedidoDto dto) {
		this.itemService.processarItens(dto.getItens());
	}
	
	public Long processarItem(Long id) throws Exception{
		try {
			return this.itemService.processarItem(id);
		} catch (Exception e) {
			throw e;
		}
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
