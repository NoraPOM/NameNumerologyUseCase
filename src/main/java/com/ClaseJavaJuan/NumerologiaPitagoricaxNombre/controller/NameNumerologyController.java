package com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.controller;

import com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.dto.NameNumerologyDto;
import com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.service.NameNumerologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//Capturar request y devolver un resultado por medio de un Json.

//Hay que decirle a Spring que es una clase de tipó Requste Controller y con el Mapping /xyz,
// Spring sabe que cuando le llegue una peticion por http, lo procesara con este controller.

@RestController
@RequestMapping( "/name-numerology" )
//localhost:8080/nameNumerology
//minusculas con rayita
//En postman con { es un objeto, si es solo un valor solo es una vble.

public class NameNumerologyController {
    @Autowired //Para que se pueda usar el servicio que creamos
    NameNumerologyService service; //Con esto ya llamamos al servicio
    // tambien se puede  NameNumerologyService service = new NameNumerlogyServiceImpl() pero toca instanciarlo.

    @PostMapping //Con esto Spring sabe que recibira un método POST: Actualizar  PUT: Crear -GET: Obtener - DELETE: Eliminar
    public ResponseEntity<String> calculate (@RequestBody String nameNumerology){
        //@RequestBody es para que Spring sepa que lo que enviamos en el Body del Postman es la vble name.
        //Se le denomina deserealizar: convertir string a objeto, de objetivo a string: serializar.
        if (nameNumerology.length() == 0){
            return ResponseEntity.internalServerError().body("No se recibio nombre, ingresar valor.");
        }
        return ResponseEntity.ok(nameNumerology); //como estandar hay que retornar respuesta, parte del estandar http, es 200 ok.
        //Manejo de respuestas http: 200 ok(), InternalServerError()
        //return ResponseEntity.internalServerError().body("Error ejm clase");
        //Se puede tener difererentes ResponseEntity, esto por medio de if o logica
    }
    @GetMapping
    //localhost:8080/name-numerology?name=Nora Patricia como @RequestParam
    public ResponseEntity<NameNumerologyDto> returnResult (@RequestParam String nameNumerology){
        NameNumerologyDto numerology = service.CalculateNumerologyNumber(nameNumerology);
        return ResponseEntity.ok(numerology);
         }
}

//Manejo de respuestas http: 200 ok(), InternalServerError()
/*

@RestController
@RequestMapping( "/name-numerology" )

//localhost:8080/nameNumerology
//minusculas con rayita
public class NameNumerologyController {
//private y constructor se reemplaza por @autowired y definición de vble service.
    private final NameNumerologyService servicio;

    public NameNumerologyController(@Autowired NameNumerologyService x) {
        this.servicio = x;
    }


    @PostMapping
    public ResponseEntity<NameNumerologyDto> solucion (@RequestBody String nameAstrology){
        return ResponseEntity.ok(servicio.CalculateNumerologyNumber(nameAstrology));
    }
}
 */