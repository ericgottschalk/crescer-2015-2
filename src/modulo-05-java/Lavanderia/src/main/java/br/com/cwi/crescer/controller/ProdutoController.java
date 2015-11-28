package br.com.cwi.crescer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.dto.ProdutoDto;
import br.com.cwi.crescer.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView produtos() {

        List<ProdutoDto> list = new ArrayList<ProdutoDto>();

        ModelAndView mv = new ModelAndView("produtos/produtos", "produtos", list);
        return mv;
    }
}
