package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class ItensPedidoController {
	
	private PedidoService pedidoService;
	private ItemService itemService;

	@Autowired
	public ItensPedidoController(PedidoService pedidoService, ItemService itemService){
		this.pedidoService = pedidoService;
		this.itemService = itemService;		
	}
}
