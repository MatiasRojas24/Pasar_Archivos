package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.Categoria;
import com.example.parcial_prog2_api.entities.Promocion;
import com.example.parcial_prog2_api.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody Categoria entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Categoria entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoriaService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/subcategoria/{id_CP}")
    public Optional<Categoria> agregarSubcategoria(@PathVariable Long id_CP, @RequestBody Categoria subcategoria) throws Exception {
        Categoria categoriaPadre = categoriaService.agregarSubcategoria(id_CP, subcategoria);
        return Optional.ofNullable(categoriaPadre);
    }
    @GetMapping("/categriaPadre/{id}")
    public ResponseEntity<List<Categoria>> listarPorCategoriaPadre(@PathVariable Long id) throws Exception {
        List<Categoria> listaCategorias = categoriaService.listarPorCategoriaPadre(id);
        return ResponseEntity.ok(listaCategorias);
    }
    @GetMapping("/sucursales/{id}")
    public ResponseEntity<List<Categoria>> listarPorSucursal(@PathVariable Long id) throws Exception {
        List<Categoria> listaCategorias = categoriaService.listarPorSucursal(id);
        return ResponseEntity.ok(listaCategorias);
    }
}
