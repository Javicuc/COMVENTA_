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
public class JornadasTrabajo {
    private int ID_Registro;
    private int FK_Empleado;
    private Date Entrada;
    private Date Salida;

    public JornadasTrabajo(int id, int fk_empleado, Date entrada, Date salida) {
    
    }
    public JornadasTrabajo(){
    
    }

    /**
     * @return the ID_Registro
     */
    public int getID_Registro() {
        return ID_Registro;
    }

    @Override
    public String toString() {
        return "JornadasTrabajo{" + "ID_Registro=" + ID_Registro + ", FK_Empleado=" + FK_Empleado + ", Entrada=" + Entrada + ", Salida=" + Salida + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.ID_Registro;
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
        final JornadasTrabajo other = (JornadasTrabajo) obj;
        if (this.ID_Registro != other.ID_Registro) {
            return false;
        }
        return true;
    }

    /**
     * @param ID_Registro the ID_Registro to set
     */
    public void setID_Registro(int ID_Registro) {
        this.ID_Registro = ID_Registro;
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
     * @return the Entrada
     */
    public Date getEntrada() {
        return Entrada;
    }

    /**
     * @param Entrada the Entrada to set
     */
    public void setEntrada(Date Entrada) {
        this.Entrada = Entrada;
    }

    /**
     * @return the Salida
     */
    public Date getSalida() {
        return Salida;
    }

    /**
     * @param Salida the Salida to set
     */
    public void setSalida(Date Salida) {
        this.Salida = Salida;
    }
    
}
