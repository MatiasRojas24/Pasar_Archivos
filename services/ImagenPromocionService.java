package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.ImagenPromocion;
import com.example.parcial_prog2_api.repositories.ImagenPromocionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenPromocionService implements BaseService<ImagenPromocion> {

    @Autowired
    ImagenPromocionRepository imagenPromocionRepository;

    @Override
    @Transactional
    public List<ImagenPromocion> listar() throws Exception {
        try{
            List<ImagenPromocion> imagenPromocions = imagenPromocionRepository.findAll();
            return imagenPromocions;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenPromocion buscarPorId(Long id) throws Exception {
        try{
            Optional<ImagenPromocion> entityOptional = imagenPromocionRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenPromocion crear(ImagenPromocion imagenPromocion) throws Exception {
        try{
            imagenPromocion = imagenPromocionRepository.save(imagenPromocion);
            return imagenPromocion;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenPromocion actualizar(Long id, ImagenPromocion imagenPromocion) throws Exception {
        try{
            Optional<ImagenPromocion> entityOptional = imagenPromocionRepository.findById(id);
            ImagenPromocion entidad = entityOptional.get();
            entidad = imagenPromocionRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (imagenPromocionRepository.existsById(id)){
                imagenPromocionRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
