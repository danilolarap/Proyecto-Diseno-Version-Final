package com.example.petadoption.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RefugioDTO {
    private String id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    private String direccion;
    private String telefono;
}
