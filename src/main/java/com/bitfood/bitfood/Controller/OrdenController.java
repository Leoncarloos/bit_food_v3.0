package com.bitfood.bitfood.Controller;


import com.bitfood.bitfood.Model.Dtos.OrdenDto;
import com.bitfood.bitfood.Model.Entities.Orden;
import com.bitfood.bitfood.Service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orden")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;
    @GetMapping("/listar")
    public ResponseEntity<List<Orden>> listarOrdenes(){
        return new ResponseEntity<List<Orden>>(ordenService.listarOrdenes(), HttpStatus.OK);
    }
    @GetMapping ("/buscar/{clienteId}")
    public ResponseEntity<List<Orden>> buscarOrdenPorCliente(@PathVariable (value = "clienteId") Long clienteId){
        return new ResponseEntity<List<Orden>>(ordenService.buscarOrdenPorCliente(clienteId),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Orden> buscarOrdenPorId(@PathVariable(value = "id")Long ordenId){
        return new ResponseEntity<Orden>(ordenService.buscarOrdenPorId(ordenId),HttpStatus.OK);
    }

    @PostMapping("/insertar")
    public ResponseEntity<Orden> insertarOrden(@RequestBody OrdenDto ordenDetalles){
        return new ResponseEntity<Orden>(ordenService.insertarOrden(ordenDetalles),HttpStatus.CREATED);
    }
    /*@PutMapping("/Actualizar/{id}")
    public ResponseEntity<Orden> actualizarOrden (@PathVariable(value = "id") Long ordenId, @RequestBody Orden orden){
        return new ResponseEntity<Orden>(ordenService.actualizarOrden(ordenId, orden),HttpStatus.OK);
    }*/
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Orden> eliminarOrden (@PathVariable(value = "id") Long ordenId){
        return new ResponseEntity<Orden>(ordenService.eliminarOrden(ordenId),HttpStatus.OK);
    }
}
