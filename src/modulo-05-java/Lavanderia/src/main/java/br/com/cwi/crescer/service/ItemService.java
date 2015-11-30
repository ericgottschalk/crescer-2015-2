package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.dao.ProdutoDao;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.dto.ItemDto;

@Service
public class ItemService {

	private ItemDao dao;
	private PedidoDao pedidoDao;
	private ProdutoDao produtoDao;
	
	@Autowired
	public ItemService(ItemDao itemDao, PedidoDao pedidoDao, ProdutoDao produtoDao){
		super();
		this.dao = itemDao;
		this.pedidoDao = pedidoDao;
		this.produtoDao = produtoDao;
	}

	public Item add(ItemDto dto) {
		Item item = this.dtoToItem(dto);	
		item.setValor(item.getProduto().getValor());
		item.setValorTotal(this.getValorTotal(item));
		item.setSituacao(SituacaoItem.PENDENTE);
		this.dao.add(item);
		return item;
	}
	
	private BigDecimal getValorTotal(Item item){
		Double valorTotal = item.getPeso() * item.getValor().doubleValue();
		return new BigDecimal(valorTotal);
	}
	
	private Item dtoToItem(ItemDto dto){
		Item item = new Item();
		item.setPedido(this.pedidoDao.findById(dto.getIdPedido()));
		item.setProduto(this.produtoDao.findById(dto.getIdProduto()));
		item.setPeso(dto.getPeso());
		item.setSituacao(dto.getSituacao());
		item.setValor(dto.getValor());
		item.setValorTotal(dto.getValorTotal());
		return item;
	}

	public void processarItens(List<Item> itens) {
		for (Item item : itens){
			item.setSituacao(SituacaoItem.PROCESSADO);
			this.dao.update(item);
		}
	}
	
	public void processarItem(Long idItem){
		Item item = this.dao.findById(idItem);
		item.setSituacao(SituacaoItem.PROCESSADO);
		this.dao.update(item);
	}
}
