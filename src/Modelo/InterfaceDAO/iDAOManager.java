/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.InterfaceDAO;

import Modelo.DAO.*;

/**
 *
 * @author Javicuc
 */
public interface iDAOManager {
    
    AccesoDAO getAccesoDAO();
    ArticuloDAO getArticuloDAO();
    CategoriaDAO getCategoriaDAO();
    ClienteDAO getClienteDAO();
    CompraDAO getCompraDAO();
    DetalleCompraDAO getDetalleCompraDAO();
    DetallePedidoDAO getDetallePedidoDAO();
    EmpleadoDAO getEmpleadoDAO();
    JornadasTrabajoDAO getJornadasTrabajoDAO();
    PedidoDAO getPedidoDAO();
    ProveedorDAO getProveedorDAO();
    
}
