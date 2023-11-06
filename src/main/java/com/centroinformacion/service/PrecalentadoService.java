package com.centroinformacion.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;
import com.google.gson.Gson;

import jakarta.annotation.PostConstruct;
import redis.clients.jedis.Jedis;


@Service
public class PrecalentadoService {

	@Autowired
	private UsuarioService servicio;
	

	@PostConstruct
	public void cargarCache() {	
		Jedis jedis = new Jedis();
		Gson gson = new Gson();
		
		//---------------------------------------------
		//CACHE ==> PRECALENTADO
		//---------------------------------------------
		//Carga al  cache de usuarios, roles y opciones
		
		List<Usuario> lstUsuarios = servicio.listaUsuariosTodos() ;
		Map<String, String> mapsUsuarios = new HashMap<>();
		for (Usuario usuario : lstUsuarios) {
			mapsUsuarios.put(usuario.getLogin(), gson.toJson(usuario));
		}
		jedis.hset("usuarios", mapsUsuarios);
		
		//Roles
		Map<String, String> mapsRoles = new HashMap<>();
		for (Usuario usuario : lstUsuarios) {
			List<Rol> roles = servicio.traerRolesDeUsuario(usuario.getIdUsuario());
			mapsRoles.put(usuario.getLogin(), gson.toJson(roles));
		}
		jedis.hset("roles", mapsRoles);

		//Opciones
		Map<String, String> mapsMenus = new HashMap<>();
		for (Usuario usuario : lstUsuarios) {
			List<Opcion> menus = servicio.traerEnlacesDeUsuario(usuario.getIdUsuario());
			mapsMenus.put(usuario.getLogin(), gson.toJson(menus));
		}
		jedis.hset("menus", mapsMenus);
		jedis.close();
		
	}
	

}
