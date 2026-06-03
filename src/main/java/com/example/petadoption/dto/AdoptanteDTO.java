package com.example.petadoption.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Data
public class AdoptanteDTO {
    private String id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @Email(message = "El correo debe ser válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;
    private String telefono;
    private String direccion;
    private List<String> historialAdopciones;
}
