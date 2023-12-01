package database;

public interface EsquemaDB {
    String DB_NAME = "almacen";
    String HOST = "localhost:3306";

    String PRODUCT_TAB = "productos";
    String PRODUCT_ID = "id_producto";
    String PRODUCT_NOMBRE = "nombre_producto";
    String PRODUCT_DESCRIPCION = "descripcion_producto";
    String PRODUCT_CANTIDAD = "cantidad_producto";
    String PRODUCT_PRECIO = "precio_producto";

    String EMPLEADO_TAB = "empleados";
    String EMPLEADO_NOMBRE = "nombre";
    String EMPLEADO_APELLIDO = "apellidos";
    String EMPLEADO_CORREO = "correo";

    String PEDIDO_TAB = "pedidos";
    String PEDIDO_DESCRIP = "descripcion_pedido";
    String PEDIDO_PRECIO = "precio_total";
    String PEDIDO_ID_PRODUC = "id_pedido_product";

    String FAVORIT_TAB = "pedidos_fav";
    String FAVORIT_ID = "id_fav";
    String FAVOTIT_ID_PRODUCT = "id_productos_fav";




}
