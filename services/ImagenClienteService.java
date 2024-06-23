package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.ImagenCliente;
import com.example.parcial_prog2_api.repositories.ImagenClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenClienteService implements BaseService<ImagenCliente> {
    @Autowired
    ImagenClienteRepository imagenClienteRepository;

    @Override
    @Transactional
    public List<ImagenCliente> listar() throws Exception {
        try{
            List<ImagenCliente> imagenClientes = imagenClienteRepository.findAll();
            return imagenClientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenCliente buscarPorId(Long id) throws Exception {
        try{
            Optional<ImagenCliente> entityOptional = imagenClienteRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenCliente crear(ImagenCliente imagenCliente) throws Exception {
        try{
            imagenCliente = imagenClienteRepository.save(imagenCliente);
            return imagenCliente;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenCliente actualizar(Long id, ImagenCliente imagenCliente) throws Exception {
        try{
            Optional<ImagenCliente> entityOptional = imagenClienteRepository.findById(id);
            ImagenCliente entidad = entityOptional.get();
            entidad = imagenClienteRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (imagenClienteRepository.existsById(id)){
                imagenClienteRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
