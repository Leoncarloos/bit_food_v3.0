package com.bitfood.bitfood.Controller;

import com.bitfood.bitfood.Model.Entities.Cliente;
import com.bitfood.bitfood.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarCliente(){
        return new ResponseEntity<List<Cliente>>(clienteService.listarCliente(), HttpStatus.OK);
    }
    @GetMapping("/buscar/{contrasena}")
    public ResponseEntity<Cliente> buscarClientePorContrasena(@PathVariable (value="contrasena")String clienteContrasena){
        return new ResponseEntity<Cliente>(clienteService.buscarClientePorContrasena(clienteContrasena),HttpStatus.OK);
    }

    @PostMapping("/insertar")
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<Cliente>(clienteService.insertarCliente(cliente),HttpStatus.CREATED);
    }
    @PutMapping ("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarCliente (@PathVariable(value = "id") Long clienteId, @RequestBody Cliente cliente){
        return new ResponseEntity<Cliente>(clienteService.actualizarCliente(clienteId, cliente),HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cliente> eliminarCliente (@PathVariable(value = "id") Long clienteId){
        return new ResponseEntity<Cliente>(clienteService.eliminarCliente(clienteId),HttpStatus.OK);
    }
}
