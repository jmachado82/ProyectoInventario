package com.boot.proyectoinventarioapi.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.proyectoinventarioapi.entities.Usuario;
import com.boot.proyectoinventarioapi.exceptions.InternalServerErrorException;
import com.boot.proyectoinventarioapi.exceptions.NotFountException;
import com.boot.proyectoinventarioapi.exceptions.ProyectoInventarioException;
import com.boot.proyectoinventarioapi.jsons.CreateUsuarioRest;
import com.boot.proyectoinventarioapi.jsons.LoginCambioRest;
import com.boot.proyectoinventarioapi.jsons.LoginRest;
import com.boot.proyectoinventarioapi.jsons.UsuarioRest;
import com.boot.proyectoinventarioapi.repositories.UsuarioRepository;
import com.boot.proyectoinventarioapi.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	UsuarioRepository usuarioRepository;

	public static final ModelMapper modelMapper = new ModelMapper();


	
	



	public List<UsuarioRest> getUsuarios() throws ProyectoInventarioException {
		final List<Usuario> usuarioEntity = usuarioRepository.findAll();
		return usuarioEntity.stream().map(service -> modelMapper.map(service, UsuarioRest.class))
				.collect(Collectors.toList());
	}





	public UsuarioRest getLogin(String usuario, String pwd) throws ProyectoInventarioException {
		return modelMapper.map(getUsuarioEntity(usuario, pwd), UsuarioRest.class);

	}

	private Usuario getUsuarioEntity(String usuario,String pwd) throws ProyectoInventarioException {
		return usuarioRepository.findByUsuarioAndPwd(usuario, pwd)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
	

}



	public String crearUsuario(CreateUsuarioRest createUsuarioRest) throws ProyectoInventarioException {
		// TODO Auto-generated method stub
	

		String locator = createUsuarioRest.getUsuario();

		final Usuario usuario = new Usuario();
		usuario.setDireccion(createUsuarioRest.getDireccion());
		usuario.setDocumento(createUsuarioRest.getDocumento());
		
		usuario.setIdrol(createUsuarioRest.getIdrol());
		usuario.setIdtipdoc(createUsuarioRest.getIdtipdoc());
		usuario.setPwd(createUsuarioRest.getPwd());
		usuario.setUsuario(createUsuarioRest.getUsuario());

		try {
			usuarioRepository.save(usuario);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return locator;
	}



	
	public String modificarUsuario(CreateUsuarioRest createUsuarioRest) throws ProyectoInventarioException {
		final UsuarioRest objUsuario = getLogin(createUsuarioRest.getUsuario(), createUsuarioRest.getPwd());
		

		String locator = createUsuarioRest.getUsuario();

		final Usuario usuario = new Usuario();
		usuario.setDireccion(createUsuarioRest.getDireccion());
		usuario.setDocumento(createUsuarioRest.getDocumento());
		usuario.setId(objUsuario.getId());
		usuario.setIdrol(createUsuarioRest.getIdrol());
		usuario.setIdtipdoc(createUsuarioRest.getIdtipdoc());
		usuario.setPwd(objUsuario.getPwd());
		usuario.setUsuario(objUsuario.getUsuario());
		
		
		
		
		
		try {
			usuarioRepository.save(usuario);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return locator;
	}





	@Override
	public String cambioPwd(LoginCambioRest loginCambioRest) throws ProyectoInventarioException {
		final UsuarioRest usuarioLogin = getLogin(loginCambioRest.getUsuario(), loginCambioRest.getPwd());
		

		String locator = "El usuario "+loginCambioRest.getUsuario()+"cambio correctamente su contraseña";

		final Usuario objUsuario = new Usuario();
		objUsuario.setDireccion(usuarioLogin.getDireccion());
		objUsuario.setDocumento(usuarioLogin.getDocumento());
		objUsuario.setId(usuarioLogin.getId());
		objUsuario.setIdrol(usuarioLogin.getIdrol());
		objUsuario.setIdtipdoc(usuarioLogin.getIdtipdoc());
		objUsuario.setPwd(loginCambioRest.getPwdcambio());
		objUsuario.setUsuario(usuarioLogin.getUsuario());
		
		
		
		
		
		try {
			usuarioRepository.save(objUsuario);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return locator;
	}

	
	}
