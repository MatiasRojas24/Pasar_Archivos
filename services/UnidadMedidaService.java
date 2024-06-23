package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.UnidadMedida;
import com.example.parcial_prog2_api.repositories.UnidadMedidaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadMedidaService implements BaseService<UnidadMedida> {

    @Autowired
    UnidadMedidaRepository unidadMedidaRepository;

    @Override
    @Transactional
    public List<UnidadMedida> listar() throws Exception {
        try{
            List<UnidadMedida> clientes = unidadMedidaRepository.findAll();
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UnidadMedida buscarPorId(Long id) throws Exception {
        try{
            Optional<UnidadMedida> entityOptional = unidadMedidaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UnidadMedida crear(UnidadMedida unidadMedida) throws Exception {
        try{
            unidadMedida = unidadMedidaRepository.save(unidadMedida);
            return unidadMedida;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UnidadMedida actualizar(Long id, UnidadMedida unidadMedida) throws Exception {
        try{
            Optional<UnidadMedida> entityOptional = unidadMedidaRepository.findById(id);
            UnidadMedida entidad = entityOptional.get();
            entidad = unidadMedidaRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (unidadMedidaRepository.existsById(id)){
                unidadMedidaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
