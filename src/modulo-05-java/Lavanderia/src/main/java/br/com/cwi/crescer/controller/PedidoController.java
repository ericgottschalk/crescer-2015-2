package br.com.cwi.crescer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.ClienteDto;
import br.com.cwi.crescer.dto.ItemDto;
import br.com.cwi.crescer.dto.PedidoDto;
import br.com.cwi.crescer.dto.ProdutoDto;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ProdutoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;
	private ClienteService clienteService;
	private ProdutoService produtoService;

	@Autowired
	public PedidoController(PedidoService pedidoService, ClienteService clienteService,
							ProdutoService produtoService){
		this.pedidoService = pedidoService;
		this.clienteService = clienteService;
		this.produtoService = produtoService;		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView pedidos(){
		List<PedidoDto> list = this.pedidoService.find();
		
		return new ModelAndView("pedidos", "pedidos", list);
	}
	
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public ModelAndView pedidosFiltro(@ModelAttribute("pedido") PedidoDto dto,
									  final RedirectAttributes redirectAttributes){
		
		List<PedidoDto> list = new ArrayList<PedidoDto>();
		if (dto.getCliente().getCpf() == null && dto.getSituacao() == null){
			list = this.pedidoService.find();
			ModelAndView mv = new ModelAndView("pedidos", "pedidos", list);
			mv.addObject("aviso", "Filtro em branco! Preencha os campos para pesquisar.");
			return mv;
		}
		
		list = this.pedidoService.findFilter(dto);
		
		if (list.size() == 0){
			ModelAndView mv = new ModelAndView("pedidos", "pedidos", list);
			mv.addObject("erro", "Nenhum pedido encontrado!");
			return mv;
		}
		
		return new ModelAndView("pedidos", "pedidos", list);
	}
	
	@RequestMapping(path = "/pedidos/novo", method = RequestMethod.POST)
	public ModelAndView novo(@ModelAttribute("pedido") PedidoDto dto,
							 final RedirectAttributes redirectAttributes){
		
		Long id = this.pedidoService.add(dto);	
		PedidoDto pedido = this.pedidoService.findById(id, false);
		redirectAttributes.addFlashAttribute("mensagem", "Pedido criado com sucesso!");
		return new ModelAndView("pedidos/detalhes", "pedido", pedido);
	}
	
	@RequestMapping(path = "pedidos/detalhes/{id}", method = RequestMethod.GET)
	public ModelAndView detalhes(@PathVariable("id") Long id){
		return new ModelAndView("pedidos/detalhes", "pedido", this.pedidoService.findById(id, true));
	}
	
	@ModelAttribute("produtos")
	public List<ProdutoDto> produtos(){
		return this.produtoService.find();
	}
	
	@ModelAttribute("item")
	public ItemDto item(){
		return new ItemDto();
	}
	
	@ModelAttribute("pedido")
	public PedidoDto pedidoAttr(){
		return new PedidoDto();
	}
	
	@ModelAttribute("clientes")
	public List<ClienteDto> clientesAttr(){
		return this.clienteService.findAtivos();
	}
	
	@ModelAttribute("situacoes")
	public SituacaoPedido[] situacoesAttr(){
		return SituacaoPedido.values();
	}
}
