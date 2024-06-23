package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/clientes")
public class
ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Cliente entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cliente entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.actualizar(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clienteService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PostMapping("/usuarioCliente/{idCliente}")
    public Optional<Cliente> agregarUsuarioCliente(@RequestBody UsuarioCliente usuarioCliente, @PathVariable Long idCliente) throws Exception{
        Cliente cliente = clienteService.agregarUsuarioCliente(idCliente, usuarioCliente);
        return Optional.of(cliente);
    }

    @PostMapping("/imagenCliente/{idCliente}")
    public Optional<Cliente> agregarImagenCliente(@RequestBody ImagenCliente imagenCliente, @PathVariable Long idCliente) throws Exception{
        Cliente cliente = clienteService.agregarImagenCliente(idCliente, imagenCliente);
        return Optional.of(cliente);
    }
    @PostMapping("/domicilios/{idCliente}")
    public Optional<Cliente> agregarDomicilio(@RequestBody Set<Domicilio> domicilios, @PathVariable Long idCliente) throws Exception{
        Cliente cliente = clienteService.agregarDomicilio(idCliente, domicilios);
        return Optional.of(cliente);
    }

    @GetMapping("/usuarioCliente/{id}")
    public ResponseEntity<Cliente> listarPorUsuarioCliente(@PathVariable Long id) throws Exception {
        Cliente cliente = clienteService.listarPorUsuarioCliente(id);
        return ResponseEntity.ok(cliente);
    }
    @GetMapping("/imagenCliente/{id}")
    public ResponseEntity<Cliente> listarPorImagenCliente(@PathVariable Long id) throws Exception {
        Cliente cliente = clienteService.listarPorImagenCliente(id);
        return ResponseEntity.ok(cliente);
    }
    @GetMapping("/domicilios/{id}")
    public ResponseEntity<List<Cliente>> listarPorDomicilio(@PathVariable Long id) throws Exception {
        List<Cliente> listaClientes = clienteService.listarPorDomicilio(id);
        return ResponseEntity.ok(listaClientes);
    }
}
