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
public class Empleado {
    private int ID_Empleado;
    private String Nombre;
    private String Apellidos;
    private String Telefono;

    public Empleado(int id, String nombre, String apellidos, String telefono) {
        this.ID_Empleado = id;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Telefono = telefono;
    }
    
    public Empleado(){
        this("","","");
    }

    public Empleado(String Nombre, String Apellidos, String Telefono) {
        this.ID_Empleado = 0;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.ID_Empleado;
        hash = 79 * hash + Objects.hashCode(this.Nombre);
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
        final Empleado other = (Empleado) obj;
        if (this.ID_Empleado != other.ID_Empleado) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ID_Empleado + " : " + Nombre;
    }

    /**
     * @return the ID_Empleado
     */
    public int getID_Empleado() {
        return ID_Empleado;
    }

    /**
     * @param ID_Empleado the ID_Empleado to set
     */
    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
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
}
