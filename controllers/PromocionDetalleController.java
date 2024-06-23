package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.PromocionDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/detalles_promociones")
public class PromocionDetalleController {
    @Autowired
    private PromocionDetalleService promocionDetalleService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(promocionDetalleService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(promocionDetalleService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody PromocionDetalle entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(promocionDetalleService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody PromocionDetalle entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(promocionDetalleService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(promocionDetalleService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/articulo/{idPromocionDetalle}")
    public Optional<PromocionDetalle> agregarArticulo (@RequestBody Articulo articulo, @PathVariable Long idPromocionDetalle) throws Exception {
        PromocionDetalle promocionDetalle = promocionDetalleService.agregarArticulo(idPromocionDetalle, articulo);
        return Optional.ofNullable(promocionDetalle);
    }
    @PostMapping("/promociones/{idPromocionDetalle}")
    public Optional<PromocionDetalle> agregarPromocion (@RequestBody Promocion promocion, @PathVariable Long idPromocionDetalle) throws Exception {
        PromocionDetalle promocionDetalle = promocionDetalleService.agregarPromocion(idPromocionDetalle, promocion);
        return Optional.ofNullable(promocionDetalle);
    }
    @GetMapping("/promociones/{id}")
    public ResponseEntity<List<PromocionDetalle>> listarPorPromocion(@PathVariable Long id) throws Exception {
        List<PromocionDetalle> listaDetallesPromocion = promocionDetalleService.listarPorPromocion(id);
        return ResponseEntity.ok(listaDetallesPromocion);
    }
    @GetMapping("/articulo/{id}")
    public ResponseEntity<List<PromocionDetalle>> listarPorArticulo(@PathVariable Long id) throws Exception {
        List<PromocionDetalle> listaDetallesPromocion = promocionDetalleService.listarPorArticulo(id);
        return ResponseEntity.ok(listaDetallesPromocion);
    }
}