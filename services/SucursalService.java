package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.*;
import com.example.parcial_prog2_api.repositories.DomicilioRepository;
import com.example.parcial_prog2_api.repositories.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class SucursalService implements BaseService<Sucursal> {

    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    @Transactional
    public List<Sucursal> listar() throws Exception {
        try{
            List<Sucursal> clientes = sucursalRepository.findAll();
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Sucursal buscarPorId(Long id) throws Exception {
        try{
            Optional<Sucursal> entityOptional = sucursalRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Sucursal crear(Sucursal sucursal) throws Exception {
        try{
            sucursal = sucursalRepository.save(sucursal);
            return sucursal;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Sucursal actualizar(Long id, Sucursal sucursal) throws Exception {
        try{
            Optional<Sucursal> entityOptional = sucursalRepository.findById(id);
            Sucursal entidad = entityOptional.get();
            entidad = sucursalRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (sucursalRepository.existsById(id)){
                sucursalRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Sucursal agregarDomicilio (Long idSucursal, Domicilio nuevoDomicilio) throws Exception {
        try {
            Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
            if (sucursal != null){
                sucursal.setDomicilio(nuevoDomicilio);
                sucursalRepository.save(sucursal);
                return sucursal;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Sucursal agregarEmperesa(Long idSucursal, Empresa empresa) throws Exception {
        try {
            Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
            if (sucursal != null){
                sucursal.setEmpresa(empresa);
                sucursalRepository.save(sucursal);
                return sucursal;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Sucursal agregarPromociones (Long idSucursal, Set<Promocion> promociones) throws Exception {
        try {
            Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
            if (sucursal != null){
                sucursal.setPromociones(promociones);
                sucursalRepository.save(sucursal);
                return sucursal;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Sucursal agregarCategorias (Long idSucursal, Set<Categoria> categorias) throws Exception {
        try {
            Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
            if (sucursal != null){
                sucursal.setCategorias(categorias);
                sucursalRepository.save(sucursal);
                return sucursal;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Sucursal> listarPorEmpresa(Long idEmpresa) throws Exception{
        try {
            return sucursalRepository.findAllByEmpresa_id(idEmpresa);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Sucursal> listarPorPromocion(Long idPromocion) throws Exception{
        try {
            return sucursalRepository.findAllByPromociones_id(idPromocion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Sucursal listarPorDomicilio(Long idDomicilio) throws Exception{
        try {
            return sucursalRepository.findAllByDomicilio_id(idDomicilio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<Sucursal> listarPorCategoria(Long idCategoria) throws Exception{
        try {
            return sucursalRepository.findAllByCategorias_id(idCategoria);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
