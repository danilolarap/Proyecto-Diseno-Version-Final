package com.example.petadoption.service;

import com.example.petadoption.dto.SolicitudAdopcionDTO;
import com.example.petadoption.model.enums.EstadoSolicitud;
import java.util.List;

public interface SolicitudService {
    SolicitudAdopcionDTO crear(SolicitudAdopcionDTO dto);
    SolicitudAdopcionDTO aprobar(String id);
    SolicitudAdopcionDTO rechazar(String id, String observaciones);
    SolicitudAdopcionDTO obtenerPorId(String id);
    List<SolicitudAdopcionDTO> listarTodas();
    List<SolicitudAdopcionDTO> listarPorAdoptante(String adoptanteId);
    List<SolicitudAdopcionDTO> listarPorEstado(EstadoSolicitud estado);
}
