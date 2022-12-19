package com.h2.h2.servicio;

import com.h2.h2.modelo.Usuario;
import com.h2.h2.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository repo;

    @Override
    public Iterable<Usuario> encontrarUsuarios() {
        return repo.findAll();
    }

    @Override
    public Usuario encontrarUsarioPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> {throw new RuntimeException("El usuario con ese ID no existe");});
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public Usuario actualizarUsuarioPorId(Long id, Usuario usuario) {
        Usuario usuarioActualziado = encontrarUsarioPorId(id);

        usuarioActualziado.setNombre(usuario.getNombre());
        usuarioActualziado.setApellido(usuario.getApellido());
        usuarioActualziado.setDireccion(usuario.getDireccion());
        usuarioActualziado.setTelefono(usuario.getTelefono());

        return repo.save(usuarioActualziado);
    }

    @Override
    public void eliminarUsuarioPorId(Long id) {
        Usuario usuario = encontrarUsarioPorId(id);

        repo.delete(usuario);
    }
}
