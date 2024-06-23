package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements BaseService<Empleado> {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    @Transactional
    public List<Empleado> listar() throws Exception {
        try{
            List<Empleado> empleados = empleadoRepository.findAll();
            return empleados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado buscarPorId(Long id) throws Exception {
        try{
            Optional<Empleado> entityOptional = empleadoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado crear(Empleado empleado) throws Exception {
        try{
            empleado = empleadoRepository.save(empleado);
            return empleado;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado actualizar(Long id, Empleado empleado) throws Exception {
        try{
            Optional<Empleado> entityOptional = empleadoRepository.findById(id);
            Empleado entidad = entityOptional.get();
            entidad = empleadoRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (empleadoRepository.existsById(id)){
                empleadoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Empleado agragarUsuarioEmpleado(Long idEmpleado, UsuarioEmpleado usuarioEmpleado) throws Exception {
        try {
            Empleado empleado = empleadoRepository.findById(idEmpleado).orElse(null);
            if (empleado != null) {
                empleado.setUsuarioEmpleado(usuarioEmpleado);
                empleadoRepository.save(empleado);
                return empleado;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Empleado agregarImagenEmpleado(Long idEmpleado, ImagenEmpleado imagenEmpleado) throws Exception {
        try {
            Empleado empleado = empleadoRepository.findById(idEmpleado).orElse(null);
            if (empleado != null) {
                empleado.setImagenEmpleado(imagenEmpleado);
                empleadoRepository.save(empleado);
                return empleado;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Empleado agregarSucursal(Long idEmpleado, Sucursal sucursal) throws Exception {
        try {
            Empleado empleado = empleadoRepository.findById(idEmpleado).orElse(null);
            if (empleado != null) {
                empleado.setSucursal(sucursal);
                empleadoRepository.save(empleado);
                return empleado;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Empleado listarPorUsuarioEmpleado(Long idUsuarioEmpleado) throws Exception{
        try {
            return empleadoRepository.findAllByUsuarioEmpleado_id(idUsuarioEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Empleado listarPorImagenEmpleado(Long idImagenEmpleado) throws Exception{
        try {
            return empleadoRepository.findAllByImagenEmpleado_id(idImagenEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Empleado> listarPorSucursal(Long idSucursal) throws Exception{
        try {
            return empleadoRepository.findAllBySucursal_id(idSucursal);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
