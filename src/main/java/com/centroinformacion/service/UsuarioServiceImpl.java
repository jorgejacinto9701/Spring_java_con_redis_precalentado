package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Cacheable("usuarios")
	@Override
	public Usuario insertaUsuario(Usuario obj) {
		return repository.save(obj);
	}

	@Cacheable("usuarios")
	@Override
	public Usuario actualizaUsuario(Usuario obj) {
		return repository.save(obj);
	}

	@Override
	public List<Usuario> listaPorNombreApellidoLike(String filtro) {
		return repository.listaEmpleadoNombreApellidoLike(filtro);
	}

	@Override
	public Optional<Usuario> buscaUsuario(int idUsuario) {
		return repository.findById(idUsuario);
	}

	@Override
	public Usuario login(Usuario bean) {
		return repository.login(bean);
	}

	@Override
	public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
		return repository.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		return repository.traerRolesDeUsuario(idUsuario);
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public List<Usuario> listaUsuariosTodos() {
		return repository.findAll();
	}
}
