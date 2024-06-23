package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.ImagenPromocion;
import com.example.parcial_prog2_api.services.ImagenPromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/imagenes_promociones")
public class ImagenPromocionController {
    @Autowired
    private ImagenPromocionService imagenPromocionService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(imagenPromocionService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(imagenPromocionService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody ImagenPromocion entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(imagenPromocionService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody ImagenPromocion entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(imagenPromocionService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(imagenPromocionService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}
