package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.PromocionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PromocionService implements BaseService<Promocion> {

    @Autowired
    PromocionRepository promocionRepository;

    @Override
    @Transactional
    public List<Promocion> listar() throws Exception {
        try{
            List<Promocion> promociones = promocionRepository.findAll();
            return promociones;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Promocion buscarPorId(Long id) throws Exception {
        try{
            Optional<Promocion> entityOptional = promocionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Promocion crear(Promocion promocion) throws Exception {
        try{
            promocion = promocionRepository.save(promocion);
            return promocion;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Promocion actualizar(Long id, Promocion promocion) throws Exception {
        try{
            Optional<Promocion> entityOptional = promocionRepository.findById(id);
            Promocion entidad = entityOptional.get();
            entidad = promocionRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (promocionRepository.existsById(id)){
                promocionRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Promocion agregarImagenesPromociones(Long idPromocion, Set<ImagenPromocion> imagenesPromociones) throws Exception {
        try {
            Promocion promocion = promocionRepository.findById(idPromocion).orElse(null);
            if (promocion != null) {
                promocion.setImagenPromociones(imagenesPromociones);
                promocionRepository.save(promocion);
                return promocion;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Promocion> listarPorSucursal(Long idSucursal) throws Exception{
        try {
            return promocionRepository.findAllBySucursales_id(idSucursal);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Promocion listarPorImagenPromocion(Long idImagenPromocion) throws Exception{
        try {
            return promocionRepository.findAllByImagenPromociones_id(idImagenPromocion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
