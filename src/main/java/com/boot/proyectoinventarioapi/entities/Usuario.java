package com.boot.proyectoinventarioapi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "USUARIO")
	private String usuario;
	
	@Column(name = "PWD")
	private String pwd;
	
	@Column(name = "IDROL")
	private Long idrol;
	
	@Column(name = "IDTIPDOC")
	private Long idtipdoc;
	
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@Column(name = "DIRECCION")
	private String direccion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	
}
