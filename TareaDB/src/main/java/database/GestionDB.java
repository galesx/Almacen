package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionDB {

    static Connection connection;

    private static void crearConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:mysql://%s/%s",EsquemaDB.HOST,EsquemaDB.DB_NAME);
            connection = DriverManager.getConnection(url,"root","");
        } catch (SQLException | ClassNotFoundException | RuntimeException e) {
            System.out.println("algo ha salido mal con la conexion");
        }
    }

    public static Connection getConection(){

        if (connection == null){
            crearConexion();
        }
        return connection;
    }

}
