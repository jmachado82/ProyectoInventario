package com.boot.proyectoinventarioapi.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.boot.proyectoinventarioapi.entities.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByUsuarioAndPwd(String usuario,String pwd);

}
