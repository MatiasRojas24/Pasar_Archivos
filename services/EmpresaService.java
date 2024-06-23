package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.Empresa;
import com.example.parcial_prog2_api.repositories.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements BaseService<Empresa> {

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    @Transactional
    public List<Empresa> listar() throws Exception {
        try{
            List<Empresa> empresas = empresaRepository.findAll();
            return empresas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empresa buscarPorId(Long id) throws Exception {
        try{
            Optional<Empresa> entityOptional = empresaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empresa crear(Empresa empresa) throws Exception {
        try{
            empresa = empresaRepository.save(empresa);
            return empresa;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empresa actualizar(Long id, Empresa empresa) throws Exception {
        try{
            Optional<Empresa> entityOptional = empresaRepository.findById(id);
            Empresa entidad = entityOptional.get();
            entidad = empresaRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (empresaRepository.existsById(id)){
                empresaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
