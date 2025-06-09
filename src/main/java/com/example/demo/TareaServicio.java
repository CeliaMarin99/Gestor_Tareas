package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaServicio {
@Autowired
private TareaRepositorio tareaRepo;

	public List<Tarea> listAll(String palabraClave){
		if(palabraClave != null) {
			return tareaRepo.findAll(palabraClave);
		}
		return tareaRepo.findAllOrdenadasPorPrioridad();
		
	}
	
	public void save(Tarea tarea) {
		tareaRepo.save(tarea);
	}
	
	public Tarea get(Long id) {
		return tareaRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		tareaRepo.deleteById(id);
	}
}
