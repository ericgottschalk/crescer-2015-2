package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ProdutoDto;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
	private MaterialService materialService;
	private ServicoService servicoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, 
				    		 MaterialService materialService, 
				    		 ServicoService servicoService) {
        this.produtoService = produtoService;
		this.materialService = materialService;
		this.servicoService = servicoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView produtos() {

        List<ProdutoDto> list = this.produtoService.find();

        ModelAndView mv = new ModelAndView("produtos", "produtos", list);
        return mv;
    }
    
    @RequestMapping(path = "/produtos/pesquisa", method = RequestMethod.GET)
    public ModelAndView produtosFIltro(@ModelAttribute("pesquisa") ProdutoDto dto,
    									final RedirectAttributes redirectAttributes) {

    	if(dto.idMaterial == null && dto.idServico == null){
    		redirectAttributes.addFlashAttribute("aviso", "Filtos em branco! Preencha os campos para pesquisar.");
    		return new ModelAndView("redirect:/produtos");
    	}
    	
    	List<ProdutoDto> produtos = this.produtoService.findFilter(dto);
        
        if (produtos.size() == 0){
        	redirectAttributes.addFlashAttribute("erro", "Nenhum produto encontrado!");
        	return new ModelAndView("redirect:/produtos");
        }
        
        return new ModelAndView("produtos", "produtos", produtos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/produtos/novo", method = RequestMethod.POST)
    public ModelAndView novo(@Valid @ModelAttribute("produto") ProdutoDto dto,
    						 BindingResult result,
                             final RedirectAttributes redirectAttributes) {

    	if (result.hasErrors()){
            ModelAndView mv = new ModelAndView("/produtos", "modal", true);
            mv.addObject("erro", "Ocorreu um erro! Preencha os campos obrigatórios.");
            return mv;
    	}
    	
        try {
			this.produtoService.add(dto);
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/produtos");
            mv.addObject("erro", e.getMessage());
            return mv;
		}
        
        redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
        return new ModelAndView("redirect:/produtos");
    }
    
    @ModelAttribute("produto")
    public ProdutoDto modelPesquisa(){
    	return new ProdutoDto();
    }
   
    @ModelAttribute("situacoes")
    public SituacaoProduto[]  comboSituacoes() {
        return SituacaoProduto.values();
    }
    
    @ModelAttribute("materiais")
    public List<Material> comboMateriais() {
        return this.materialService.find();
    }
    
    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return this.servicoService.find();
    }
}
