package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.ProvinciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService implements BaseService<Provincia> {

    @Autowired
    ProvinciaRepository provinciaRepository;

    @Override
    @Transactional
    public List<Provincia> listar() throws Exception {
        try{
            List<Provincia> provincias = provinciaRepository.findAll();
            return provincias;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provincia buscarPorId(Long id) throws Exception {
        try{
            Optional<Provincia> entityOptional = provinciaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provincia crear(Provincia provincia) throws Exception {
        try{
            provincia = provinciaRepository.save(provincia);
            return provincia;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Provincia actualizar(Long id, Provincia provincia) throws Exception {
        try{
            Optional<Provincia> entityOptional = provinciaRepository.findById(id);
            Provincia entidad = entityOptional.get();
            entidad = provinciaRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (provinciaRepository.existsById(id)){
                provinciaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Provincia agregarPais(Long idProvincia, Pais pais) throws Exception {
        try {
            Provincia provincia = provinciaRepository.findById(idProvincia).orElse(null);
            if (provincia != null) {
                provincia.setPais(pais);
                provinciaRepository.save(provincia);
                return provincia;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Provincia> listarPorPais(Long idPais) throws Exception{
        try {
            return provinciaRepository.findAllByPais_Id(idPais);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
