package com.example.petadoption.dto;

import com.example.petadoption.model.enums.EstadoMascota;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MascotaDTO {
    private String id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "La especie es obligatoria")
    private String especie;
    private String raza; // Restaurado para compatibilidad con el Mapper
    @Min(value = 0, message = "La edad no puede ser negativa")
    private int edad;
    private EstadoMascota estado;
    private String refugioId;
}
