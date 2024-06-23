package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.ArticuloInsumo;
import com.example.parcial_prog2_api.entities.ArticuloManufacturado;
import com.example.parcial_prog2_api.entities.ArticuloManufacturadoDetalle;
import com.example.parcial_prog2_api.services.ArticuloManufacturadoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articulos_manufacturados_detalles")
public class ArticuloManufacturadoDetalleController {
    @Autowired
    private ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoDetalleService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoDetalleService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody ArticuloManufacturadoDetalle entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoDetalleService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody ArticuloManufacturadoDetalle entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoDetalleService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(articuloManufacturadoDetalleService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/articulos_insumos/{idArticuloManufacturadoDetalle}")
    public Optional<ArticuloManufacturadoDetalle> agregarArticuloInsumo (@RequestBody ArticuloInsumo articuloInsumo, @PathVariable Long idArticuloManufacturadoDetalle) throws Exception {
        ArticuloManufacturadoDetalle articuloManufacturadoDetalle =articuloManufacturadoDetalleService.agregarArticuloInsumo(idArticuloManufacturadoDetalle, articuloInsumo);
        return Optional.ofNullable(articuloManufacturadoDetalle);
    }
    @PostMapping("/articulos_manufacturados/{idArticuloManufacturadoDetalle}")
    public Optional<ArticuloManufacturadoDetalle> agregarArticuloManufacturado (@RequestBody ArticuloManufacturado articuloManufacturado, @PathVariable Long idArticuloManufacturadoDetalle) throws Exception {
        ArticuloManufacturadoDetalle articuloManufacturadoDetalle =articuloManufacturadoDetalleService.agregarArticuloManufacturado(idArticuloManufacturadoDetalle, articuloManufacturado);
        return Optional.ofNullable(articuloManufacturadoDetalle);
    }
    @GetMapping("/articulos_insumos/{id}")
    public ResponseEntity<List<ArticuloManufacturadoDetalle>> listarPorArticuloInsumo(@PathVariable Long id) throws Exception {
        List<ArticuloManufacturadoDetalle> listaArticulosManufacturadosDetalles = articuloManufacturadoDetalleService.listarPorArticuloInsumo(id);
        return ResponseEntity.ok(listaArticulosManufacturadosDetalles);
    }
    @GetMapping("/articulo_manufacturado/{id}")
    public ResponseEntity<List<ArticuloManufacturadoDetalle>> listarPorArticulo(@PathVariable Long id) throws Exception {
        List<ArticuloManufacturadoDetalle> listaArticulosManufacturadosDetalles = articuloManufacturadoDetalleService.listarPorArticuloManufacturado(id);
        return ResponseEntity.ok(listaArticulosManufacturadosDetalles);
    }
}