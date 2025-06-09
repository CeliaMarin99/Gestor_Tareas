package com.example.demo;
import jakarta.persistence.*;


@Table(name= "usuarios")
@Entity
public class Usuario {

	@Id
	@Column(unique = true, nullable = false)
	private String nombre; // Usado como username

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String rol;
    
    

	public Usuario() {}

	public Usuario(String nombre, String password, String rol) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
   

}
