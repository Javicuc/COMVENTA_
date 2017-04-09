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
public class Acceso {
    private int ID_Empleado;
    private String Usuario;
    private String Clave;

    public Acceso(int id, String usuario, String clave) {
        
    }
    public Acceso(){
        
    }

    public Acceso(String Usuario, String Clave) {
        this.Usuario = Usuario;
        this.Clave = Clave;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.ID_Empleado;
        hash = 23 * hash + Objects.hashCode(this.Usuario);
        hash = 23 * hash + Objects.hashCode(this.Clave);
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
        final Acceso other = (Acceso) obj;
        if (this.ID_Empleado != other.ID_Empleado) {
            return false;
        }
        if (!Objects.equals(this.Usuario, other.Usuario)) {
            return false;
        }
        if (!Objects.equals(this.Clave, other.Clave)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Acceso{" + "ID_Empleado=" + ID_Empleado + ", Usuario=" + Usuario + ", Clave=" + Clave + '}';
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
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Clave
     */
    public String getClave() {
        return Clave;
    }

    /**
     * @param Clave the Clave to set
     */
    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    
}
