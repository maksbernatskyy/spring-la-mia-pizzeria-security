package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Ingrediente;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @GetMapping
    public String index(Model model) {
        List<Ingrediente> result = ingredienteRepository.findAll();
        model.addAttribute("list", result);
        return "/ingredienti/index";
    }

}
