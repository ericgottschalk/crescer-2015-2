package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.PedidoDto;
import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class EncerrarPedidoController {
	
	private PedidoService pedidoService;

	@Autowired
	public EncerrarPedidoController(PedidoService pedidoService){
		this.pedidoService = pedidoService;		
	}
	
	@RequestMapping(path = "/cancelar/{id}", method = RequestMethod.POST)
	public ModelAndView cancelarPedido(@PathVariable("id") Long id,
									   final RedirectAttributes redirectAttributes){
		
		PedidoDto pedido = this.pedidoService.findById(id);
		this.pedidoService.cancel(pedido);
		ModelAndView mv = new ModelAndView("redirect:/pedidos");
		redirectAttributes.addAttribute("aviso", "Pedido cancelado com sucesso!");
		return mv;
	}
}