package com.luis.demonstracao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.demonstracao.models.Usuario;
import com.luis.demonstracao.repositories.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST Usuários")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	@ApiOperation(value = "Retorna uma lista de usuários")
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	@ApiOperation(value = "Retorna um único usuário")
	public Usuario getUsuario(@PathVariable(value = "id") long id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping("/usuarios")
	@ApiOperation(value = "Cria um usuário. OBS: Não coloque ID no Usuário")
	public Usuario criaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/usuarios")
	@ApiOperation(value = "Deleta um usuário")
	public void deletaUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	@PutMapping("/usuarios")
	@ApiOperation(value = "Atualiza informações do usuário")
	public Usuario alteraUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
}
