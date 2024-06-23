package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.ArticuloInsumoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ArticuloInsumoService implements BaseService<ArticuloInsumo>{

    @Autowired
    ArticuloInsumoRepository articuloInsumoRepository;

    @Override
    @Transactional
    public List<ArticuloInsumo> listar() throws Exception {
        try{
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.findAll();
            return articuloInsumos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloInsumo buscarPorId(Long id) throws Exception {
        try{
            Optional<ArticuloInsumo> entityOptional = articuloInsumoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloInsumo crear(ArticuloInsumo articuloInsumo) throws Exception {
        try{
            articuloInsumo = articuloInsumoRepository.save(articuloInsumo);
            return articuloInsumo;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloInsumo actualizar(Long id, ArticuloInsumo entity) throws Exception {
        try{
            Optional<ArticuloInsumo> entityOptional = articuloInsumoRepository.findById(id);
            ArticuloInsumo articuloInsumo = entityOptional.get();
            articuloInsumo = articuloInsumoRepository.save(articuloInsumo);
            return articuloInsumo;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (articuloInsumoRepository.existsById(id)){
                articuloInsumoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public ArticuloInsumo agregarImagenArticulo(Long idArticuloInsumo, Set<ImagenArticulo> imagenArticulo) throws Exception {
        try {
            ArticuloInsumo articuloInsumo = articuloInsumoRepository.findById(idArticuloInsumo).orElse(null);
            if (articuloInsumo != null) {
                articuloInsumo.setImagenesArticulos(imagenArticulo);
                articuloInsumoRepository.save(articuloInsumo);
                return articuloInsumo;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public ArticuloInsumo agregarUnidadMedida(Long idArticuloInsumo, UnidadMedida unidadMedida) throws Exception {
        try {
            ArticuloInsumo articuloInsumo = articuloInsumoRepository.findById(idArticuloInsumo).orElse(null);
            if (articuloInsumo != null) {
                articuloInsumo.setUnidadMedida(unidadMedida);
                articuloInsumoRepository.save(articuloInsumo);
                return articuloInsumo;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public ArticuloInsumo agregarCategoria(Long idArticuloInsumo, Categoria categoria) throws Exception {
        try {
            ArticuloInsumo articuloInsumo = articuloInsumoRepository.findById(idArticuloInsumo).orElse(null);
            if (articuloInsumo != null) {
                articuloInsumo.setCategoria(categoria);
                articuloInsumoRepository.save(articuloInsumo);
                return articuloInsumo;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<ArticuloInsumo> listarPorCategoria(Long idCategoria) throws Exception{
        try {
            return articuloInsumoRepository.findAllByCategoria_id(idCategoria);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<ArticuloInsumo> listarPorUnidadMedida(Long idUnidadMedida) throws Exception{
        try {
            return articuloInsumoRepository.findAllByUnidadMedida_id(idUnidadMedida);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public ArticuloInsumo listarPorImagenArticulo(Long idImagenArticulo) throws Exception{
        try {
            return articuloInsumoRepository.findAllByImagenesArticulos_id(idImagenArticulo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
