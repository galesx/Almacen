package org.example;

import database.EsquemaDB;
import database.GestionDB;

import java.sql.SQLException;
import java.sql.Statement;

public class Empleados {

    public void InsertarEmpleados(String nombre, String apellido, String correo){
        try {
            Statement statement;
            statement = GestionDB.getConection().createStatement();
            int rows = statement.executeUpdate(String.format("INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s')",
                        EsquemaDB.EMPLEADO_TAB, EsquemaDB.EMPLEADO_NOMBRE, EsquemaDB.EMPLEADO_APELLIDO, EsquemaDB.EMPLEADO_CORREO,
                        nombre,apellido,correo));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }

