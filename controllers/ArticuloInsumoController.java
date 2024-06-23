package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articulos_insumos")
public class ArticuloInsumoController {
    @Autowired
    private ArticuloInsumoService articuloInsumoService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloInsumoService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloInsumoService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody ArticuloInsumo entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloInsumoService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody ArticuloInsumo entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(articuloInsumoService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(articuloInsumoService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/imagenes_articulos/{idArticuloInsumo}")
    public Optional<ArticuloInsumo> agregarImagenArticulo(@RequestBody Set<ImagenArticulo> imagenArticulo, @PathVariable Long idArticuloInsumo) throws Exception{
        ArticuloInsumo articuloInsumo = articuloInsumoService.agregarImagenArticulo(idArticuloInsumo, imagenArticulo);
        return Optional.of(articuloInsumo);
    }
    @PostMapping("/unidades_medidas/{idArticuloInsumo}")
    public Optional<ArticuloInsumo> agregarUnidadMedida(@RequestBody UnidadMedida unidadMedida, @PathVariable Long idArticuloInsumo) throws Exception{
        ArticuloInsumo articuloInsumo = articuloInsumoService.agregarUnidadMedida(idArticuloInsumo, unidadMedida);
        return Optional.of(articuloInsumo);
    }
    @PostMapping("/categorias/{idArticuloInsumo}")
    public Optional<ArticuloInsumo> agregarCategoria(@RequestBody Categoria categoria, @PathVariable Long idArticuloInsumo) throws Exception{
        ArticuloInsumo articuloInsumo = articuloInsumoService.agregarCategoria(idArticuloInsumo, categoria);
        return Optional.of(articuloInsumo);
    }
    @GetMapping("/categorias/{id}")
    public ResponseEntity<List<ArticuloInsumo>> listarPorCategoria(@PathVariable Long id) throws Exception {
        List<ArticuloInsumo> listaArticulosInsumo = articuloInsumoService.listarPorCategoria(id);
        return ResponseEntity.ok(listaArticulosInsumo);
    }
    @GetMapping("/unidades_medidas/{id}")
    public ResponseEntity<List<ArticuloInsumo>> listarPorUnidadMedida(@PathVariable Long id) throws Exception {
        List<ArticuloInsumo> listaArticulosInsumo = articuloInsumoService.listarPorUnidadMedida(id);
        return ResponseEntity.ok(listaArticulosInsumo);
    }
    @GetMapping("/imagenes_articulos/{id}")
    public ResponseEntity<ArticuloInsumo> listarPorImagenArticulo(@PathVariable Long id) throws Exception {
        ArticuloInsumo articuloInsumo = articuloInsumoService.listarPorImagenArticulo(id);
        return ResponseEntity.ok(articuloInsumo);
    }
}
