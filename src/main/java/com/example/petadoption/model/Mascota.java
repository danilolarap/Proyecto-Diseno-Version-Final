package com.example.petadoption.model;

import com.example.petadoption.model.enums.EstadoMascota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "mascotas")
public class Mascota {
    @Id
    private String id;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private EstadoMascota estado;
    private String refugioId;
}
