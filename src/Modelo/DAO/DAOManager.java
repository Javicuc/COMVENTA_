/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.InterfaceDAO.iDAOManager;
import SQL.BD_Conexion;
import java.sql.Connection;
import Modelo.DAO.*;

/**
 *
 * @author Javicuc
 */
public class DAOManager implements iDAOManager{

    private Connection con = null;
    private AccesoDAO acceso = null;
    private ArticuloDAO articulo = null;
    private CategoriaDAO categoria = null;
    private CompraDAO compra = null;
    private ClienteDAO cliente = null;
    private DetalleCompraDAO detallecompra = null;
    private DetallePedidoDAO detallepedido = null;
    private EmpleadoDAO empleado = null;
    private JornadasTrabajoDAO jornadastrabajo = null;
    private PedidoDAO pedido = null;
    private ProveedorDAO proveedor = null;
            
    public DAOManager(){
        this.con = BD_Conexion.getInstance();
    }
    
    @Override
    public AccesoDAO getAccesoDAO() {
        if(acceso == null)
            acceso = new AccesoDAO(con);
        return acceso;
    }

    @Override
    public ArticuloDAO getArticuloDAO() {
        if(articulo == null)
            articulo = new ArticuloDAO(con);
        return articulo;
    }

    @Override
    public CategoriaDAO getCategoriaDAO() {
        if(categoria == null)
            categoria = new CategoriaDAO(con);
        return categoria;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        if(cliente == null)
            cliente = new ClienteDAO(con);
        return cliente;
    }

    @Override
    public CompraDAO getCompraDAO() {
        if(compra == null)
            compra = new CompraDAO(con);
        return compra;
    }

    @Override
    public DetalleCompraDAO getDetalleCompraDAO() {
        if(detallecompra == null)
            detallecompra = new DetalleCompraDAO(con);
        return detallecompra;
    }

    @Override
    public DetallePedidoDAO getDetallePedidoDAO() {
        if(detallepedido == null)
            detallepedido = new DetallePedidoDAO(con);
        return detallepedido;
    }

    @Override
    public EmpleadoDAO getEmpleadoDAO() {
        if(empleado == null)
            empleado = new EmpleadoDAO(con);
        return empleado;
    }

    @Override
    public JornadasTrabajoDAO getJornadasTrabajoDAO() {
        if (jornadastrabajo == null)
            jornadastrabajo = new JornadasTrabajoDAO(con);
        return jornadastrabajo;
    }

    @Override
    public PedidoDAO getPedidoDAO() {
        if(pedido == null)
            pedido = new PedidoDAO(con);
        return pedido;
    }

    @Override
    public ProveedorDAO getProveedorDAO() {
        if(proveedor == null)
            proveedor = new ProveedorDAO(con);
        return proveedor;
    }
   
}
