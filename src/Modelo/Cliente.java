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
public class Cliente {
    private int ID_Cliente;
    private String Nombre;
    private String Apellidos;
    private String Telefono;
    private String Direccion;

    
    public Cliente(){
        
    }

    public Cliente(int ID_Cliente, String Nombre, String Apellidos, String Telefono, String Direccion) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
    }

    public Cliente(String Nombre, String Apellidos, String Telefono, String Direccion) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "ID_Cliente=" + ID_Cliente + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Telefono=" + Telefono + ", Direccion=" + Direccion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.ID_Cliente;
        hash = 23 * hash + Objects.hashCode(this.Nombre);
        hash = 23 * hash + Objects.hashCode(this.Apellidos);
        hash = 23 * hash + Objects.hashCode(this.Telefono);
        hash = 23 * hash + Objects.hashCode(this.Direccion);
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
        final Cliente other = (Cliente) obj;
        if (this.ID_Cliente != other.ID_Cliente) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellidos, other.Apellidos)) {
            return false;
        }
        if (!Objects.equals(this.Telefono, other.Telefono)) {
            return false;
        }
        if (!Objects.equals(this.Direccion, other.Direccion)) {
            return false;
        }
        return true;
    }
    
    
    
    /**
     * @return the ID_Cliente
     */
    public int getID_Cliente() {
        return ID_Cliente;
    }

    /**
     * @param ID_Cliente the ID_Cliente to set
     */
    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
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
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
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
}
