/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Javicuc
 */
public class DetalleCompra {
    
    private int ID_DetalleCompra;
    private int FK_Compra;
    private int FK_Articulo;
    private int Cantidad;
    private double Importe;
    private int FK_Empleado;
    private int FK_Cliente;

    public DetalleCompra(int ID_DetalleCompra, int FK_Compra, int FK_Articulo, int Cantidad, double Importe, int FK_Empleado, int FK_Cliente) {
        this.ID_DetalleCompra = ID_DetalleCompra;
        this.FK_Compra = FK_Compra;
        this.FK_Articulo = FK_Articulo;
        this.Cantidad = Cantidad;
        this.Importe = Importe;
        this.FK_Empleado = FK_Empleado;
        this.FK_Cliente = FK_Cliente;
    }

    public DetalleCompra(int FK_Compra, int FK_Articulo, int Cantidad, double Importe, int FK_Empleado, int FK_Cliente) {
        this.FK_Compra = FK_Compra;
        this.FK_Articulo = FK_Articulo;
        this.Cantidad = Cantidad;
        this.Importe = Importe;
        this.FK_Empleado = FK_Empleado;
        this.FK_Cliente = FK_Cliente;
    }

    public DetalleCompra() {
    }

    public DetalleCompra(int FK_Compra, int FK_Articulo, int Cantidad, double Importe) {
        this.FK_Compra = FK_Compra;
        this.FK_Articulo = FK_Articulo;
        this.Cantidad = Cantidad;
        this.Importe = Importe;
        this.FK_Empleado = 2;
        this.FK_Cliente  = 2;
    }

    

    @Override
    public String toString() {
        return ID_DetalleCompra + "Ticket: " + FK_Compra;
    }
    
    /**
     * @return the FK_Compra
     */
    public int getFK_Compra() {
        return FK_Compra;
    }

    /**
     * @param FK_Compra the FK_Compra to set
     */
    public void setFK_Compra(int FK_Compra) {
        this.FK_Compra = FK_Compra;
    }

    /**
     * @return the FK_Articulo
     */
    public int getFK_Articulo() {
        return FK_Articulo;
    }

    /**
     * @param FK_Articulo the FK_Articulo to set
     */
    public void setFK_Articulo(int FK_Articulo) {
        this.FK_Articulo = FK_Articulo;
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
     * @return the Importe
     */
    public double getImporte() {
        return Importe;
    }

    /**
     * @param Importe the Importe to set
     */
    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    /**
     * @return the FK_Empleado
     */
    public int getFK_Empleado() {
        return FK_Empleado;
    }

    /**
     * @param FK_Empleado the FK_Empleado to set
     */
    public void setFK_Empleado(int FK_Empleado) {
        this.FK_Empleado = FK_Empleado;
    }

    /**
     * @return the FK_Cliente
     */
    public int getFK_Cliente() {
        return FK_Cliente;
    }

    /**
     * @param FK_Cliente the FK_Cliente to set
     */
    public void setFK_Cliente(int FK_Cliente) {
        this.FK_Cliente = FK_Cliente;
    }

    public int getID_DetalleCompra() {
        return ID_DetalleCompra;
    }

    public void setID_DetalleCompra(int ID_DetalleCompra) {
        this.ID_DetalleCompra = ID_DetalleCompra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.ID_DetalleCompra;
        hash = 97 * hash + this.FK_Compra;
        hash = 97 * hash + this.FK_Articulo;
        hash = 97 * hash + this.Cantidad;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.Importe) ^ (Double.doubleToLongBits(this.Importe) >>> 32));
        hash = 97 * hash + this.FK_Empleado;
        hash = 97 * hash + this.FK_Cliente;
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
        final DetalleCompra other = (DetalleCompra) obj;
        if (this.ID_DetalleCompra != other.ID_DetalleCompra) {
            return false;
        }
        if (this.FK_Compra != other.FK_Compra) {
            return false;
        }
        if (this.FK_Articulo != other.FK_Articulo) {
            return false;
        }
        if (this.Cantidad != other.Cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.Importe) != Double.doubleToLongBits(other.Importe)) {
            return false;
        }
        if (this.FK_Empleado != other.FK_Empleado) {
            return false;
        }
        if (this.FK_Cliente != other.FK_Cliente) {
            return false;
        }
        return true;
    }
    
}
