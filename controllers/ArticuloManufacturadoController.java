package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.ArticuloManufacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articulos_manufacturados")
public class ArticuloManufacturadoController {
    @Autowired
    private ArticuloManufacturadoService articuloManufacturadoService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody ArticuloManufacturado entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody ArticuloManufacturado entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(articuloManufacturadoService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/imagenes_articulos/{idArticuloInsumo}")
    public Optional<ArticuloManufacturado> agregarImagenArticulo(@RequestBody Set<ImagenArticulo> imagenArticulo, @PathVariable Long idArticuloManufacturado) throws Exception{
        ArticuloManufacturado articuloManufacturado = articuloManufacturadoService.agregarImagenArticulo(idArticuloManufacturado, imagenArticulo);
        return Optional.of(articuloManufacturado);
    }
    @PostMapping("/unidades_medidas/{idArticuloInsumo}")
    public Optional<ArticuloManufacturado> agregarUnidadMedida(@RequestBody UnidadMedida unidadMedida, @PathVariable Long idArticuloManufacturado) throws Exception{
        ArticuloManufacturado articuloManufacturado = articuloManufacturadoService.agregarUnidadMedida(idArticuloManufacturado, unidadMedida);
        return Optional.of(articuloManufacturado);
    }
    @PostMapping("/categorias/{idArticuloInsumo}")
    public Optional<ArticuloManufacturado> agregarCategoria(@RequestBody Categoria categoria, @PathVariable Long idArticuloManufacturado) throws Exception{
        ArticuloManufacturado articuloManufacturado = articuloManufacturadoService.agregarCategoria(idArticuloManufacturado, categoria);
        return Optional.of(articuloManufacturado);
    }
    @GetMapping("/categorias/{id}")
    public ResponseEntity<List<ArticuloManufacturado>> listarPorCategoria(@PathVariable Long id) throws Exception {
        List<ArticuloManufacturado> listaArticulosManufacturados = articuloManufacturadoService.listarPorCategoria(id);
        return ResponseEntity.ok(listaArticulosManufacturados);
    }
    @GetMapping("/unidades_medidas/{id}")
    public ResponseEntity<List<ArticuloManufacturado>> listarPorUnidadMedida(@PathVariable Long id) throws Exception {
        List<ArticuloManufacturado> listaArticulosManufacturados = articuloManufacturadoService.listarPorUnidadMedida(id);
        return ResponseEntity.ok(listaArticulosManufacturados);
    }
    @GetMapping("/imagenes_articulos/{id}")
    public ResponseEntity<ArticuloManufacturado> listarPorImagenArticulo(@PathVariable Long id) throws Exception {
        ArticuloManufacturado articuloManufacturado = articuloManufacturadoService.listarPorImagenArticulo(id);
        return ResponseEntity.ok(articuloManufacturado);
    }
}
