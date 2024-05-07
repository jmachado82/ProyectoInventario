package com.boot.proyectoinventarioapi.services;

import java.util.Date;
import java.util.List;


import com.boot.proyectoinventarioapi.exceptions.ProyectoInventarioException;
import com.boot.proyectoinventarioapi.jsons.CreateUsuarioRest;
import com.boot.proyectoinventarioapi.jsons.UsuarioRest;

public interface UsuarioService {
	

	String crearUsuario(CreateUsuarioRest createUsuarioRest) throws ProyectoInventarioException;
	public List<UsuarioRest> getUsuarios() throws ProyectoInventarioException;
	public UsuarioRest getLogin(String usuario,String pwd) throws ProyectoInventarioException;

}
