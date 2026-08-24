package com.pixelstore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideojuegoRequestDTO {
    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    @NotBlank(message = "La consola no puede estar vacia")
    private String consola;
    @NotBlank(message = "el precio debe ser un valor positivo")
    private double precio;
    @NotBlank(message = "el stock debe ser un valor mayor a 0")
    private int stock;
}
