package com.example.petadoption.config;

import com.example.petadoption.model.Refugio;
import com.example.petadoption.repository.RefugioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final RefugioRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            Refugio unico = new Refugio("1", "Refugio Central", "Calle Principal 123", "555-0101");
            repository.save(unico);
            System.out.println(">> Refugio Central creado automáticamente.");
        }
    }
}
