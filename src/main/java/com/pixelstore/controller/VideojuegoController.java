package com.pixelstore.controller;

import com.pixelstore.dto.VideojuegoRequestDTO;
import com.pixelstore.dto.VideojuegoResponseDTO;
import com.pixelstore.entity.Videojuego;
import com.pixelstore.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/v1/videojuegos")
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;
    private Videojuego mapToEntity(VideojuegoRequestDTO vdto){
        Videojuego videojuego = new Videojuego();
        videojuego.setTitulo(vdto.getTitulo());
        videojuego.setConsola(vdto.getConsola());
        videojuego.setPrecio(vdto.getPrecio());
        videojuego.setStock(vdto.getStock());
        return videojuego;
    }

    private VideojuegoResponseDTO mapToDTO(Videojuego videojuego){
        return new VideojuegoResponseDTO(
                videojuego.getId(),
                videojuego.getTitulo(),
                videojuego.getConsola(),
                videojuego.getPrecio(),
                videojuego.getStock()
        );
    }

    @GetMapping
    public List<VideojuegoResponseDTO> listar(){
        return videojuegoService.listarVideojuego()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideojuegoResponseDTO> buscarPorId(@PathVariable Long id){
        return videojuegoService.buscarPorId(id)
                .map(this::mapToDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



}
