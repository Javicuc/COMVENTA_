/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author javilubz
 */
public class Ticket {
    private int ID_Compra;
    private int ID_DetalleCompra;
    private int ID_Articulo;
    private String Nombre;
    private String Descripcion;
    private int Cantidad;
    private double Precio;
    private double Importe;
    private Timestamp FechaHora;

    public Ticket() {
    }

    public Ticket(int ID_Compra,int id_detalle, int ID_Articulo, String Nombre, String Descripcion, int Cantidad, double Precio, double Importe, Timestamp FechaHora) {
        this.ID_Compra = ID_Compra;
        this.ID_Articulo = ID_Articulo;
        this.ID_DetalleCompra = id_detalle;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Importe = Importe;
        this.FechaHora = FechaHora;
    }

    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
    
    public int getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public int getID_Articulo() {
        return ID_Articulo;
    }

    public void setID_Articulo(int ID_Articulo) {
        this.ID_Articulo = ID_Articulo;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double precio) {
        this.Importe = precio * this.Cantidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Timestamp getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Timestamp FechaHora) {
        this.FechaHora = FechaHora;
    }  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.ID_DetalleCompra;
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
        final Ticket other = (Ticket) obj;
        if (this.ID_DetalleCompra != other.ID_DetalleCompra) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Ticket{" + "ID_Compra=" + ID_Compra + ", ID_DetalleCompra=" + ID_DetalleCompra + ", ID_Articulo=" + ID_Articulo + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Cantidad=" + Cantidad + ", Precio=" + Precio + ", Importe=" + Importe + ", FechaHora=" + FechaHora + '}';
    }

    
    
    public int getID_DetalleCompra() {
        return ID_DetalleCompra;
    }

    public void setID_DetalleCompra(int ID_DetalleCompra) {
        this.ID_DetalleCompra = ID_DetalleCompra;
    }
    
    
}
