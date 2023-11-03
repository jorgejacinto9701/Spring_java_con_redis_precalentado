package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;

public interface UsuarioService {

	//seguridad
	public abstract Usuario login(Usuario bean);
	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	public abstract Usuario buscaPorLogin(String login);
	
	//Crud
	public abstract Usuario insertaUsuario(Usuario obj);
	public abstract Usuario actualizaUsuario(Usuario obj);
	public abstract List<Usuario> listaPorNombreApellidoLike(String filtro);
	public abstract List<Usuario> listaUsuariosTodos();
	public abstract Optional<Usuario> buscaUsuario(int idUsuario);

}
