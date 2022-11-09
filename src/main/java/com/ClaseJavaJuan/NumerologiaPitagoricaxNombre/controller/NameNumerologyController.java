package com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.controller;

import com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.dto.NameNumerologyDto;
import com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.service.NameNumerologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/nameNumerology" )
public class NameNumerologyController {
    private final NameNumerologyService servicio;

    public NameNumerologyController(@Autowired NameNumerologyService x) {
        this.servicio = x;
    }
    @PostMapping
    public ResponseEntity<NameNumerologyDto> solucion (@RequestBody String nameAstrology){
        return ResponseEntity.ok(servicio.CalculateNumerologyNumber(nameAstrology));
    }
}
