package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/domicilios")
public class DomicilioController {
    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody Domicilio entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Domicilio entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(domicilioService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/localidades/{idDomicilio}")
    public Optional<Domicilio> agregarLocalidad (@RequestBody Localidad localidad, @PathVariable Long idDomicilio) throws Exception {
        Domicilio domicilio = domicilioService.agregarLocalidad(idDomicilio, localidad);
        return Optional.ofNullable(domicilio);
    }
    @PostMapping("/clientes/{idDomicilio}")
    public Optional<Domicilio> agregarClientes (@RequestBody Set<Cliente> clientes, @PathVariable Long idDomicilio) throws Exception {
        Domicilio domicilio = domicilioService.agregarClientes(idDomicilio, clientes);
        return Optional.ofNullable(domicilio);
    }
    @GetMapping("/localidades/{id}")
    public ResponseEntity<List<Domicilio>> listarPorLocalidad(@PathVariable Long id) throws Exception {
        List<Domicilio> listaDomicilios = domicilioService.listarPorLocalidad(id);
        return ResponseEntity.ok(listaDomicilios);
    }
    @GetMapping("/clientes/{id}")
    public ResponseEntity<List<Domicilio>> listarPorCliente(@PathVariable Long id) throws Exception {
        List<Domicilio> listaDomicilios = domicilioService.listarPorCliente(id);
        return ResponseEntity.ok(listaDomicilios);
    }
}
