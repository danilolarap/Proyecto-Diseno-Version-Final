package com.example.petadoption.service.impl;

import com.example.petadoption.dto.RefugioDTO;
import com.example.petadoption.mapper.PetMapper;
import com.example.petadoption.model.Refugio;
import com.example.petadoption.repository.MascotaRepository;
import com.example.petadoption.repository.RefugioRepository;
import com.example.petadoption.service.RefugioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RefugioServiceImpl implements RefugioService {

    private final RefugioRepository repository;
    private final MascotaRepository mascotaRepository;
    private final PetMapper mapper;

    @Override
    public RefugioDTO crear(RefugioDTO dto) {
        Refugio entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public RefugioDTO editar(String id, RefugioDTO dto) {
        Refugio existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refugio no encontrado"));
        existente.setNombre(dto.getNombre());
        existente.setDireccion(dto.getDireccion());
        existente.setTelefono(dto.getTelefono());
        return mapper.toDTO(repository.save(existente));
    }

    @Override
    public void eliminar(String id) {
        if (!mascotaRepository.findByRefugioId(id).isEmpty()) {
            throw new RuntimeException("No se puede eliminar un refugio con mascotas asociadas");
        }
        repository.deleteById(id);
    }

    @Override
    public RefugioDTO obtenerPorId(String id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Refugio no encontrado"));
    }

    @Override
    public List<RefugioDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
