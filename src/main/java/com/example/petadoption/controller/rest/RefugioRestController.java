package com.example.petadoption.controller.rest;

import com.example.petadoption.dto.RefugioDTO;
import com.example.petadoption.service.RefugioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/refugios")
@RequiredArgsConstructor
public class RefugioRestController {

    private final RefugioService service;

    @PostMapping
    public ResponseEntity<RefugioDTO> crear(@Valid @RequestBody RefugioDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<RefugioDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefugioDTO> obtenerPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RefugioDTO> editar(@PathVariable String id, @Valid @RequestBody RefugioDTO dto) {
        return ResponseEntity.ok(service.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
