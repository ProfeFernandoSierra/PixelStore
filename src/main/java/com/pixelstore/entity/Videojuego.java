package com.pixelstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Videojuego {
    private Long id;
    private String titulo;
    private String consola;
    private double precio;
    private int stock;
}
