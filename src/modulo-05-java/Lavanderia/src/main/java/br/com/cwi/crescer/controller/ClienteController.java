package br.com.cwi.crescer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDto;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
public class ClienteController {

    private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @RequestMapping(path = "/clientes", method = RequestMethod.GET)
    public ModelAndView clientes() {

        List<ClienteDto> clientes  = this.clienteService.find();
        ModelAndView mv = new ModelAndView("clientes", "clientes", clientes);
        return mv;
    }
    
    @RequestMapping(path = "/clientes/{name}", method = RequestMethod.GET)
    public ModelAndView clientesPorNome(@PathVariable("name") String name,
    									final RedirectAttributes redirectAttributes) {

    	List<ClienteDto> clientes = new ArrayList<ClienteDto>();
    	if (name == null){
    		redirectAttributes.addFlashAttribute("mensagem", "Ocorreu um erro!");
    		clientes = this.clienteService.find();
    		return new ModelAndView("clientes", "clientes", clientes);
    	}
    	
        clientes = this.clienteService.findByName(name);
        
        if (clientes.size() == 0){
        	redirectAttributes.addFlashAttribute("mensagem", "Nenhum cliente encontrado!");
        	return new ModelAndView("clientes", "clientes", clientes);
        }
        
        return new ModelAndView("clientes", "clientes", clientes);
    }

    @RequestMapping(path = "/clientes/novo", method = RequestMethod.GET)
    public ModelAndView novo() {
        return new ModelAndView("clientes/novo", "cliente", new ClienteDto());
    }

    @RequestMapping(path = "/clientes/novo", method = RequestMethod.POST)
    public ModelAndView novo(@Valid @ModelAttribute("cliente") ClienteDto dto,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("clientes/novo", "cliente", dto);
        }

        this.clienteService.add(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
        return new ModelAndView("redirect:/clientes");
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return this.cidadeService.find();
    }
    
    @ModelAttribute("situacoes")
    public SituacaoCliente[]  comboSituacoes() {
        return SituacaoCliente.values();
    }
    
    @ModelAttribute("cliente")
    public ClienteDto pesquisaNome() {
        return new ClienteDto();
    }
}