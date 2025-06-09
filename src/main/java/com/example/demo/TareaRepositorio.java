package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TareaRepositorio extends JpaRepository<Tarea,Long>{
	
	@Query("SELECT t FROM Tarea t WHERE CONCAT(t.id, '', t.prioridad, t.usuario.nombre) LIKE %?1%")
	List<Tarea> findAll(String palabraClave);
	
	@Query("SELECT t FROM Tarea t ORDER BY " +
		       "CASE t.prioridad " +
		       "WHEN 'Alta' THEN 1 " +
		       "WHEN 'Media' THEN 2 " +
		       "WHEN 'Baja' THEN 3 " +
		       "ELSE 4 END")
		List<Tarea> findAllOrdenadasPorPrioridad();
	
}
