package com.example.petadoption.service;

import com.example.petadoption.dto.RefugioDTO;
import java.util.List;

public interface RefugioService {
    RefugioDTO crear(RefugioDTO dto);
    RefugioDTO editar(String id, RefugioDTO dto);
    void eliminar(String id);
    RefugioDTO obtenerPorId(String id);
    List<RefugioDTO> listarTodos();
}
