package com.example.petadoption.repository;

import com.example.petadoption.model.Mascota;
import com.example.petadoption.model.enums.EstadoMascota;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MascotaRepository extends MongoRepository<Mascota, String> {
    List<Mascota> findByEstado(EstadoMascota estado);
    List<Mascota> findByRefugioId(String refugioId);
}
