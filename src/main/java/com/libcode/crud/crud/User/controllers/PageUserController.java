package com.libcode.crud.crud.User.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libcode.crud.crud.User.entities.Users;
import com.libcode.crud.crud.User.repository.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;







@Controller
@RequestMapping("/")

public class PageUserController {
    
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "list-users";
    }

    @GetMapping("/nuevo")
    public String formularioNuevoUser(Model model){
        model.addAttribute("usuario", new Users());
        return "form-user";
    }

    @PostMapping("/nuevo")
    public String guardarUser(@ModelAttribute Users user) {
        userRepository.save(user);
        return "redirect:/users";
    }
    

    @GetMapping("/editar/{id}")
    public String formularioEditarUser(Model model, @PathVariable Long id) {
        Users usuario = userRepository.findById(id).get();
        model.addAttribute("usuario", usuario);
        return "form-user";

    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarUser(Model model, @PathVariable Long id) {
        userRepository.delete(new Users(id));
        return "redirect:/users";
    }
    


}
