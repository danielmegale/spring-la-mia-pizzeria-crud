package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;

	@GetMapping()
	public String searchPizzas(Model model, @RequestParam(required = false) String q) {

		List<Pizza> pizzas = q == null ? pizzaService.findAll() : pizzaService.findByTitle(q);

		model.addAttribute("pizzas", pizzas);
		model.addAttribute("q", q == null ? "" : q);

		return "Pizzas";
	}

	@GetMapping("/pizzas/{id}")
	public String getPizzaId(Model model, @PathVariable int id) {
		Pizza pizzaId = pizzaService.findById(id);
		model.addAttribute("pizzaId", pizzaId);
		return "pizza-detail";

	}

}
