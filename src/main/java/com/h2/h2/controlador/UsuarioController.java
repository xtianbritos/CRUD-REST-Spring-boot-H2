package com.h2.h2.controlador;

import com.h2.h2.modelo.Usuario;
import com.h2.h2.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios")
    public Iterable<Usuario> read() {
        return service.encontrarUsuarios();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/{id}")
    public Usuario readById(@PathVariable Long id) {
        return service.encontrarUsarioPorId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/usuarios")
    public Usuario create(@RequestBody Usuario usuario) {
        return service.guardarUsuario(usuario);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/usuarios/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.actualizarUsuarioPorId(id, usuario);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/usuarios/{id}")
    public void deleteById(@PathVariable Long id) {
        service.eliminarUsuarioPorId(id);
    }
}
