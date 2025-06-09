package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class Controlador {
	@Autowired
	private TareaServicio tareaRepo;
	
	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
	
	@GetMapping("/")
	public String listarTareas(Model modelo, @Param("palabraClave") String palabraClave) {
		List<Tarea> listaTareas = tareaRepo.listAll(palabraClave);
		
		modelo.addAttribute("palabraClave",palabraClave);
		modelo.addAttribute("listaTareas",listaTareas);
		
		return "index";
	}
	
	@GetMapping("/nueva")
	public String mostrarFormularioNueva(Model modelo) {
		List<Usuario> listaUsuarios = usuarioRepo.findAll();
		modelo.addAttribute("tarea", new Tarea());
		modelo.addAttribute("listaUsuarios", listaUsuarios);
		return "nuevaTarea";
	}
	
	@PostMapping("/guardar")
	public String guardarTarea(@Valid Tarea tarea, BindingResult result, Model modelo) {
	    if (result.hasErrors()) {
	        // Vuelve a cargar las listas para el formulario
	        List<Usuario> listaUsuarios = usuarioRepo.findAll();
	        modelo.addAttribute("listaUsuarios", listaUsuarios);
	        return "nuevaTarea"; // Vuelve al formulario si hay errores
	    }

	    tareaRepo.save(tarea);
	    return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable(name="id") Long id, Model modelo) {
	    Tarea tarea = tareaRepo.get(id);  // <-- Asegúrate de tener este método en tu servicio
	    List<Usuario> listaUsuarios = usuarioRepo.findAll();

	    modelo.addAttribute("tarea", tarea);
	    modelo.addAttribute("listaUsuarios", listaUsuarios);
	    return "editarTarea";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarTarea(@PathVariable(name="id")Long id) {
		tareaRepo.delete(id);
		return "redirect:/";
	}
	
}
