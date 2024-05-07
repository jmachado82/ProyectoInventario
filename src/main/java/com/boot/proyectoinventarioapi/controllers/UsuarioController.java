package com.boot.proyectoinventarioapi.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.boot.proyectoinventarioapi.exceptions.ProyectoInventarioException;
import com.boot.proyectoinventarioapi.jsons.CreateUsuarioRest;
import com.boot.proyectoinventarioapi.jsons.UsuarioRest;
import com.boot.proyectoinventarioapi.responses.ProyectoInventarioResponse;
import com.boot.proyectoinventarioapi.services.UsuarioService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/proyecto-inventario" + "/v1")

public class UsuarioController {
	
	
	
	

	@Autowired
	UsuarioService usuarioService;



	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "usuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProyectoInventarioResponse<String> crearUsuario(@RequestBody @Valid CreateUsuarioRest createUsuarioRest)
			throws ProyectoInventarioException {
		return new ProyectoInventarioResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				usuarioService.crearUsuario(createUsuarioRest));
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{usuario}/{pwd}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProyectoInventarioResponse<UsuarioRest> getLogin(@PathVariable("usuario") String usuario,@PathVariable("pwd") String pwd) throws ProyectoInventarioException {
		return new ProyectoInventarioResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				usuarioService.getLogin(usuario,pwd));
	}
	

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "Usuarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProyectoInventarioResponse<List<UsuarioRest>> getUsuarios() throws ProyectoInventarioException {
		return new ProyectoInventarioResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", usuarioService.getUsuarios());
	}

}
