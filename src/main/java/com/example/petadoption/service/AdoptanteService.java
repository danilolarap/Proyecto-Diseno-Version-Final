package com.example.petadoption.service;

import com.example.petadoption.dto.AdoptanteDTO;
import java.util.List;

public interface AdoptanteService {
    AdoptanteDTO crear(AdoptanteDTO dto);
    AdoptanteDTO editar(String id, AdoptanteDTO dto);
    void eliminar(String id);
    AdoptanteDTO obtenerPorId(String id);
    List<AdoptanteDTO> listarTodos();
}
