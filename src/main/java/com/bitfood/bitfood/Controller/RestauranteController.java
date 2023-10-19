package com.bitfood.bitfood.Controller;


import com.bitfood.bitfood.Model.Dtos.RestauranteDto;
import com.bitfood.bitfood.Model.Entities.Restaurante;
import com.bitfood.bitfood.Service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarRestaurantes(){
        return new ResponseEntity<List<Restaurante>>(restauranteService.listarRestaurantes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> listarRestaurantePorId(@PathVariable (value = "id")Long restauranteId){
        return new ResponseEntity<Restaurante>(restauranteService.listarRestaurantePorId(restauranteId),HttpStatus.OK);
    }

    @PostMapping("/insertar")
    public ResponseEntity<Restaurante> insertarRestaurante(@RequestBody RestauranteDto restauranteDetalles){
        return new ResponseEntity<Restaurante>(restauranteService.insertarRestaurante(restauranteDetalles),HttpStatus.CREATED);
    }
    @PutMapping ("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarRestaurante (@PathVariable(value = "id") Long restauranteId, @RequestBody Restaurante restaurante){
        return new ResponseEntity<Restaurante>(restauranteService.actualizarRestaurante(restauranteId, restaurante),HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminarRestaurante (@PathVariable(value = "id") Long restauranteId){
        return new ResponseEntity<Restaurante>(restauranteService.eliminarRestaurante(restauranteId),HttpStatus.OK);
    }
}
