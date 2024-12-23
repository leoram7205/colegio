package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.DimensionesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.service.DimensionesService;
import com.uan.colegio.service.ColegiosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/notas/dimensiones")
public class DimensionesController {
	

	@Autowired
	private ColegiosService colegiosrv;
	@Autowired
	private DimensionesService dimensionesrv;
	
	
	
	@GetMapping("/")
	public String listarDimensiones(Model model, HttpSession sesion) {
		List<DimensionesDto> listaDtoDimensiones = dimensionesrv.findAll();
		
		model.addAttribute("titulo","Lista de Dimensiones");
		model.addAttribute("Dimensiones",listaDtoDimensiones);
		
		return "views/notas/dimensiones/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		DimensionesDto dimensionesDto = new DimensionesDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Periodo");
		model.addAttribute("Dimensiones", dimensionesDto);
		model.addAttribute("colegios", listaDtoColegios);
		
		return "views/notas/dimensiones/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarDimensiones(@ModelAttribute DimensionesDto dimensionesDto) {
		
		dimensionesrv.save(dimensionesDto);
		
		return "redirect:/views/notas/dimensiones/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idperiodo,  Model model, HttpSession sesion) {
		
		DimensionesDto dimensionesDto = dimensionesrv.findByid(idperiodo);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();

		model.addAttribute("titulo","Formulario nueva Dimension");
		model.addAttribute("Dimensiones", dimensionesDto);
		model.addAttribute("colegios", listaDtoColegios);
		
		return "views/notas/dimensiones/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idperiodo,  Model model, HttpSession sesion) {
		
		dimensionesrv.deleteById(idperiodo);
		
		return "redirect:/views/notas/dimensiones/";
	}
}
