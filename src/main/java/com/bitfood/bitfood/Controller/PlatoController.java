package com.bitfood.bitfood.Controller;


import com.bitfood.bitfood.Model.Entities.Plato;
import com.bitfood.bitfood.Service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping ("/listar/{id}")
    private ResponseEntity<Plato> listarPlatos (@PathVariable (value = "id")Long platoId){
        return new ResponseEntity<Plato>(platoService.listarPlatos(platoId), HttpStatus.OK);
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
