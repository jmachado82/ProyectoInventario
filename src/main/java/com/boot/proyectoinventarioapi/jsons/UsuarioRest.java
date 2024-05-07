package com.boot.proyectoinventarioapi.jsons;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioRest {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("idrol")
	private Long idrol;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("idtipdoc")
	private Long idtipdoc;
	
	@JsonProperty("usuario")
	private String usuario;
	
	@JsonProperty("pwd")
	private String pwd;
	
	@JsonProperty("direccion")
	private String direccion;
	
	@JsonProperty("documento")
	private String documento;

	



	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public Long getIdtipdoc() {
		return idtipdoc;
	}

	public void setIdtipdoc(Long idtipdoc) {
		this.idtipdoc = idtipdoc;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	
}
