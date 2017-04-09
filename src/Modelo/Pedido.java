/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Javicuc
 */
public class Pedido {
    private int ID_Pedido;
    private int Cantidad;
    private Date Fecha;
    private int FK_Proveedor;

    public Pedido(int id, int cantidad, Date fecha, int fk_proveedor) {
        
    }
    public Pedido(){
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.ID_Pedido;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.ID_Pedido != other.ID_Pedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "ID_Pedido=" + ID_Pedido + ", Cantidad=" + Cantidad + ", Fecha=" + Fecha + ", FK_Proveedor=" + FK_Proveedor + '}';
    }

    /**
     * @return the ID_Pedido
     */
    public int getID_Pedido() {
        return ID_Pedido;
    }

    /**
     * @param ID_Pedido the ID_Pedido to set
     */
    public void setID_Pedido(int ID_Pedido) {
        this.ID_Pedido = ID_Pedido;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return the Fecha
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the FK_Proveedor
     */
    public int getFK_Proveedor() {
        return FK_Proveedor;
    }

    /**
     * @param FK_Proveedor the FK_Proveedor to set
     */
    public void setFK_Proveedor(int FK_Proveedor) {
        this.FK_Proveedor = FK_Proveedor;
    }

}
