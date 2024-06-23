package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.UsuarioCliente;
import com.example.parcial_prog2_api.repositories.UsuarioClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioClienteService implements BaseService<UsuarioCliente>{
    @Autowired
    UsuarioClienteRepository usuarioClienteRepository;

    @Override
    @Transactional
    public List<UsuarioCliente> listar() throws Exception {
        try{
            List<UsuarioCliente> usuarioClientes = usuarioClienteRepository.findAll();
            return usuarioClientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UsuarioCliente buscarPorId(Long id) throws Exception {
        try{
            Optional<UsuarioCliente> entityOptional = usuarioClienteRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UsuarioCliente crear(UsuarioCliente usuarioCliente) throws Exception {
        try{
            usuarioCliente = usuarioClienteRepository.save(usuarioCliente);
            return usuarioCliente;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UsuarioCliente actualizar(Long id, UsuarioCliente usuarioCliente) throws Exception {
        try{
            Optional<UsuarioCliente> entityOptional = usuarioClienteRepository.findById(id);
            UsuarioCliente entidad = entityOptional.get();
            entidad = usuarioClienteRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (usuarioClienteRepository.existsById(id)){
                usuarioClienteRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
