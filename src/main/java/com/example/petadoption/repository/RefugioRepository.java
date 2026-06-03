package com.example.petadoption.repository;

import com.example.petadoption.model.Refugio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefugioRepository extends MongoRepository<Refugio, String> {
}
