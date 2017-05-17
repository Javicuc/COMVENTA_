/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

/**
 *
 * @author Javicuc
 */
public class Tablas {
    public interface Tabla {
        String ACCESO          = "acceso";
        String ARTICULO        = "articulo";
        String CATEGORIA       = "categoria_articulo";
        String CLIENTE         = "cliente";
        String COMPRA          = "compra";
        String DETALLECOMPRA   = "detalle_compra";
        String DETALLEPEDIDO   = "detalle_pedido";
        String EMPLEADO        = "empleado";
        String JORNADASTRABAJO = "jornadas_trabajo";
        String PEDIDO          = "pedido";
        String PROVEEDOR       = "proveedor";
    }
     
    interface ColumnasAcceso{
        String ID_EMPLEADO = "FK_Empleado";
        String USUARIO     = "Usuario";
        String CLAVE       = "Clave";
        String TIPO        = "Tipo";
    }
    interface ColumnasArticulo{
        String ID_ARTICULO  = "ID_Articulo";
        String NOMBRE       = "Nombre";
        String DESCRIPCION  = "Descripcion";
        String COSTO        = "Costo";
        String CADUCIDAD    = "Caducidad";
        String CODIGO       = "Codigo";
        String FK_CATEGORIA = "FK_Categoria";
        String FK_PROVEEDOR = "FK_Proveedor";
    }
    interface ColumnasCategoria{
        String ID_CATEGORIA = "ID_CategoriaArticulo";
        String NOMBRE       = "Nombre";
    }
    interface ColumnasCliente{
        String ID_CLIENTE = "ID_Cliente";
        String NOMBRE     = "Nombre";
        String APELLIDOS  = "Apellidos";
        String TELEFONO   = "Telefono";
        String DIRECCION  = "Direccion";
    }
    interface ColumnasCompra{
        String ID_COMPRA = "ID_Compra";
        String FECHA     = "Fecha";
    }
    interface ColumnasDetalleCompra{
        String ID_DETALLECOMPRA = "ID_DetalleCompra";
        String FK_COMPRA        = "FK_Compra";
        String FK_ARTICULO      = "FK_Articulo";
        String CANTIDAD         = "Cantidad";
        String IMPORTE          = "Importe";
        String FK_EMPLEADO      = "FK_Empleado";
        String FK_CLIENTE       = "FK_Cliente";
    }
    interface ColumnasDetallePedido{
        String ID_DETALLEPEDIDO = "ID_DetallePedido";
        String FK_PEDIDO        = "FK_Pedido";
        String FK_ARTICULO      = "FK_Articulo";
        String CANTIDAD         = "Cantidad";
        String COSTO            = "Costo";
        String FK_CATEGORIA     = "FK_Categoria";
    }
    interface ColumnasEmpleado{
        String ID_EMPLEADO = "ID_Empleado";
        String NOMBRE      = "Nombre";
        String APELLIDOS   = "Apellidos";
        String TELEFONO    = "Telefono";
    }
    interface ColumnasJornadasTrabajo{
        String ID_REGISTRO = "ID_Registro";
        String FK_EMPLEADO = "FK_Empleado";
        String ENTRADA     = "Entrada";
        String SALIDA      = "Salida";
    }
    interface ColumnasPedido{
        String ID_PEDIDO = "ID_Pedido";
        String CANTIDAD  = "Cantidad";
        String FECHA     = "Fecha";
        String FK_PROVEEDOR = "FK_Proveedor";
    }
    interface ColumnasProveedor{
        String ID_PROVEEDOR = "ID_Proveedor";
        String NOMBRE       = "Nombre";
        String DIRECCION    = "Direccion";
        String TELEFONO     = "Telefono";
        String WEB          = "Web";
    }
    
    public static class COLACCESO implements ColumnasAcceso{
        
    }
    public static class COLARTICULO implements ColumnasArticulo{
        
    }
    public static class COLCATEGORIA implements ColumnasCategoria{
        
    }
    public static class COLCLIENTE implements ColumnasCliente{
        
    }
    public static class COLCOMPRA implements ColumnasCompra{
        
    }
    public static class COLDETALLECOMPRA implements ColumnasDetalleCompra{
        
    }
    public static class COLDETALLEPEDIDO implements ColumnasDetallePedido{
        
    }
    public static class COLEMPLEADO implements ColumnasEmpleado{
        
    }
    public static class COLJORNADASTRABAJO implements ColumnasJornadasTrabajo{
        
    }
    public static class COLPEDIDO implements ColumnasPedido{
        
    }
    public static class COLPROVEEDOR implements ColumnasProveedor{
        
    }

}
