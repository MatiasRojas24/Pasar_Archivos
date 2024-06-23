package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements BaseService<Domicilio> {

    @Autowired
    DomicilioRepository domicilioRepository;

    @Override
    @Transactional
    public List<Domicilio> listar() throws Exception {
        try{
            List<Domicilio> domicilios = domicilioRepository.findAll();
            return domicilios;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio buscarPorId(Long id) throws Exception {
        try{
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio crear(Domicilio domicilio) throws Exception {
        try{
            domicilio = domicilioRepository.save(domicilio);
            return domicilio;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio actualizar(Long id, Domicilio cliente) throws Exception {
        try{
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            Domicilio entidad = entityOptional.get();
            entidad = domicilioRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (domicilioRepository.existsById(id)){
                domicilioRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Domicilio agregarLocalidad(Long idDomicilio, Localidad localidad) throws Exception {
        try {
            Domicilio domicilio = domicilioRepository.findById(idDomicilio).orElse(null);
            if (domicilio != null) {
                domicilio.setLocalidad(localidad);
                domicilioRepository.save(domicilio);
                return domicilio;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Domicilio agregarClientes(Long idDomicilio, Set<Cliente> clientes) throws Exception {
        try {
            Domicilio domicilio = domicilioRepository.findById(idDomicilio).orElse(null);
            if (domicilio != null) {
                domicilio.setClientes(clientes);
                domicilioRepository.save(domicilio);
                return domicilio;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Domicilio> listarPorLocalidad(Long idLocalidad) throws Exception{
        try {
            return domicilioRepository.findAllByLocalidad_id(idLocalidad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Domicilio> listarPorCliente(Long idCliente) throws Exception{
        try {
            return domicilioRepository.findAllByClientes_id(idCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
