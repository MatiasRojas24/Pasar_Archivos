package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody Sucursal entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Sucursal entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(sucursalService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(sucursalService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/nuevoDomicilio/{idSucursal}")
    public Optional<Sucursal> agregarDomicilio (@RequestBody Domicilio nuevoDomicilio, @PathVariable Long idSucursal) throws Exception {
        Sucursal sucursal = sucursalService.agregarDomicilio(idSucursal, nuevoDomicilio);
        return Optional.ofNullable(sucursal);
    }
    @PostMapping("/empresas/{idSucursal}")
    public Optional<Sucursal> agregarEmpresa (@RequestBody Empresa empresa, @PathVariable Long idSucursal) throws Exception {
        Sucursal sucursal = sucursalService.agregarEmperesa(idSucursal, empresa);
        return Optional.ofNullable(sucursal);
    }
    @PostMapping("/promociones/{idSucursal}")
    public Optional<Sucursal> agregarPromociones (@RequestBody Set<Promocion> promociones, @PathVariable Long idSucursal) throws Exception {
        Sucursal sucursal = sucursalService.agregarPromociones(idSucursal, promociones);
        return Optional.ofNullable(sucursal);
    }
    @PostMapping("/categorias/{idSucursal}")
    public Optional<Sucursal> agregarCategorias (@RequestBody Set<Categoria> categorias, @PathVariable Long idSucursal) throws Exception {
        Sucursal sucursal = sucursalService.agregarCategorias(idSucursal, categorias);
        return Optional.ofNullable(sucursal);
    }
    @GetMapping("/empresas/{id}")
    public ResponseEntity<List<Sucursal>> listarPorEmpresa(@PathVariable Long id) throws Exception {
        List<Sucursal> listaSucursales = sucursalService.listarPorEmpresa(id);
        return ResponseEntity.ok(listaSucursales);
    }
    @GetMapping("/promociones/{id}")
    public ResponseEntity<List<Sucursal>> ListarPorPromocion(@PathVariable Long id) throws Exception {
        List<Sucursal> listaSucursales = sucursalService.listarPorPromocion(id);
        return ResponseEntity.ok(listaSucursales);
    }
    @GetMapping("/nuevoDomicilio/{id}")
    public ResponseEntity<Sucursal> ListarPorDomicilio(@PathVariable Long id) throws Exception {
        Sucursal sucursal = sucursalService.listarPorDomicilio(id);
        return ResponseEntity.ok(sucursal);
    }
    @GetMapping("/categorias/{id}")
    public ResponseEntity<List<Sucursal>> ListarPorCategoria(@PathVariable Long id) throws Exception {
        List<Sucursal> listaSucursales = sucursalService.listarPorCategoria(id);
        return ResponseEntity.ok(listaSucursales);
    }
}
