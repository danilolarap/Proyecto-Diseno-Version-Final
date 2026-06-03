package com.example.petadoption.service.impl;

import com.example.petadoption.dto.AdoptanteDTO;
import com.example.petadoption.mapper.PetMapper;
import com.example.petadoption.model.Adoptante;
import com.example.petadoption.repository.AdoptanteRepository;
import com.example.petadoption.service.AdoptanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdoptanteServiceImpl implements AdoptanteService {

    private final AdoptanteRepository repository;
    private final PetMapper mapper;

    @Override
    public AdoptanteDTO crear(AdoptanteDTO dto) {
        Adoptante entity = mapper.toEntity(dto);
        if (entity.getHistorialAdopciones() == null) {
            entity.setHistorialAdopciones(new ArrayList<>());
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public AdoptanteDTO editar(String id, AdoptanteDTO dto) {
        Adoptante existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoptante no encontrado"));
        existente.setNombre(dto.getNombre());
        existente.setCorreo(dto.getCorreo());
        existente.setTelefono(dto.getTelefono());
        existente.setDireccion(dto.getDireccion());
        return mapper.toDTO(repository.save(existente));
    }

    @Override
    public void eliminar(String id) {
        repository.deleteById(id);
    }

    @Override
    public AdoptanteDTO obtenerPorId(String id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Adoptante no encontrado"));
    }

    @Override
    public List<AdoptanteDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
