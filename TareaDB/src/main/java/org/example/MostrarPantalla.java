package org.example;

import database.EsquemaDB;
import database.GestionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarPantalla {

    public static void MostrarEmpleados(){
        PreparedStatement selectStatement;
        try {
            String nombre = "";
            String apellido = "";
            selectStatement = GestionDB.getConection().prepareStatement(
                    String.format("SELECT * FROM %s", EsquemaDB.EMPLEADO_TAB));
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                nombre = resultSet.getString(EsquemaDB.EMPLEADO_NOMBRE);
                apellido = resultSet.getString(EsquemaDB.EMPLEADO_APELLIDO);
                System.out.printf("%s %s %n",nombre,apellido);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void MostrarPedidos(){
        PreparedStatement selectStatement;
        try {
            String nombre = "";
            int id = 0;
            selectStatement = GestionDB.getConection().prepareStatement(
                    String.format("SELECT * FROM %s INNER JOIN %s WHERE %s = %s", EsquemaDB.PEDIDO_TAB,EsquemaDB.PRODUCT_TAB,
                            EsquemaDB.PEDIDO_ID_PRODUC,EsquemaDB.PRODUCT_ID));
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                nombre = resultSet.getString(EsquemaDB.PRODUCT_NOMBRE);
                id = resultSet.getInt(EsquemaDB.PEDIDO_ID_PRODUC);
                System.out.printf("pedido %s: %s %n",id,nombre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void MostrarInferior(){
        PreparedStatement selectStatement;
        try {
            String nombre = "";
            int precio = 0;
            selectStatement = GestionDB.getConection().prepareStatement(
                    String.format("SELECT * FROM %s WHERE %s<600", EsquemaDB.PRODUCT_TAB,EsquemaDB.PRODUCT_PRECIO));
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                nombre = resultSet.getString(EsquemaDB.PRODUCT_NOMBRE);
                precio = resultSet.getInt(EsquemaDB.PRODUCT_PRECIO);
                System.out.printf("%s - valor: %s %n",nombre,precio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
