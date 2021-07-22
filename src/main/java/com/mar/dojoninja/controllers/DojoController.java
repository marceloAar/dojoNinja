//Marcelo Aceituno R
//Full Stack JAva 0034
//Dojos y Ninjas
package com.mar.dojoninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mar.dojoninja.models.Dojo;
import com.mar.dojoninja.services.DojoService;

@Controller
public class DojoController {

	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}

	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}

	@RequestMapping(value = "/dojos", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}

	@RequestMapping("/dojos/{id}")
	public String getDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojos/list.jsp";
	}

}
