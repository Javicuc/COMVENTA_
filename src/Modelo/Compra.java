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
public class Compra {
    private int ID_Compra;
    private Date Fecha;

    public Compra(int id, Date fecha) {
        
    }
    public Compra(){
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.ID_Compra;
        hash = 47 * hash + Objects.hashCode(this.Fecha);
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
        final Compra other = (Compra) obj;
        if (this.ID_Compra != other.ID_Compra) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "ID_Compra=" + ID_Compra + ", Fecha=" + Fecha + '}';
    }

    /**
     * @return the ID_Compra
     */
    public int getID_Compra() {
        return ID_Compra;
    }

    /**
     * @param ID_Compra the ID_Compra to set
     */
    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
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
}
