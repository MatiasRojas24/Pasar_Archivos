package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.ArticuloManufacturadoDetalleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoDetalleService implements BaseService<ArticuloManufacturadoDetalle> {

    @Autowired
    ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    @Override
    @Transactional
    public List<ArticuloManufacturadoDetalle> listar() throws Exception {
        try{
            List<ArticuloManufacturadoDetalle> entities = articuloManufacturadoDetalleRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturadoDetalle buscarPorId(Long id) throws Exception {
        try{
            Optional<ArticuloManufacturadoDetalle> entityOptional = articuloManufacturadoDetalleRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturadoDetalle crear(ArticuloManufacturadoDetalle entity) throws Exception {
        try{
            entity = articuloManufacturadoDetalleRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturadoDetalle actualizar(Long id, ArticuloManufacturadoDetalle entity) throws Exception {
        try{
            Optional<ArticuloManufacturadoDetalle> entityOptional = articuloManufacturadoDetalleRepository.findById(id);
            ArticuloManufacturadoDetalle articuloManufacturadoDetale = entityOptional.get();
            articuloManufacturadoDetale = articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetale);
            return articuloManufacturadoDetale;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (articuloManufacturadoDetalleRepository.existsById(id)){
                articuloManufacturadoDetalleRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public ArticuloManufacturadoDetalle agregarArticuloInsumo(Long idArticuloManufacturadoDetalle, ArticuloInsumo articuloInsumo) throws Exception {
        try {
            ArticuloManufacturadoDetalle articuloManufacturadoDetalle = articuloManufacturadoDetalleRepository.findById(idArticuloManufacturadoDetalle).orElse(null);
            if (articuloManufacturadoDetalle != null) {
                articuloManufacturadoDetalle.setArticuloInsumo(articuloInsumo);
                articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle);
                return articuloManufacturadoDetalle;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public ArticuloManufacturadoDetalle agregarArticuloManufacturado(Long idArticuloManufacturadoDetalle, ArticuloManufacturado articuloManufacturado) throws Exception {
        try {
            ArticuloManufacturadoDetalle articuloManufacturadoDetalle = articuloManufacturadoDetalleRepository.findById(idArticuloManufacturadoDetalle).orElse(null);
            if (articuloManufacturadoDetalle != null) {
                articuloManufacturadoDetalle.setArticuloManufacturado(articuloManufacturado);
                articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle);
                return articuloManufacturadoDetalle;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<ArticuloManufacturadoDetalle> listarPorArticuloInsumo(Long idArticuloInsumo) throws Exception{
        try {
            return articuloManufacturadoDetalleRepository.findAllByArticuloInsumo_id(idArticuloInsumo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<ArticuloManufacturadoDetalle> listarPorArticuloManufacturado(Long idArticuloManufacturado) throws Exception{
        try {
            return articuloManufacturadoDetalleRepository.findAllByArticuloInsumo_id(idArticuloManufacturado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
