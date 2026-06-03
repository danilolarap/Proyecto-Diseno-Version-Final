package com.example.petadoption.service.impl;

import com.example.petadoption.dto.MascotaDTO;
import com.example.petadoption.mapper.PetMapper;
import com.example.petadoption.model.Mascota;
import com.example.petadoption.model.enums.EstadoMascota;
import com.example.petadoption.repository.MascotaRepository;
import com.example.petadoption.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository repository;
    private final PetMapper mapper;

    @Override
    public MascotaDTO crear(MascotaDTO dto) {
        if (dto == null) throw new RuntimeException("Los datos de la mascota son nulos");
        
        Mascota entity = mapper.toEntity(dto);
        
        // Valores por defecto para evitar errores de BD
        if (entity.getEstado() == null) {
            entity.setEstado(EstadoMascota.DISPONIBLE);
        }
        if (entity.getRefugioId() == null || entity.getRefugioId().isEmpty()) {
            entity.setRefugioId("1");
        }
        
        Mascota guardada = repository.save(entity);
        return mapper.toDTO(guardada);
    }

    @Override
    public void eliminar(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<MascotaDTO> listarTodas() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MascotaDTO> listarPorEstado(EstadoMascota estado) {
        return repository.findByEstado(estado).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MascotaDTO obtenerPorId(String id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }

    @Override
    public MascotaDTO editar(String id, MascotaDTO dto) {
        Mascota existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        existente.setNombre(dto.getNombre());
        existente.setEspecie(dto.getEspecie());
        existente.setRaza(dto.getRaza());
        existente.setEdad(dto.getEdad());
        return mapper.toDTO(repository.save(existente));
    }
}
