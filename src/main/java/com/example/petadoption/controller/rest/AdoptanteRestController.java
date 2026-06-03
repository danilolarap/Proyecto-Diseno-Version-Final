package com.example.petadoption.controller.rest;

import com.example.petadoption.dto.AdoptanteDTO;
import com.example.petadoption.service.AdoptanteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/adoptantes")
@RequiredArgsConstructor
public class AdoptanteRestController {

    private final AdoptanteService service;

    @PostMapping
    public ResponseEntity<AdoptanteDTO> crear(@Valid @RequestBody AdoptanteDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<AdoptanteDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptanteDTO> obtenerPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdoptanteDTO> editar(@PathVariable String id, @Valid @RequestBody AdoptanteDTO dto) {
        return ResponseEntity.ok(service.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
