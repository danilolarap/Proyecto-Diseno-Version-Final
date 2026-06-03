package com.example.petadoption.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Document(collection = "personas")
public class Adoptante extends Persona {
    private String direccion;
    private List<String> historialAdopciones = new ArrayList<>();

    public Adoptante(String id, String nombre, String correo, String telefono, String direccion) {
        super(id, nombre, correo, telefono);
        this.direccion = direccion;
    }
}
