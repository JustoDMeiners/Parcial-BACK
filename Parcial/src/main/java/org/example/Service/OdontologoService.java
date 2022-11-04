package org.example.Service;

import org.example.Model.Odontologo;
import org.example.Repository.IDao;


import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoDao;

    public IDao<Odontologo> getOdontologoDao() {
        return odontologoDao;
    }

    public void setOdontologoDao(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public void agregar (Odontologo o) throws ClassNotFoundException {
        //delegar responsabilidad  de guardar al dao
        odontologoDao.agregar(o);
    }

    public void eliminar (Long id){
        odontologoDao.eliminar(id);
    }
    public void modificar (Odontologo o){
        odontologoDao.modificar(o);
    }

    public List<Odontologo> listar(){
        return odontologoDao.listar();
    }
}
