package com.example.petadoption.dto;

import com.example.petadoption.model.enums.EstadoSolicitud;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SolicitudAdopcionDTO {
    private String id;
    private String mascotaId;
    private String adoptanteId;
    private LocalDateTime fechaSolicitud;
    private EstadoSolicitud estadoSolicitud;
    private String observaciones;
    // Campos adicionales para mostrar en UI
    private String nombreMascota;
    private String nombreAdoptante;
}
