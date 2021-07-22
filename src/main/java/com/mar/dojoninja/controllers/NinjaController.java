//Marcelo Aceituno R
//Full Stack JAva 0034
//Dojos y Ninjas
package com.mar.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mar.dojoninja.models.Dojo;
import com.mar.dojoninja.models.Ninja;
import com.mar.dojoninja.services.DojoService;
import com.mar.dojoninja.services.NinjaService;

@Controller
public class NinjaController {	

	private final NinjaService ninjaService;
	private final DojoService dojoService;

	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}

	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojo();
		model.addAttribute("dojos", dojos);
		return "/ninjas/newNinjas.jsp";
	}

	@RequestMapping(value = "/ninjas", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {

		if (result.hasErrors()) {
			return "/ninjas/newNinjas.jsp";
		} else {

			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
