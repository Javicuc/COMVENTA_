/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Javicuc
 */
public class Proveedor {
    private int ID_Proveedor;
    private String Nombre;
    private String Direccion;
    private String Telefono;

    public Proveedor(int id, String nombre, String direccion, String telefono) {
    
    }
    public Proveedor(){
        
    }

    public Proveedor(String Nombre, String Direccion, String Telefono) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.ID_Proveedor;
        hash = 59 * hash + Objects.hashCode(this.Nombre);
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
        final Proveedor other = (Proveedor) obj;
        if (this.ID_Proveedor != other.ID_Proveedor) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        return true;
    }

    /**
     * @return the ID_Proveedor
     */
    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    /**
     * @param ID_Proveedor the ID_Proveedor to set
     */
    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "ID_Proveedor=" + ID_Proveedor + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", Telefono=" + Telefono + '}';
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
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
}
