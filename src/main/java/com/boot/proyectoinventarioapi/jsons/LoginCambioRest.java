package com.boot.proyectoinventarioapi.jsons;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginCambioRest {


	
	@JsonProperty("usuario")
	private String usuario;
	
	@JsonProperty("pwd")
	private String pwd;
	
	@JsonProperty("pwdcambio")
	private String pwdcambio;


	public String getPwdcambio() {
		return pwdcambio;
	}

	public void setPwdcambio(String pwdcambio) {
		this.pwdcambio = pwdcambio;
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

		
}
