package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.Factura;
import com.example.parcial_prog2_api.repositories.FacturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements BaseService<Factura> {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    @Transactional
    public List<Factura> listar() throws Exception {
        try{
            List<Factura> facturas = facturaRepository.findAll();
            return facturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Factura buscarPorId(Long id) throws Exception {
        try{
            Optional<Factura> entityOptional = facturaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Factura crear(Factura factura) throws Exception {
        try{
            factura = facturaRepository.save(factura);
            return factura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Factura actualizar(Long id, Factura factura) throws Exception {
        try{
            Optional<Factura> entityOptional = facturaRepository.findById(id);
            Factura entidad = entityOptional.get();
            entidad = facturaRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (facturaRepository.existsById(id)){
                facturaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
