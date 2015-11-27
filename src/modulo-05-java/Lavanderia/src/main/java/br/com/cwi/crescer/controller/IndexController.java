package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("home");
        String mensagem = "Bem Vindo, Lavanderia Crescer";

        mv.addObject("mensagem", mensagem);

        return mv;
    }
}
