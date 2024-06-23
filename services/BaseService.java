package com.example.parcial_prog2_api.services;

import java.util.List;

public interface BaseService<E> {
    public List<E> listar() throws Exception;
    public E buscarPorId(Long id) throws Exception;
    public E crear(E entity) throws Exception;
    public E actualizar(Long id, E entity) throws Exception;
    public boolean eliminar(Long id) throws Exception;
}
