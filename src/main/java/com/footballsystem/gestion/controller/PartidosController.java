package com.footballsystem.gestion.controller;

import com.footballsystem.gestion.service.PartidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PartidosController {

    @Autowired
    PartidosService partidosService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("partidosLista", partidosService.getAllPartidos());
        return "index";
    }

}
