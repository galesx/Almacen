package org.example;

import database.GestionDB;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {
            Productos productosTab = new Productos();
            Empleados empleado = new Empleados();
            Pedidos pedidos = new Pedidos();
            MostrarPantalla.MostrarEmpleados();
            MostrarPantalla.MostrarPedidos();
            MostrarPantalla.MostrarInferior();
            Favoritos.insertarFavoritos();

            empleado.InsertarEmpleados("Juan","Garcia","juanito@hotmail.com");
            empleado.InsertarEmpleados("Pancho","panza","panchito@gmail.com");
            pedidos.IngresarPedido(302);
            pedidos.IngresarPedido(312);
            pedidos.IngresarPedido(334);

            try {
                Connection connectionDB = GestionDB.getConection();

                    URL url = new URL("https://dummyjson.com/products");
                    HttpURLConnection conneccionJSON = (HttpURLConnection) url.openConnection();
                    BufferedReader lector = new BufferedReader(new InputStreamReader(conneccionJSON.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String linea = null;
                    while ((linea = lector.readLine()) != null) {
                        sb.append(linea);
                    }

                    JSONObject response = new JSONObject(sb.toString());
                    JSONArray products = response.getJSONArray("products");

                    for (int i = 0; i < products.length(); i++) {
                        JSONObject productos = products.getJSONObject(i);
                        String nombre = productos.getString("title");
                        String descripcion = productos.getString("description");
                        int cantidad = productos.getInt("stock");
                        int precio = productos.getInt("price");
                        productosTab.InsertarProductos(nombre, descripcion, cantidad, precio);
                    }

                    connectionDB.close();

            } catch (IOException e) {
                System.out.println("Hay un error en la conexión IO: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error SQL al insertar datos: " + e.getMessage());
            }
        }


}

