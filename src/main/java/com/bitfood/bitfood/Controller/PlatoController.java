package com.bitfood.bitfood.Controller;


import com.bitfood.bitfood.Model.Entities.Plato;
import com.bitfood.bitfood.Model.Entities.Restaurante;
import com.bitfood.bitfood.Service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Plato>> listarPlato(){
        return new ResponseEntity<List<Plato>>(platoService.listarPlato(), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Plato> listarPlatoPorId(@PathVariable (value = "id")Long platoId){
        return new ResponseEntity<Plato>(platoService.listarPlatoPorId(platoId),HttpStatus.OK);
    }

    @PostMapping("/insertar")
    private ResponseEntity<Plato> insertarPlato (@RequestBody Plato platoDetalle){
        return new ResponseEntity<Plato>(platoService.insertarPlato(platoDetalle), HttpStatus.CREATED);
    }

    @DeleteMapping ("/eliminar/{id}")
    private ResponseEntity<Plato> eliminarPlato (@PathVariable (value = "id")Long platoId){
        return new ResponseEntity<Plato>(platoService.eliminarPlato(platoId), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Plato> actualizarPlato (@PathVariable(value = "id") Long platoId, @RequestBody Plato plato){
        return new ResponseEntity<Plato>(platoService.actualizarPlato(platoId, plato),HttpStatus.OK);
    }
}
