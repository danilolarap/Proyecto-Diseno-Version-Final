package com.example.petadoption.controller.rest;

import com.example.petadoption.dto.MascotaDTO;
import com.example.petadoption.model.enums.EstadoMascota;
import com.example.petadoption.service.MascotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaRestController {

    private final MascotaService service;

    @PostMapping
    public ResponseEntity<MascotaDTO> crear(@Valid @RequestBody MascotaDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> listar(@RequestParam(required = false) EstadoMascota estado) {
        if (estado != null) {
            return ResponseEntity.ok(service.listarPorEstado(estado));
        }
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> obtenerPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaDTO> editar(@PathVariable String id, @Valid @RequestBody MascotaDTO dto) {
        return ResponseEntity.ok(service.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
