package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pedidoService.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pedidoService.buscarPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody Pedido entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pedidoService.crear(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Pedido entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pedidoService.actualizar(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pedidoService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error:\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @PostMapping("/clientes/{idPedido}")
    public Optional<Pedido> agregarCliente(@RequestBody Cliente cliente, @PathVariable Long idPedido) throws Exception{
        Pedido pedido = pedidoService.agregarCliente(idPedido, cliente);
        return Optional.of(pedido);
    }
    @PostMapping("/empleados/{idPedido}")
    public Optional<Pedido> agregarEmpleado(@RequestBody Empleado empleado, @PathVariable Long idPedido) throws Exception{
        Pedido pedido = pedidoService.agregarEmpleado(idPedido, empleado);
        return Optional.of(pedido);
    }
    @PostMapping("/domicilios/{idPedido}")
    public Optional<Pedido> agregarDomicilio(@RequestBody Domicilio domicilio, @PathVariable Long idPedido) throws Exception{
        Pedido pedido = pedidoService.agregarDomicilio(idPedido, domicilio);
        return Optional.of(pedido);
    }
    @PostMapping("/facturas/{idPedido}")
    public Optional<Pedido> agregarFactura(@RequestBody Factura factura,@PathVariable Long idPedido) throws Exception{
        Pedido pedido = pedidoService.agregarFactura(idPedido, factura);
        return Optional.of(pedido);
    }
    @PostMapping("/sucursales/{idPedido}")
    public Optional<Pedido> agregarSucursal(@RequestBody Sucursal sucursal,@PathVariable Long idPedido) throws Exception{
        Pedido pedido = pedidoService.agregarSucursal(idPedido, sucursal);
        return Optional.of(pedido);
    }
    @GetMapping("/clientes/{id}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable Long id) throws Exception {
        List<Pedido> listaPedidos = pedidoService.listarPorCliente(id);
        return ResponseEntity.ok(listaPedidos);
    }
    @GetMapping("/empleados/{id}")
    public ResponseEntity<List<Pedido>> listarPorEmpleado(@PathVariable Long id) throws Exception {
        List<Pedido> listaPedidos = pedidoService.listarPorEmpleado(id);
        return ResponseEntity.ok(listaPedidos);
    }
    @GetMapping("/domicilios/{id}")
    public ResponseEntity<List<Pedido>> listarPorDomicilio(@PathVariable Long id) throws Exception {
        List<Pedido> listaPedidos = pedidoService.listarPorDomicilio(id);
        return ResponseEntity.ok(listaPedidos);
    }
    @GetMapping("/sucursales/{id}")
    public ResponseEntity<List<Pedido>> listarPorSucursal(@PathVariable Long id) throws Exception {
        List<Pedido> listaPedidos = pedidoService.listarPorSucursal(id);
        return ResponseEntity.ok(listaPedidos);
    }
    @GetMapping("/facturas/{id}")
    public ResponseEntity<Pedido> listarPorFactura(@PathVariable Long id) throws Exception {
        Pedido pedido = pedidoService.listarPorFactura(id);
        return ResponseEntity.ok(pedido);
    }
}