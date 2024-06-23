package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements BaseService<Pedido> {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public List<Pedido> listar() throws Exception {
        try{
            List<Pedido> pedidos = pedidoRepository.findAll();
            return pedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido buscarPorId(Long id) throws Exception {
        try{
            Optional<Pedido> entityOptional = pedidoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido crear(Pedido pedido) throws Exception {
        try{
            pedido = pedidoRepository.save(pedido);
            return pedido;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido actualizar(Long id, Pedido pedido) throws Exception {
        try{
            Optional<Pedido> entityOptional = pedidoRepository.findById(id);
            Pedido entidad = entityOptional.get();
            entidad = pedidoRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (pedidoRepository.existsById(id)){
                pedidoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Pedido agregarCliente(Long idPedido, Cliente cliente) throws Exception {
        try {
            Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
            if (pedido != null) {
                pedido.setCliente(cliente);
                pedidoRepository.save(pedido);
                return pedido;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Pedido agregarEmpleado(Long idPedido, Empleado empleado) throws Exception {
        try {
            Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
            if (pedido != null) {
                pedido.setEmpleado(empleado);
                pedidoRepository.save(pedido);
                return pedido;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Pedido agregarDomicilio(Long idPedido, Domicilio domicilio) throws Exception {
        try {
            Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
            if (pedido != null) {
                pedido.setDomicilio(domicilio);
                pedidoRepository.save(pedido);
                return pedido;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Pedido agregarFactura(Long idPedido, Factura factura) throws Exception {
        try {
            Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
            if (pedido != null) {
                pedido.setFactura(factura);
                pedidoRepository.save(pedido);
                return pedido;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Pedido agregarSucursal(Long idPedido, Sucursal sucursal) throws Exception {
        try {
            Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
            if (pedido != null) {
                pedido.setSucursal(sucursal);
                pedidoRepository.save(pedido);
                return pedido;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Pedido> listarPorCliente(Long idCliente) throws Exception{
        try {
            return pedidoRepository.findAllByCliente_id(idCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Pedido> listarPorEmpleado(Long idEmpleado) throws Exception{
        try {
            return pedidoRepository.findAllByEmpleado_id(idEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Pedido> listarPorSucursal(Long idSucursal) throws Exception{
        try {
            return pedidoRepository.findAllBySucursal_id(idSucursal);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Pedido> listarPorDomicilio(Long idDomicilio) throws Exception{
        try {
            return pedidoRepository.findAllByDomicilio_id(idDomicilio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Pedido listarPorFactura(Long idFactura) throws Exception{
        try {
            return pedidoRepository.findAllByFactura_id(idFactura);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
