package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.PromocionDetalleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionDetalleService implements BaseService<PromocionDetalle> {

    @Autowired
    PromocionDetalleRepository promocionDetalleRepository;

    @Override
    @Transactional
    public List<PromocionDetalle> listar() throws Exception {
        try{
            List<PromocionDetalle> promocionDetalles = promocionDetalleRepository.findAll();
            return promocionDetalles;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PromocionDetalle buscarPorId(Long id) throws Exception {
        try{
            Optional<PromocionDetalle> entityOptional = promocionDetalleRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PromocionDetalle crear(PromocionDetalle promocionDetalle) throws Exception {
        try{
            promocionDetalle = promocionDetalleRepository.save(promocionDetalle);
            return promocionDetalle;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PromocionDetalle actualizar(Long id, PromocionDetalle promocionDetalle) throws Exception {
        try{
            Optional<PromocionDetalle> entityOptional = promocionDetalleRepository.findById(id);
            PromocionDetalle entidad = entityOptional.get();
            entidad = promocionDetalleRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (promocionDetalleRepository.existsById(id)){
                promocionDetalleRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public PromocionDetalle agregarArticulo(Long idPromocionDetalle, Articulo articulo) throws Exception {
        try {
            PromocionDetalle promocionDetalle = promocionDetalleRepository.findById(idPromocionDetalle).orElse(null);
            if (promocionDetalle != null) {
                promocionDetalle.setArticulo(articulo);
                promocionDetalleRepository.save(promocionDetalle);
                return promocionDetalle;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public PromocionDetalle agregarPromocion(Long idPromocionDetalle, Promocion promocion) throws Exception {
        try {
            PromocionDetalle promocionDetalle = promocionDetalleRepository.findById(idPromocionDetalle).orElse(null);
            if (promocionDetalle != null) {
                promocionDetalle.setPromocion(promocion);
                promocionDetalleRepository.save(promocionDetalle);
                return promocionDetalle;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<PromocionDetalle> listarPorPromocion(Long idPromocion) throws Exception{
        try {
            return promocionDetalleRepository.findAllByPromocion_id(idPromocion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<PromocionDetalle> listarPorArticulo(Long idArticulo) throws Exception{
        try {
            return promocionDetalleRepository.findAllByArticulo_id(idArticulo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
