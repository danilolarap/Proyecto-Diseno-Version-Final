package com.example.petadoption.model;

import com.example.petadoption.model.enums.EstadoSolicitud;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "solicitudes")
public class SolicitudAdopcion {
    @Id
    private String id;
    private String mascotaId;
    private String adoptanteId;
    private LocalDateTime fechaSolicitud;
    private EstadoSolicitud estadoSolicitud;
    private String observaciones;
}
