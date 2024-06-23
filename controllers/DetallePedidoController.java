package com.example.parcial_prog2_api.controllers;


import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/detalles_pedidos")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody DetallePedido entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody DetallePedido entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(detallePedidoService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/articulo/{idDetallePedido}")
    public Optional<DetallePedido> agregarArticulo(@RequestBody Articulo articulo, @PathVariable Long idDetallePedido) throws Exception{
        DetallePedido detallePedido = detallePedidoService.agregarArticulo(idDetallePedido, articulo);
        return Optional.of(detallePedido);
    }
    @PostMapping("/pedidos/{idDetallePedidlo}")
    public Optional<DetallePedido> agregarPedido(@RequestBody Pedido pedido, @PathVariable Long idDetallePedido) throws Exception{
        DetallePedido detallePedido = detallePedidoService.agregarPedido(idDetallePedido, pedido);
        return Optional.of(detallePedido);
    }
    @GetMapping("/pedidos/{id}")
    public ResponseEntity<List<DetallePedido>> listarPorPedido(@PathVariable Long id) throws Exception {
        List<DetallePedido> listaDetallesPedido = detallePedidoService.listarPorPedido(id);
        return ResponseEntity.ok(listaDetallesPedido);
    }
    @GetMapping("/articulo/{id}")
    public ResponseEntity<List<DetallePedido>> listarPorArticulo(@PathVariable Long id) throws Exception {
        List<DetallePedido> listaDetallesArticulo = detallePedidoService.listarPorArticulo(id);
        return ResponseEntity.ok(listaDetallesArticulo);
    }
}
