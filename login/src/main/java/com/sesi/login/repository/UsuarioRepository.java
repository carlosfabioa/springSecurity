package com.sesi.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.login.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Usuario findbyNomeUsuario(String nomeUsuario);

}
