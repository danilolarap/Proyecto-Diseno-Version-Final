package com.example.petadoption.controller.rest;

import com.example.petadoption.dto.SolicitudAdopcionDTO;
import com.example.petadoption.model.enums.EstadoSolicitud;
import com.example.petadoption.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
public class SolicitudRestController {

    private final SolicitudService service;

    @PostMapping
    public ResponseEntity<SolicitudAdopcionDTO> crear(@RequestBody SolicitudAdopcionDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<SolicitudAdopcionDTO>> listar(@RequestParam(required = false) EstadoSolicitud estado) {
        if (estado != null) {
            return ResponseEntity.ok(service.listarPorEstado(estado));
        }
        return ResponseEntity.ok(service.listarTodas());
    }

    @PatchMapping("/{id}/aprobar")
    public ResponseEntity<SolicitudAdopcionDTO> aprobar(@PathVariable String id) {
        return ResponseEntity.ok(service.aprobar(id));
    }

    @PatchMapping("/{id}/rechazar")
    public ResponseEntity<SolicitudAdopcionDTO> rechazar(@PathVariable String id, @RequestParam String observaciones) {
        return ResponseEntity.ok(service.rechazar(id, observaciones));
    }
}
