package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.UsuarioEmpleado;
import com.example.parcial_prog2_api.repositories.UsuarioEmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioEmpleadoService implements BaseService<UsuarioEmpleado> {
    @Autowired
    UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @Override
    @Transactional
    public List<UsuarioEmpleado> listar() throws Exception {
        try{
            List<UsuarioEmpleado> clientes = usuarioEmpleadoRepository.findAll();
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UsuarioEmpleado buscarPorId(Long id) throws Exception {
        try{
            Optional<UsuarioEmpleado> entityOptional = usuarioEmpleadoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UsuarioEmpleado crear(UsuarioEmpleado usuarioEmpleado) throws Exception {
        try{
            usuarioEmpleado = usuarioEmpleadoRepository.save(usuarioEmpleado);
            return usuarioEmpleado;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public UsuarioEmpleado actualizar(Long id, UsuarioEmpleado usuarioEmpleado) throws Exception {
        try{
            Optional<UsuarioEmpleado> entityOptional = usuarioEmpleadoRepository.findById(id);
            UsuarioEmpleado entidad = entityOptional.get();
            entidad = usuarioEmpleadoRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (usuarioEmpleadoRepository.existsById(id)){
                usuarioEmpleadoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
