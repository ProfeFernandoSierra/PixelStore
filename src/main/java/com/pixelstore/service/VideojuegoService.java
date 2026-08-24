package com.pixelstore.service;

import com.pixelstore.entity.Videojuego;

import java.util.List;
import java.util.Optional;

public interface VideojuegoService {
    List<Videojuego> listarVideojuego();
    Optional<Videojuego> buscarPorId(Long id);
    Videojuego guardarVideojuego(Videojuego videojuego);
    Videojuego actualizarVideojuego(Long id, Videojuego videojuego);
    boolean eliminarVideojuego(Long id);
}
