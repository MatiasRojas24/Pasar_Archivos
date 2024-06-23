package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Empleado entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Empleado entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empleadoService.actualizar(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(empleadoService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PostMapping("/usuarioEmpleado/{idEmpleado}")
    public Optional<Empleado> agregarUsuarioEmpleado(@RequestBody UsuarioEmpleado usuarioEmpleado, @PathVariable Long idEmpleado) throws Exception{
        Empleado empleado = empleadoService.agragarUsuarioEmpleado(idEmpleado, usuarioEmpleado);
        return Optional.of(empleado);
    }

    @PostMapping("/imagenEmpleado/{idEmpleado}")
    public Optional<Empleado> agregarImagenEmpleado(@RequestBody ImagenEmpleado imagenEmpleado, @PathVariable Long idEmpleado) throws Exception{
        Empleado empleado = empleadoService.agregarImagenEmpleado(idEmpleado, imagenEmpleado);
        return Optional.of(empleado);
    }

    @PostMapping("/sucursales/{idEmpleado}")
    public Optional<Empleado> agregarSucursal(@RequestBody Sucursal sucursal, @PathVariable Long idEmpleado) throws Exception{
        Empleado empleado = empleadoService.agregarSucursal(idEmpleado, sucursal);
        return Optional.of(empleado);
    }
    @GetMapping("/usuarioEmpleado/{id}")
    public ResponseEntity<Empleado> listarPorUsuarioEmpleado(@PathVariable Long id) throws Exception {
        Empleado empleado = empleadoService.listarPorUsuarioEmpleado(id);
        return ResponseEntity.ok(empleado);
    }
    @GetMapping("/imagenEmpleado/{id}")
    public ResponseEntity<Empleado> listarPorImagenEmpleado(@PathVariable Long id) throws Exception {
        Empleado empleado = empleadoService.listarPorImagenEmpleado(id);
        return ResponseEntity.ok(empleado);
    }
    @GetMapping("/sucursales/{id}")
    public ResponseEntity<List<Empleado>> ListarPorSucursal(@PathVariable Long id) throws Exception {
        List<Empleado> listaEmpleados = empleadoService.listarPorSucursal(id);
        return ResponseEntity.ok(listaEmpleados);
    }
}