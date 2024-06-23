package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.ImagenEmpleado;
import com.example.parcial_prog2_api.repositories.ImagenEmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenEmpleadoService implements BaseService<ImagenEmpleado> {
    @Autowired
    ImagenEmpleadoRepository imagenEmpleadoRepository;

    @Override
    @Transactional
    public List<ImagenEmpleado> listar() throws Exception {
        try{
            List<ImagenEmpleado> imagenEmpleados = imagenEmpleadoRepository.findAll();
            return imagenEmpleados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenEmpleado buscarPorId(Long id) throws Exception {
        try{
            Optional<ImagenEmpleado> entityOptional = imagenEmpleadoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenEmpleado crear(ImagenEmpleado imagenEmpleado) throws Exception {
        try{
            imagenEmpleado = imagenEmpleadoRepository.save(imagenEmpleado);
            return imagenEmpleado;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ImagenEmpleado actualizar(Long id, ImagenEmpleado imagenEmpleado) throws Exception {
        try{
            Optional<ImagenEmpleado> entityOptional = imagenEmpleadoRepository.findById(id);
            ImagenEmpleado entidad = entityOptional.get();
            entidad = imagenEmpleadoRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (imagenEmpleadoRepository.existsById(id)){
                imagenEmpleadoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
