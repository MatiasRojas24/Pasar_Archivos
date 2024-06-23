package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.Pais;
import com.example.parcial_prog2_api.repositories.PaisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService implements BaseService<Pais> {

    @Autowired
    PaisRepository paisRepository;

    @Override
    @Transactional
    public List<Pais> listar() throws Exception {
        try{
            List<Pais> paises = paisRepository.findAll();
            return paises;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pais buscarPorId(Long id) throws Exception {
        try{
            Optional<Pais> entityOptional = paisRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pais crear(Pais pais) throws Exception {
        try{
            pais = paisRepository.save(pais);
            return pais;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pais actualizar(Long id, Pais pais) throws Exception {
        try{
            Optional<Pais> entityOptional = paisRepository.findById(id);
            Pais entidad = entityOptional.get();
            entidad = paisRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (paisRepository.existsById(id)){
                paisRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
