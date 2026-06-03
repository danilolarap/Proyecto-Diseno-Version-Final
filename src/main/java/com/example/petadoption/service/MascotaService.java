package com.example.petadoption.service;

import com.example.petadoption.dto.MascotaDTO;
import com.example.petadoption.model.enums.EstadoMascota;
import java.util.List;

public interface MascotaService {
    MascotaDTO crear(MascotaDTO dto);
    MascotaDTO editar(String id, MascotaDTO dto);
    void eliminar(String id);
    MascotaDTO obtenerPorId(String id);
    List<MascotaDTO> listarTodas();
    List<MascotaDTO> listarPorEstado(EstadoMascota estado);
}
