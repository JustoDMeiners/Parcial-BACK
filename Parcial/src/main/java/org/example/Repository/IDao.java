package org.example.Repository;

import org.example.Model.Odontologo;


import java.util.List;

public interface IDao<T>{

    public void eliminar (Long id);
    public T agregar (T t) throws ClassNotFoundException;
    public void modificar (Odontologo o);
    public List<T> listar ();






}
