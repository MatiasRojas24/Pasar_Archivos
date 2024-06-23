package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.DetallePedidoRepository;
import com.example.parcial_prog2_api.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService implements BaseService<DetallePedido> {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    @Transactional
    public List<DetallePedido> listar() throws Exception {
        try {
            List<DetallePedido> detallePedidos = detallePedidoRepository.findAll();
            return detallePedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public DetallePedido buscarPorId(Long id) throws Exception {
        try{
            Optional<DetallePedido> entityOptional = detallePedidoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public DetallePedido crear(DetallePedido detallePedido) throws Exception {
        try{
            detallePedido = detallePedidoRepository.save(detallePedido);
            return detallePedido;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public DetallePedido actualizar(Long id, DetallePedido detallePedido) throws Exception {
        try{
            Optional<DetallePedido> entityOptional = detallePedidoRepository.findById(id);
            DetallePedido entidad = entityOptional.get();
            entidad = detallePedidoRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (detallePedidoRepository.existsById(id)){
                detallePedidoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public DetallePedido agregarArticulo(Long idDetallePedido, Articulo articulo) throws Exception {
        try {
            DetallePedido detallePedido = detallePedidoRepository.findById(idDetallePedido).orElse(null);
            if (detallePedido != null) {
                detallePedido.setArticulo(articulo);
                detallePedidoRepository.save(detallePedido);
                return detallePedido;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public DetallePedido agregarPedido(Long idDetallePedido, Pedido pedido) throws Exception {
        try {
            DetallePedido detallePedido = detallePedidoRepository.findById(idDetallePedido).orElse(null);
            if (detallePedido != null) {
                detallePedido.setPedido(pedido);
                pedido.setTotal(pedido.getTotal()+detallePedido.getSubtotal());
                pedidoRepository.save(pedido);
                detallePedidoRepository.save(detallePedido);
                return detallePedido;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<DetallePedido> listarPorPedido(Long idPedido) throws Exception{
        try {
            return detallePedidoRepository.findAllByPedido_id(idPedido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<DetallePedido> listarPorArticulo(Long idArticulo) throws Exception{
        try {
            return detallePedidoRepository.findAllByArticulo_id(idArticulo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
