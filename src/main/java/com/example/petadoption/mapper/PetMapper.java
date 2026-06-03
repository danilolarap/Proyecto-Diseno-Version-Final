package com.example.petadoption.mapper;

import com.example.petadoption.dto.*;
import com.example.petadoption.model.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class PetMapper {

    public MascotaDTO toDTO(Mascota entity) {
        if (entity == null) return null;
        MascotaDTO dto = new MascotaDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setEspecie(entity.getEspecie());
        dto.setRaza(entity.getRaza());
        dto.setEdad(entity.getEdad());
        dto.setEstado(entity.getEstado());
        dto.setRefugioId(entity.getRefugioId());
        return dto;
    }

    public Mascota toEntity(MascotaDTO dto) {
        if (dto == null) return null;
        Mascota entity = new Mascota();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setEspecie(dto.getEspecie());
        entity.setRaza(dto.getRaza());
        entity.setEdad(dto.getEdad());
        entity.setEstado(dto.getEstado());
        entity.setRefugioId(dto.getRefugioId() != null ? dto.getRefugioId() : "1");
        return entity;
    }

    public AdoptanteDTO toDTO(Adoptante entity) {
        if (entity == null) return null;
        AdoptanteDTO dto = new AdoptanteDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        dto.setTelefono(entity.getTelefono());
        dto.setDireccion(entity.getDireccion());
        dto.setHistorialAdopciones(entity.getHistorialAdopciones() != null ? entity.getHistorialAdopciones() : new ArrayList<>());
        return dto;
    }

    public Adoptante toEntity(AdoptanteDTO dto) {
        if (dto == null) return null;
        Adoptante entity = new Adoptante();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        entity.setDireccion(dto.getDireccion());
        entity.setHistorialAdopciones(new ArrayList<>());
        return entity;
    }

    public SolicitudAdopcionDTO toDTO(SolicitudAdopcion entity) {
        if (entity == null) return null;
        SolicitudAdopcionDTO dto = new SolicitudAdopcionDTO();
        dto.setId(entity.getId());
        dto.setMascotaId(entity.getMascotaId());
        dto.setAdoptanteId(entity.getAdoptanteId());
        dto.setFechaSolicitud(entity.getFechaSolicitud());
        dto.setEstadoSolicitud(entity.getEstadoSolicitud());
        dto.setObservaciones(entity.getObservaciones());
        return dto;
    }

    public SolicitudAdopcion toEntity(SolicitudAdopcionDTO dto) {
        if (dto == null) return null;
        SolicitudAdopcion entity = new SolicitudAdopcion();
        entity.setId(dto.getId());
        entity.setMascotaId(dto.getMascotaId());
        entity.setAdoptanteId(dto.getAdoptanteId());
        entity.setFechaSolicitud(dto.getFechaSolicitud());
        entity.setEstadoSolicitud(dto.getEstadoSolicitud());
        entity.setObservaciones(dto.getObservaciones());
        return entity;
    }

    public RefugioDTO toDTO(Refugio entity) {
        if (entity == null) return null;
        RefugioDTO dto = new RefugioDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDireccion(entity.getDireccion());
        dto.setTelefono(entity.getTelefono());
        return dto;
    }

    public Refugio toEntity(RefugioDTO dto) {
        if (dto == null) return null;
        Refugio entity = new Refugio();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }
}
