package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService implements BaseService<Localidad> {

    @Autowired
    LocalidadRepository localidadRepository;

    @Override
    @Transactional
    public List<Localidad> listar() throws Exception {
        try{
            List<Localidad> localidades = localidadRepository.findAll();
            return localidades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad buscarPorId(Long id) throws Exception {
        try{
            Optional<Localidad> entityOptional = localidadRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad crear(Localidad localidad) throws Exception {
        try{
            localidad = localidadRepository.save(localidad);
            return localidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad actualizar(Long id, Localidad localidad) throws Exception {
        try{
            Optional<Localidad> entityOptional = localidadRepository.findById(id);
            Localidad entidad = entityOptional.get();
            entidad = localidadRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (localidadRepository.existsById(id)){
                localidadRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Localidad agregarProvincia(Long idLocalidad, Provincia provincia) throws Exception {
        try {
            Localidad localidad = localidadRepository.findById(idLocalidad).orElse(null);
            if (localidad != null) {
                localidad.setProvincia(provincia);
                localidadRepository.save(localidad);
                return localidad;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Localidad> listarPorProvincia(Long idProvincia) throws Exception{
        try {
            return localidadRepository.findAllByProvincia_id(idProvincia);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
