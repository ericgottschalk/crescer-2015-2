package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.exception.EncerrarPedidoException;
import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class EncerrarPedidoController {
	
	private PedidoService pedidoService;

	@Autowired
	public EncerrarPedidoController(PedidoService pedidoService){
		this.pedidoService = pedidoService;		
	}
	
	@RequestMapping(path = "/finalizar/{id}", method = RequestMethod.POST)
	public ModelAndView finalizarPedido(@PathVariable("id") Long id,
			   							final RedirectAttributes redirectAttributes){
		
		try {
			this.pedidoService.finalizar(id);
		} catch (EncerrarPedidoException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return new ModelAndView("redirect:/pedidos/pedidos/detalhes/" + id);
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Pedido finalizado com sucesso!");
		return new ModelAndView("redirect:/pedidos/pedidos/detalhes/" + id);
	}
	
	@RequestMapping(path = "/cancelar/{id}", method = RequestMethod.POST)
	public ModelAndView cancelarPedido(@PathVariable("id") Long id,
									   final RedirectAttributes redirectAttributes){
		
		try {
			this.pedidoService.cancel(id);
		} catch (EncerrarPedidoException e) {
			redirectAttributes.addFlashAttribute("erro", e.getMessage());
			return new ModelAndView("redirect:/pedidos");
		}
		redirectAttributes.addFlashAttribute("aviso", "Pedido cancelado com sucesso!");
		return new ModelAndView("redirect:/pedidos");
	}
}