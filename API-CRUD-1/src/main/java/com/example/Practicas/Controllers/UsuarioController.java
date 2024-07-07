package com.example.Practicas.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practicas.Models.UsuarioModel;
import com.example.Practicas.Services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuarios();
}
	
	@GetMapping("/eliminado")
	public ArrayList<UsuarioModel> obtenerUsuariosEliminados(){
		return usuarioService.obtenerUsuariosEliminados();
}
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);
	}
	
	@GetMapping( path = "/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.usuarioService.obtenerPorId(id);
				
	}
	
	@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioService.obtenerPorPrioridad(prioridad);
	}
	
	
	@PutMapping(path = "/{id}")
	public String cambiarEstatusUsuario(@PathVariable("id") Long id) {
	    boolean ok = this.usuarioService.cambiarEstatusUsuario(id, 0);
	    if (ok) {
	        return "Se elimino el usuario con id " + id;
	    } else {
	        return "No se logró cambiar eliminar el usuario con id " + id;
	    }
	}

		
}
	
	


