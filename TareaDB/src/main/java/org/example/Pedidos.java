package org.example;

import database.EsquemaDB;
import database.GestionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Pedidos {

    public static void IngresarPedido(int id) {
        try {
            String descripcion = "";
            int precio = 0;

            PreparedStatement selectStatement = GestionDB.getConection().prepareStatement(
                    String.format("SELECT * FROM %s WHERE %s IN (?)", EsquemaDB.PRODUCT_TAB,EsquemaDB.PRODUCT_ID));
            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                descripcion = resultSet.getString(EsquemaDB.PRODUCT_DESCRIPCION);
                precio = resultSet.getInt(EsquemaDB.PRODUCT_PRECIO);
            }


            PreparedStatement insertStatement = GestionDB.getConection().prepareStatement(
                    String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)",
                            EsquemaDB.PEDIDO_TAB, EsquemaDB.PEDIDO_DESCRIP, EsquemaDB.PEDIDO_PRECIO,EsquemaDB.PEDIDO_ID_PRODUC));
            insertStatement.setString(1, descripcion);
            insertStatement.setInt(2, precio);
            insertStatement.setInt(3,id);
            int rows = insertStatement.executeUpdate();


            resultSet.close();
            selectStatement.close();
            insertStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al ingresar pedido: " + e.getMessage());
        }
    }
}