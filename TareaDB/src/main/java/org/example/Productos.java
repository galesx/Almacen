package org.example;

import database.EsquemaDB;
import database.GestionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Productos {
    public static void InsertarProductos(String nombre, String descripcion, int cantidad, int precio) {
        try {

            PreparedStatement preparedStatement = GestionDB.getConection().prepareStatement(String.format(
                    "INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                    EsquemaDB.PRODUCT_TAB, EsquemaDB.PRODUCT_NOMBRE, EsquemaDB.PRODUCT_DESCRIPCION,
                    EsquemaDB.PRODUCT_CANTIDAD, EsquemaDB.PRODUCT_PRECIO));
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, descripcion);
            preparedStatement.setInt(3, cantidad);
            preparedStatement.setInt(4, precio);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar datos en la base de datos: " + e.getMessage());
        }
    }
}
