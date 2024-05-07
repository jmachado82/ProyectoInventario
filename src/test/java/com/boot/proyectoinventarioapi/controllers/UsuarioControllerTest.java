package com.boot.proyectoinventarioapi.controllers;





import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.proyectoinventarioapi.exceptions.ProyectoInventarioException;
import com.boot.proyectoinventarioapi.jsons.UsuarioRest;
import com.boot.proyectoinventarioapi.responses.ProyectoInventarioResponse;
import com.boot.proyectoinventarioapi.services.UsuarioService;







public class UsuarioControllerTest {
	
	private static final Long IDROL=1L;
	private static final String DIRECCION="ISMODES";

	private static final Long ID=1L;
	private static final String DOCUMENTO="41327698";
	private static final Long IDTIPDOC=1L;
	private static final String USUARIO="alex";
	private static final String PWD="alex";
	
	private static final String SUCCES_STATUS="Succes";
	private static final String SUCCES_CODE="200 OK";
	private static final String OK="OK";
	
	public  static final UsuarioRest USUARIO_REST=new UsuarioRest();
	
	

	
	@Mock
	UsuarioService usuarioService;
	@InjectMocks
	UsuarioController usuarioController;
	
	@Before
	public void init() throws ProyectoInventarioException{
		MockitoAnnotations.initMocks(this);
		
		
		
		USUARIO_REST.setDireccion(DIRECCION);
		USUARIO_REST.setDocumento(DOCUMENTO);
		
		USUARIO_REST.setIdrol(IDROL);
		USUARIO_REST.setIdtipdoc(IDTIPDOC);
		USUARIO_REST.setPwd(PWD);
		USUARIO_REST.setUsuario(USUARIO);
		
		
		Mockito.when(usuarioService.getLogin(USUARIO, PWD)).thenReturn(USUARIO_REST);
		
	}
	

	
	@Test
	public void getLoginTest() throws ProyectoInventarioException {
		final ProyectoInventarioResponse<UsuarioRest> response=usuarioController.getLogin(USUARIO, PWD);
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), USUARIO_REST);
		
	}
	
	
	
	
}
