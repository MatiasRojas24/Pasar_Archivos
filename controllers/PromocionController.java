package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/promociones")
public class PromocionController {
    @Autowired
    private PromocionService promocionService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(promocionService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(promocionService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody Promocion entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(promocionService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Promocion entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(promocionService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(promocionService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/imagenesPromociones/{idPromocion}")
    public Optional<Promocion> agregarImagenesPromociones (@RequestBody Set<ImagenPromocion> imagenesPromociones, @PathVariable Long idPromocion) throws Exception {
        Promocion promocion = promocionService.agregarImagenesPromociones(idPromocion, imagenesPromociones);
        return Optional.ofNullable(promocion);
    }
    @GetMapping("/sucursales/{id}")
    public ResponseEntity<List<Promocion>> listarPorSucursal(@PathVariable Long id) throws Exception {
        List<Promocion> listaPromociones = promocionService.listarPorSucursal(id);
        return ResponseEntity.ok(listaPromociones);
    }
    @GetMapping("/imagenesPromociones/{id}")
    public ResponseEntity<Promocion> listarPorImagenPromocion(@PathVariable Long id) throws Exception {
        Promocion promocion = promocionService.listarPorImagenPromocion(id);
        return ResponseEntity.ok(promocion);
    }
}
