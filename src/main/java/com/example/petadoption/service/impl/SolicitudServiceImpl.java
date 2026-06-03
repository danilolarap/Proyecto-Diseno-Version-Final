package com.example.petadoption.service.impl;

import com.example.petadoption.dto.SolicitudAdopcionDTO;
import com.example.petadoption.mapper.PetMapper;
import com.example.petadoption.model.Adoptante;
import com.example.petadoption.model.Mascota;
import com.example.petadoption.model.SolicitudAdopcion;
import com.example.petadoption.model.enums.EstadoMascota;
import com.example.petadoption.model.enums.EstadoSolicitud;
import com.example.petadoption.repository.AdoptanteRepository;
import com.example.petadoption.repository.MascotaRepository;
import com.example.petadoption.repository.SolicitudAdopcionRepository;
import com.example.petadoption.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudAdopcionRepository repository;
    private final MascotaRepository mascotaRepository;
    private final AdoptanteRepository adoptanteRepository;
    private final PetMapper mapper;

    @Override
    public SolicitudAdopcionDTO crear(SolicitudAdopcionDTO dto) {
        Mascota mascota = mascotaRepository.findById(dto.getMascotaId())
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        if (mascota.getEstado() != EstadoMascota.DISPONIBLE) {
            throw new RuntimeException("Solo se puede crear una solicitud para mascotas disponibles");
        }

        SolicitudAdopcion entity = mapper.toEntity(dto);
        entity.setFechaSolicitud(LocalDateTime.now());
        entity.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);
        
        // Cambiamos el estado de la mascota a EN_PROCESO al recibir una solicitud
        mascota.setEstado(EstadoMascota.EN_PROCESO);
        mascotaRepository.save(mascota);

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public SolicitudAdopcionDTO aprobar(String id) {
        SolicitudAdopcion solicitud = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        
        Mascota mascota = mascotaRepository.findById(solicitud.getMascotaId())
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        
        Adoptante adoptante = adoptanteRepository.findById(solicitud.getAdoptanteId())
                .orElseThrow(() -> new RuntimeException("Adoptante no encontrado"));

        solicitud.setEstadoSolicitud(EstadoSolicitud.APROBADA);
        mascota.setEstado(EstadoMascota.ADOPTADA);
        
        adoptante.getHistorialAdopciones().add(mascota.getNombre());

        mascotaRepository.save(mascota);
        adoptanteRepository.save(adoptante);
        return mapper.toDTO(repository.save(solicitud));
    }

    @Override
    public SolicitudAdopcionDTO rechazar(String id, String observaciones) {
        SolicitudAdopcion solicitud = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        
        Mascota mascota = mascotaRepository.findById(solicitud.getMascotaId())
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        solicitud.setEstadoSolicitud(EstadoSolicitud.RECHAZADA);
        solicitud.setObservaciones(observaciones);
        
        // Si no hay más solicitudes pendientes, la mascota vuelve a estar disponible
        // Por simplicidad en este ejercicio, la devolvemos a DISPONIBLE
        mascota.setEstado(EstadoMascota.DISPONIBLE);
        mascotaRepository.save(mascota);

        return mapper.toDTO(repository.save(solicitud));
    }

    @Override
    public SolicitudAdopcionDTO obtenerPorId(String id) {
        return repository.findById(id)
                .map(this::enrichDTO)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    @Override
    public List<SolicitudAdopcionDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::enrichDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitudAdopcionDTO> listarPorAdoptante(String adoptanteId) {
        return repository.findByAdoptanteId(adoptanteId).stream()
                .map(this::enrichDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitudAdopcionDTO> listarPorEstado(EstadoSolicitud estado) {
        return repository.findByEstadoSolicitud(estado).stream()
                .map(this::enrichDTO)
                .collect(Collectors.toList());
    }

    private SolicitudAdopcionDTO enrichDTO(SolicitudAdopcion entity) {
        SolicitudAdopcionDTO dto = mapper.toDTO(entity);
        mascotaRepository.findById(entity.getMascotaId())
                .ifPresent(m -> dto.setNombreMascota(m.getNombre()));
        adoptanteRepository.findById(entity.getAdoptanteId())
                .ifPresent(a -> dto.setNombreAdoptante(a.getNombre()));
        return dto;
    }
}
