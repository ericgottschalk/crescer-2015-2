package br.com.cwi.crescer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.ItemDto;
import br.com.cwi.crescer.dto.PedidoDto;
import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class ItensPedidoController {
	
	private PedidoService pedidoService;

	@Autowired
	public ItensPedidoController(PedidoService pedidoService){
		this.pedidoService = pedidoService;	
	}
	
	@RequestMapping(path = "/addItem/{id}", method = RequestMethod.POST)
	public ModelAndView novoItem(@Valid @ModelAttribute("item") ItemDto dto,
								 @PathVariable("id") Long id,
								 RedirectAttributes redirectAttributes){
		
		if(dto.getPeso() == null){
			redirectAttributes.addFlashAttribute("erro", "Ocorreu um erro! Preencha os campos obrigatórios.");
			ModelAndView mv = new ModelAndView("redirect:/pedidos/pedidos/detalhes/" + id);
			mv.addObject("erro", "Ocorreu um erro! Preencha os campos obrigatórios.");
			return mv;
		}
		
		dto.setIdPedido(id);
		this.pedidoService.addItem(dto);
		redirectAttributes.addFlashAttribute("mensagem", "Item adicionado com sucesso!");
		ModelAndView mv = new ModelAndView("redirect:/pedidos/pedidos/detalhes/" + id);
		return mv;
	}
	
	@RequestMapping(path = "/processarItens/{id}", method = RequestMethod.POST)
	public ModelAndView processarItens(@PathVariable("id") Long id,
									   RedirectAttributes redirectAttributes){
		
		PedidoDto dto = this.pedidoService.findById(id, true);
		this.pedidoService.processarItens(dto);
		redirectAttributes.addFlashAttribute("mensagem", "Itens processados com sucesso!");
		ModelAndView mv = new ModelAndView("redirect:/pedidos/pedidos/detalhes/" + dto.getIdPedido());
		return mv;
	}
	
	@RequestMapping(path = "/processarItem/{id}", method = RequestMethod.POST)
	public ModelAndView processarIten(@PathVariable("id") Long id,
									   RedirectAttributes redirectAttributes){
		
		this.pedidoService.processarItem(id);
		redirectAttributes.addFlashAttribute("mensagem", "Item processado com sucesso!");
		ModelAndView mv = new ModelAndView("redirect:/pedidos/pedidos/detalhes/" + id);
		return mv;
	}
}
