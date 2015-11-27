package br.com.cwi.crescer.controller;

import java.util.ArrayList;
import java.util.List;

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

import br.com.cwi.crescer.dto.UserDto;
import br.com.cwi.crescer.dto.UserDto.Role;
import br.com.cwi.crescer.service.UserService;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service){
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView users(String name) {
	
	    List<UserDto> users = new ArrayList<UserDto>();
	    if (name == null){
	    	users = this.service.find();
	    }else{
	    	users = this.service.findByName(name);
	    }
	    
	    ModelAndView mv = new ModelAndView("users", "users", users);
	    return mv;
	}
	
	@RequestMapping(path = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(){
		return new ModelAndView("users/novo", "user", new UserDto());
	}
	
	@RequestMapping(path = "/novo", method = RequestMethod.POST)
	public ModelAndView novo(@Valid @ModelAttribute("user") UserDto dto,
            				 BindingResult result,
            				 final RedirectAttributes redirectAttributes){
		
		if (result.hasErrors()) {
            return new ModelAndView("users/novo", "user", dto);
        }

        this.service.inserir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "User cadastrado com sucesso!");
        return new ModelAndView("redirect:/users");
	}
	
	@RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") String id){
		return new ModelAndView("users/editar", "user", this.service.findByUsername(id));
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(@Valid @ModelAttribute("user") UserDto dto,
            				 BindingResult result,
            				 final RedirectAttributes redirectAttributes){
		
		if (result.hasErrors()) {
            return new ModelAndView("users/editar", "user", dto);
        }

        this.service.update(dto);
        redirectAttributes.addFlashAttribute("mensagem", "User atualizado com sucesso!");
        return new ModelAndView("redirect:/users");
	}
	
	@ModelAttribute("permissoes")
    public Role[] comboPermissao() {
        return Role.values();
    }
}
