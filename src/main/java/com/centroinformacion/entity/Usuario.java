package com.centroinformacion.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "usuario")
public class Usuario implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombres;
	private String apellidos;
	private String dni;
	private String login;
	private String password;
	private String correo;
	private int estado;

	
	public String getNombreCompleto() {
		return nombres.concat(" ").concat(apellidos);
	}
}
