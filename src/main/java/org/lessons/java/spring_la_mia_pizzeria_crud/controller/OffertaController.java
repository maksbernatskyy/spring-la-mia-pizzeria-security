package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Offerta;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.OffertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/offerte")
public class OffertaController {
    
    @Autowired
    private OffertaRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Offerta> result = repository.findAll();
        model.addAttribute("list", result);
        return "offerte/index";
    }
    
}
