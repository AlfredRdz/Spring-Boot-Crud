package com.darkzy.inventario.Service;

import com.darkzy.inventario.Model.Usuario;
import com.darkzy.inventario.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioById(Integer id_usuario) {
        Optional<Usuario> optional = usuarioRepository.findById(id_usuario);
        Usuario usuario = null;
        if (optional.isPresent()) {
            usuario = optional.get();
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
        return usuario;
    }

    public void eliminarUsuario(Integer id_usuario) {
        usuarioRepository.deleteById(id_usuario);
    }
}
