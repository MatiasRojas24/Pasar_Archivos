package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;

import com.example.parcial_prog2_api.repositories.ArticuloManufacturadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ArticuloManufacturadoService implements BaseService<ArticuloManufacturado>{

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Override
    @Transactional
    public List<ArticuloManufacturado> listar() throws Exception {
        try{
            List<ArticuloManufacturado> entidades = articuloManufacturadoRepository.findAll();
            return entidades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturado buscarPorId(Long id) throws Exception {
        try{
            Optional<ArticuloManufacturado> entityOptional = articuloManufacturadoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturado crear(ArticuloManufacturado entidad) throws Exception {
        try{
            entidad = articuloManufacturadoRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturado actualizar(Long id, ArticuloManufacturado entidad) throws Exception {
        try{
            Optional<ArticuloManufacturado> entityOptional = articuloManufacturadoRepository.findById(id);
            ArticuloManufacturado articuloManufacturado = entityOptional.get();
            articuloManufacturado = articuloManufacturadoRepository.save(articuloManufacturado);
            return articuloManufacturado;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (articuloManufacturadoRepository.existsById(id)){
                articuloManufacturadoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public ArticuloManufacturado agregarImagenArticulo(Long idArticuloManufacturado, Set<ImagenArticulo> imagenArticulo) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoRepository.findById(idArticuloManufacturado).orElse(null);
            if (articuloManufacturado != null) {
                articuloManufacturado.setImagenesArticulos(imagenArticulo);
                articuloManufacturadoRepository.save(articuloManufacturado);
                return articuloManufacturado;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public ArticuloManufacturado agregarUnidadMedida(Long idArticuloManufacturado, UnidadMedida unidadMedida) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoRepository.findById(idArticuloManufacturado).orElse(null);
            if (articuloManufacturado != null) {
                articuloManufacturado.setUnidadMedida(unidadMedida);
                articuloManufacturadoRepository.save(articuloManufacturado);
                return articuloManufacturado;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public ArticuloManufacturado agregarCategoria(Long idArticuloManufacturado, Categoria categoria) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoRepository.findById(idArticuloManufacturado).orElse(null);
            if (articuloManufacturado != null) {
                articuloManufacturado.setCategoria(categoria);
                articuloManufacturadoRepository.save(articuloManufacturado);
                return articuloManufacturado;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<ArticuloManufacturado> listarPorCategoria(Long idCategoria) throws Exception{
        try {
            return articuloManufacturadoRepository.findAllByCategoria_id(idCategoria);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<ArticuloManufacturado> listarPorUnidadMedida(Long idUnidadMedida) throws Exception{
        try {
            return articuloManufacturadoRepository.findAllByUnidadMedida_id(idUnidadMedida);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public ArticuloManufacturado listarPorImagenArticulo(Long idImagenArticulo) throws Exception{
        try {
            return articuloManufacturadoRepository.findAllByImagenesArticulos_id(idImagenArticulo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
