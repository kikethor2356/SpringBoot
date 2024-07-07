package com.example.Practicas.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Practicas.Models.UsuarioModel;
import com.example.Practicas.Repositories.UsuarioRepository;

@Service
public class UsuarioService {

		@Autowired
		UsuarioRepository usuarioRepository;
		
		public ArrayList<UsuarioModel> obtenerUsuarios() {
		    return (ArrayList<UsuarioModel>) usuarioRepository.findByEstatus(1);
		}
		
		public ArrayList<UsuarioModel> obtenerUsuariosEliminados() {
		    return (ArrayList<UsuarioModel>) usuarioRepository.findByEstatus(0);
		}

		
		public UsuarioModel guardarUsuario(UsuarioModel usuario) {
			return usuarioRepository.save(usuario);
		}
		
		public Optional<UsuarioModel> obtenerPorId(Long id){
			return usuarioRepository.findById(id);
		}
		
		public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
			return usuarioRepository.findByPrioridad(prioridad);
		}
		
		
		
		
		public boolean cambiarEstatusUsuario(Long id, int nuevoEstatus) {
		    try {
		        UsuarioModel usuario = usuarioRepository.findById(id).orElse(null);
		        if (usuario != null) {
		            usuario.setEstatus(nuevoEstatus);
		            usuarioRepository.save(usuario);
		            return true;
		        } else {
		            return false;
		        }
		    } catch (Exception e) {
		        return false;
		    }
		}

}
