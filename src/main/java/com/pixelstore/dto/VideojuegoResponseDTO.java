package com.pixelstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideojuegoResponseDTO {
    private Long id;
    private String titulo;
    private String consola;
    private double precio;
    private int stock;
}
