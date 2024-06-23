package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/localidades")
public class LocalidadController {

    @Autowired
    private LocalidadService localidadService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody Localidad entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Localidad entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(localidadService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/provincias/{idLocalidad}")
    public Optional<Localidad> agregarProvincia (@RequestBody Provincia provincia, @PathVariable Long idLocalidad) throws Exception {
        Localidad localidad = localidadService.agregarProvincia(idLocalidad, provincia);
        return Optional.ofNullable(localidad);
    }
    @GetMapping("/provincias/{id}")
    public ResponseEntity<List<Localidad>> listarPorProvincia(@PathVariable Long id) throws Exception {
        List<Localidad> listaLocalidades = localidadService.listarPorProvincia(id);
        return ResponseEntity.ok(listaLocalidades);
    }
}
