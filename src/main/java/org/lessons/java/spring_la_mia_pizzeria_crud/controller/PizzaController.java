package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.spring_la_mia_pizzeria_crud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/pizze")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    // Index
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", pizzaService.findAllPizzas());
        return "pizze/index";
    }

    // Show
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", pizzaService.findPizzaById(id).get());
        return "pizze/show";
    }

    // Store
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizze/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "pizze/create";
        }

        pizzaService.savePizza(pizza);
        return "redirect:/pizze";
    }

    // Update
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", pizzaService.findPizzaById(id).get());
        return "pizze/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("pizza") Pizza pizza, @PathVariable("id") Integer id,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/pizze/edit";
        }

        pizzaService.savePizza(pizza);
        return "redirect:/pizze";
    }

    // Delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        pizzaService.deletePizzaById(id);
        return "redirect:/pizze";
    }

}
