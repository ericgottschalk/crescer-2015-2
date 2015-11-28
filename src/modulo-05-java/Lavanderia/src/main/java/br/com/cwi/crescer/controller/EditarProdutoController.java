package br.com.cwi.crescer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.ProdutoDto;
import br.com.cwi.crescer.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class EditarProdutoController {
	
	private ProdutoService produtoService;

    @Autowired
    public EditarProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    @ModelAttribute("situacoes")
    public SituacaoProduto[]  comboSituacoes() {
        return SituacaoProduto.values();
    }
    
     @PreAuthorize("hasRole('ADMIN')")
	 @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	 public ModelAndView editar(@PathVariable("id") Long id) {
	     return new ModelAndView("produtos/editar", "produto", this.produtoService.findById(id));
	 }

	 @PreAuthorize("hasRole('ADMIN')")
	 @RequestMapping(path = "/editar", method = RequestMethod.POST)
	 public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoDto dto,
	         BindingResult result,
	         final RedirectAttributes redirectAttributes) {

	     if (result.hasErrors()) {
	    	 redirectAttributes.addFlashAttribute("erro", "Ocorreu um erro! Tente novamente.");
	         return new ModelAndView("produtos/editar", "produto", dto);
	     }

	     this.produtoService.update(dto);
	     redirectAttributes.addFlashAttribute("mensagem", "Produto editado com sucesso!");
	     return new ModelAndView("redirect:/produtos");
	 }
}
