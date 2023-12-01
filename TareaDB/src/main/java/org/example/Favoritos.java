package org.example;

import database.EsquemaDB;
import database.GestionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Favoritos {

    public static void insertarFavoritos(){

        try {

            int id = 0;

            PreparedStatement selectStatement = GestionDB.getConection().prepareStatement(
                    String.format("SELECT * FROM %s WHERE %s>1000", EsquemaDB.PRODUCT_TAB,EsquemaDB.PRODUCT_PRECIO));
            ResultSet resultSet = selectStatement.executeQuery();

            PreparedStatement insertStatement = null;
            while (resultSet.next()) {
                id = resultSet.getInt(EsquemaDB.PRODUCT_ID);
                insertStatement = GestionDB.getConection().prepareStatement(
                        String.format("INSERT INTO %s (%s) VALUES (?)", EsquemaDB.FAVORIT_TAB, EsquemaDB.FAVOTIT_ID_PRODUCT));
                insertStatement.setInt(1,id);
                int rows = insertStatement.executeUpdate();
            }




            resultSet.close();
            selectStatement.close();
            insertStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al ingresar Fav: " + e.getMessage());
        }
    }

}
