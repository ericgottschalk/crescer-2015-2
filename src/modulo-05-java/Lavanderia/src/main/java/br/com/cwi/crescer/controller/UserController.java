package br.com.cwi.crescer.controller;

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

import br.com.cwi.crescer.dto.UserDto;
import br.com.cwi.crescer.dto.UserDto.Role;
import br.com.cwi.crescer.service.UserService;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @RequestMapping(path="/users", method = RequestMethod.GET)
    public ModelAndView novo(){
        return new ModelAndView("users", "user", new UserDto());
    }

    @RequestMapping(path="/users", method = RequestMethod.POST)
    public ModelAndView novo(@Valid @ModelAttribute("user") UserDto dto,
            BindingResult result,
            final RedirectAttributes redirectAttributes){

        if (result.hasErrors()) {
        	redirectAttributes.addFlashAttribute("erro", "Ocorreu um erro! Tente novamente.");
            return new ModelAndView("users", "user", dto);
        }

        this.service.inserir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Usário cadastrado com sucesso!");
        return new ModelAndView("redirect:/users");
    }

    @ModelAttribute("permissoes")
    public Role[] comboPermissao() {
        return Role.values();
    }
}
