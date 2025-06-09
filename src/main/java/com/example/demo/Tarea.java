package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Table(name= "tareas")
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Debes seleccionar una propiedad")
    private String prioridad;
    
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    private boolean completada=false;
    
    @NotNull(message = "Debes seleccionar un usuario")
    @ManyToOne
    @JoinColumn(name = "usuario_nombre")
    private Usuario usuario;
    
    

	public Tarea() {
	}

	public Tarea(String prioridad, String descripcion, boolean completada) {
		this.prioridad = prioridad;
		this.descripcion = descripcion;
		this.completada = completada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String p) {
		this.prioridad = p;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    
}

