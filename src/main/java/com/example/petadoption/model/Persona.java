package com.example.petadoption.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private String telefono;
}
