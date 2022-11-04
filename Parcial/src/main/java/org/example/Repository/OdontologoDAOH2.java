package org.example.Repository;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.Model.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class OdontologoDAOH2 implements IDao<Odontologo> {

    private final static Logger logger = (Logger) LogManager.getLogger(OdontologoDAOH2.class);
    private final static String DB_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/testeando;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";



    @Override
    public void eliminar(Long id) {

        PreparedStatement preparedStatement = null;
        try {
            var connection = preparedStatement.getConnection();
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            preparedStatement = connection.prepareStatement("DELETE FROM odontologos WHERE id = (?)");
            preparedStatement.setLong(1,id);


            preparedStatement.executeUpdate();
            logger.debug("Odontologo eliminado");
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public Odontologo agregar(Odontologo odontologo)  {

        PreparedStatement preparedStatement = null;
        try {
            var connection = preparedStatement.getConnection();
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            preparedStatement = connection.prepareStatement("INSERT INTO odontologos VALUES (?,?,?,?)");
            preparedStatement.setLong(1,odontologo.getId());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.setString(4,odontologo.getMatricula());

            preparedStatement.executeUpdate();
            logger.debug("Odontologo agregado");
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
           logger.error(e);
            throw new RuntimeException(e);
        }return odontologo;

    }

    @Override
    public void modificar(Odontologo o) {

        PreparedStatement preparedStatement = null;
        try {
            var connection = preparedStatement.getConnection();
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            preparedStatement = connection.prepareStatement("UPDATE odontologos set nombre = (?) WHERE id = (?)");
            preparedStatement.setString(1,o.getNombre());
            preparedStatement.setLong(2,o.getId());


            preparedStatement.executeUpdate();
            logger.debug("Odontologo modificado");
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
             logger.error(e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Odontologo> listar() {

        PreparedStatement preparedStatement = null;
        ArrayList <Odontologo> odontologos= new ArrayList();



        try {
            var connection = preparedStatement.getConnection();
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id = (?)");


            ResultSet result = preparedStatement.executeQuery();


            preparedStatement.executeUpdate();
            logger.debug("Odontologo listado");
            preparedStatement.close();

            while (result.next()){
                Long idOdontologo = result.getLong("id");
                String nombreOdontologo = result.getString("nombre");
                String apellidoOdontologo = result.getString("apellido");
                String matriculaOdontologo = result.getString("matricula");

                Odontologo odontologo = new Odontologo();
                odontologo.setId(idOdontologo);
                odontologo.setNombre(nombreOdontologo);
                odontologo.setApellido(apellidoOdontologo);
                odontologo.setMatricula(matriculaOdontologo);

                odontologo.add(odontologo);
             }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }return odontologos;

    }
}
