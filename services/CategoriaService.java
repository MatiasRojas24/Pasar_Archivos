package com.example.parcial_prog2_api.services;

import com.example.parcial_prog2_api.entities.Categoria;
import com.example.parcial_prog2_api.entities.Promocion;
import com.example.parcial_prog2_api.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements BaseService<Categoria> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public List<Categoria> listar() throws Exception {
        try{
            List<Categoria> categorias = categoriaRepository.findAll();
            return categorias;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria buscarPorId(Long id) throws Exception {
        try{
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria crear(Categoria categoria) throws Exception {
        try{
            categoria = categoriaRepository.save(categoria);
            return categoria;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria actualizar(Long id, Categoria categoria) throws Exception {
        try{
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            Categoria entidad = entityOptional.get();
            entidad = categoriaRepository.save(entidad);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if (categoriaRepository.existsById(id)){
                categoriaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Categoria agregarSubcategoria (Long idCategoriaPadre, Categoria nuevaSubcategoria) throws Exception {
        try {
            // Obtenemos una categoria existente y se guarda en un objeto de tipo Categoria
            Categoria categoriaPadre = categoriaRepository.findById(idCategoriaPadre).orElse(null);
            if (categoriaPadre != null){ // comprobar que la categoria existente se halla guardado
                // Le asignamos una categoria padre a la nueva subcategoria, que sera la categoria existente obtenida antes
                nuevaSubcategoria.setCategoriaPadre(categoriaPadre);
                // Se crea la nueva subcategoria en el repositorio de categoria
                categoriaRepository.save(nuevaSubcategoria);
                // obtenemos la nueva subcategoria ya creada adecuadamente
                return nuevaSubcategoria;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarPorCategoriaPadre(Long idCategoriaPadre) throws Exception{
        try {
            return categoriaRepository.findAllByCategoriaPadre_id(idCategoriaPadre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarPorSucursal(Long idSucursal) throws Exception{
        try {
            return categoriaRepository.findAllBySucursales_id(idSucursal);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
