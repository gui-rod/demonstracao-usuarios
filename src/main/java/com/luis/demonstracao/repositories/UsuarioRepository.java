package com.luis.demonstracao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.demonstracao.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findById(long id);
	
}
