package com.app.controller;

import com.app.model.Curso;
import com.app.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class CursoController {

	@Autowired
	CursoService service;

	@GetMapping("/")
	public ModelAndView listar() {
		ModelAndView modelView = new ModelAndView();
		List<Curso> cursos = service.listar();
		modelView.addObject("cursos", cursos);
		modelView.setViewName("index");
		return modelView;
	}

	@GetMapping("/novo")
	public ModelAndView paginaSalvar() {
		Curso curso = new Curso();
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("cursoFormulario", curso);
		modelView.setViewName("form");
		return modelView;
	}

	
	@PostMapping("/salvarCurso")
	public ModelAndView salvar(@ModelAttribute("curso") Curso curso) {
		service.salvar(curso);
		return new ModelAndView("redirect:/");
	}


	@GetMapping("/apagarCurso/{codigo}")
	public ModelAndView apagar(@PathVariable("codigo") long id) {
		service.apagar(id);
		return new ModelAndView("redirect:/");
	}


	@GetMapping("/editarCurso/{codigo}")
	public ModelAndView atualizar(@PathVariable("codigo") long id) {

		ModelAndView modelView = new ModelAndView();
		Curso curso = service.procurarPorId(id);
		modelView.addObject("cursoFormulario", curso);
		modelView.setViewName("form");
		return modelView;
	}

}
