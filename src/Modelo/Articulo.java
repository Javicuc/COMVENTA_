/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Javicuc
 */
public class Articulo {
    
    private int ID_Articulo;
    private String Nombre;
    private String Descripcion;
    private double Costo;
    private Date Caducidad;
    private String Codigo;
    private int FK_Categoria;
    private int FK_Proveedor;

    public Articulo(int id, String nombre, String descripcion, double costo, Date caducidad, String codigo, int fk_categoria, int fk_proveedor) {
        this.ID_Articulo  = id;
        this.Nombre       = nombre;
        this.Descripcion  = descripcion;
        this.Costo        = costo;
        this.Caducidad    = caducidad;
        this.Codigo       = codigo;
        this.FK_Categoria = fk_categoria;
        this.FK_Proveedor = fk_proveedor;
    }

    public Articulo(String nombre, String descripcion, double costo, Date caducidad, String codigo, int fk_categoria, int fk_proveedor) {
        this.Nombre       = nombre;
        this.Descripcion  = descripcion;
        this.Costo        = costo;
        this.Caducidad    = caducidad;
        this.Codigo       = codigo;
        this.FK_Categoria = fk_categoria;
        this.FK_Proveedor = fk_proveedor;
    }

    public Articulo() {  
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.ID_Articulo;
        hash = 73 * hash + Objects.hashCode(this.Nombre);
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
        final Articulo other = (Articulo) obj;
        if (this.ID_Articulo != other.ID_Articulo) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articulo{" + "ID_Articulo=" + ID_Articulo + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Costo=" + Costo + ", Caducidad=" + Caducidad + ", Codigo=" + Codigo + ", FK_Categoria=" + FK_Categoria + ", FK_Proveedor=" + FK_Proveedor + '}';
    }

    /**
     * @return the ID_Articulo
     */
    public int getID_Articulo() {
        return ID_Articulo;
    }

    /**
     * @param ID_Articulo the ID_Articulo to set
     */
    public void setID_Articulo(int ID_Articulo) {
        this.ID_Articulo = ID_Articulo;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Costo
     */
    public double getCosto() {
        return Costo;
    }

    /**
     * @param Costo the Costo to set
     */
    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    /**
     * @return the Caducidad
     */
    public Date getCaducidad() {
        return Caducidad;
    }

    /**
     * @param Caducidad the Caducidad to set
     */
    public void setCaducidad(Date Caducidad) {
        this.Caducidad = Caducidad;
    }

    /**
     * @return the FK_Categoria
     */
    public int getFK_Categoria() {
        return FK_Categoria;
    }

    /**
     * @param FK_Categoria the FK_Categoria to set
     */
    public void setFK_Categoria(int FK_Categoria) {
        this.FK_Categoria = FK_Categoria;
    }

    /**
     * @return the Codigo
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
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
