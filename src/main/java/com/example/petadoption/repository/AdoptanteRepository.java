package com.example.petadoption.repository;

import com.example.petadoption.model.Adoptante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptanteRepository extends MongoRepository<Adoptante, String> {
}
