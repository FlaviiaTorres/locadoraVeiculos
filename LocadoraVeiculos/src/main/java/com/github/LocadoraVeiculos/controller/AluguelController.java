package com.github.LocadoraVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.LocadoraVeiculos.model.Carro;
import com.github.LocadoraVeiculos.model.Condutor;
import com.github.LocadoraVeiculos.repository.carroRepository;
import com.github.LocadoraVeiculos.repository.condutorRepository;

import jakarta.validation.Valid;

@RestController
public class AluguelController {

    @Autowired
    private condutorRepository repocondutor;
    @Autowired
    private carroRepository repoCarro;


    // CADASTRAR Carro
	@RequestMapping(value = "/cadastrarCarro", method = RequestMethod.GET)
	public String form() {
		return "carro/formCarro";
	}

    @RequestMapping(value = "/cadastrarCarro", method = RequestMethod.POST)
	public String form(@Valid Carro carro, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/cadastrarCarro";
		}

		repoCarro.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro cadastrado com sucesso!");
		return "redirect:/cadastrarCarro";
	}

	// LISTAR CARROS

	@RequestMapping("/carro")
	public ModelAndView listaCarro() {
		ModelAndView mv = new ModelAndView("carro/listaCarro");
		Iterable<Carro> carro = repoCarro.findAll();
		mv.addObject("carro", carro);
		return mv;
	}

	//
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesCarro(@PathVariable("codigo") long codigo) {
		Carro carro = repoCarro.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("carro/detalhesCarro");
		mv.addObject("carro", carro);

		Iterable<Condutor> condutor = repocondutor.findByCarro(carro);
		mv.addObject("condutor", condutor);

		return mv;

	}

    
}
