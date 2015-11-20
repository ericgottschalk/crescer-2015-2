package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Bem Vindo, Locadora Crescer";
        mv.addObject("mensagem", mensagem);

        return mv;
    }
}
