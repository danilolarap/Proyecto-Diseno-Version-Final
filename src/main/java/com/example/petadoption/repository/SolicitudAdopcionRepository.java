package com.example.petadoption.repository;

import com.example.petadoption.model.SolicitudAdopcion;
import com.example.petadoption.model.enums.EstadoSolicitud;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SolicitudAdopcionRepository extends MongoRepository<SolicitudAdopcion, String> {
    List<SolicitudAdopcion> findByAdoptanteId(String adoptanteId);
    List<SolicitudAdopcion> findByEstadoSolicitud(EstadoSolicitud estado);
}
