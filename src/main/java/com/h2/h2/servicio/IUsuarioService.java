package com.h2.h2.servicio;

import com.h2.h2.modelo.Usuario;

public interface IUsuarioService {
    Iterable<Usuario> encontrarUsuarios();
    Usuario encontrarUsarioPorId(Long id);
    Usuario guardarUsuario(Usuario usuario);

    Usuario actualizarUsuarioPorId(Long id, Usuario usuario);
    void eliminarUsuarioPorId(Long id);
}
