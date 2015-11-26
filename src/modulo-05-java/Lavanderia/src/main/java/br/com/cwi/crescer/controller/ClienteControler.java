package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDto;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteControler {

    private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteControler(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView clientes() {

        List<ClienteDto> clientes = this.clienteService.find();
        ModelAndView mv = new ModelAndView("clientes", "clientes", clientes);
        return mv;
    }

    @RequestMapping(path = "detalhes/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("clientes/detalhes", "cliente", this.clienteService.findById(id));
    }

    @RequestMapping(path = "/novo", method = RequestMethod.GET)
    public ModelAndView novo() {
        return new ModelAndView("clientes/novo", "cliente", new ClienteDto());
    }

    @RequestMapping(path = "/novo", method = RequestMethod.POST)
    public ModelAndView novo(@Valid @ModelAttribute("cliente") ClienteDto dto,
			   			     BindingResult result,
			   			     final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("clientes/editar", "cliente", dto);
		}
        this.clienteService.add(dto);
        return new ModelAndView("redirect:/clientes");
    }

    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable("id") Long id) {
        return new ModelAndView("clientes/editar", "cliente", this.clienteService.findById(id));
    }

    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDto dto,
							   BindingResult result,
							   final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("clientes/editar", "cliente", dto);
		}
        this.clienteService.update(dto.id);
        return new ModelAndView("redirect:/clientes");
    }

    @RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
    public ModelAndView remover(@PathVariable("id") Long id) {
        this.clienteService.remove(id);
        return new ModelAndView("redirect:/clientes");
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return this.cidadeService.find();
    }
}