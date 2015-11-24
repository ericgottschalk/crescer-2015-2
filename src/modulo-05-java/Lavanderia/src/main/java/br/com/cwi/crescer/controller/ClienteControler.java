package br.com.cwi.crescer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.dto.ClienteDto;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteControler {

    private ClienteService clienteService;

    @Autowired
    public ClienteControler(ClienteService clienteService) {
        this.clienteService = clienteService;
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
}
