package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.ArticuloInsumo;
import com.example.parcial_prog2_api.entities.ImagenArticulo;
import com.example.parcial_prog2_api.repositories.ImagenArticuloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenArticuloService implements BaseService<ImagenArticulo> {

    @Autowired
    ImagenArticuloRepository imagenArticuloRepository;

    @Override
    @Transactional
    public List<ImagenArticulo> listar() throws Exception {
        try{
            List<ImagenArticulo> imagenArticulos = imagenArticuloRepository.findAll();
            return imagenArticulos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenArticulo buscarPorId(Long id) throws Exception {
        try{
            Optional<ImagenArticulo> entityOptional = imagenArticuloRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenArticulo crear(ImagenArticulo imagenArticulo) throws Exception {
        try{
            imagenArticulo = imagenArticuloRepository.save(imagenArticulo);
            return imagenArticulo;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenArticulo actualizar(Long id, ImagenArticulo imagenArticulo) throws Exception {
        try{
            Optional<ImagenArticulo> entityOptional = imagenArticuloRepository.findById(id);
            ImagenArticulo entidad = entityOptional.get();
            entidad = imagenArticuloRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (imagenArticuloRepository.existsById(id)){
                imagenArticuloRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
