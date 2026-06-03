package com.example.petadoption.controller.mvc;

import com.example.petadoption.service.AdoptanteService;
import com.example.petadoption.service.MascotaService;
import com.example.petadoption.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AppViewController {
    private final MascotaService mascotaService;
    private final AdoptanteService adoptanteService;
    private final SolicitudService solicitudService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mascotas", mascotaService.listarTodas());
        model.addAttribute("adoptantes", adoptanteService.listarTodos());
        model.addAttribute("solicitudes", solicitudService.listarTodas());
        return "index";
    }
}
