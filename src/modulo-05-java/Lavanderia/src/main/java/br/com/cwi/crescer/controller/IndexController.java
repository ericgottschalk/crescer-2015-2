package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.service.CidadeService;

@Controller
public class IndexController {

	private CidadeService service;
	
	@Autowired
	public IndexController(CidadeService service) {
		super();
		this.service = service;
	}
	
    @RequestMapping(name = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Bem Vindo, Locadora Crescer";
        
        Cidade cidade = this.service.findById(1);
        mv.addObject("mensagem", cidade.getName() + " - " + cidade.getUf());

        return mv;
    }
}
