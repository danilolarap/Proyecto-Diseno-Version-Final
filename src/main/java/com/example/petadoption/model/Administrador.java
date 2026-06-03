package com.example.petadoption.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Document(collection = "personas")
public class Administrador extends Persona {
    private String cargo;

    public Administrador(String id, String nombre, String correo, String telefono, String cargo) {
        super(id, nombre, correo, telefono);
        this.cargo = cargo;
    }
}
