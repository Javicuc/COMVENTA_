/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author Javicuc
 */
public class Compra {
    private int ID_Compra;
    private Timestamp Fecha;

    public Compra(int ID_Compra, Timestamp Fecha) {
        this.ID_Compra = ID_Compra;
        this.Fecha = Fecha;
    }

    public Compra() {
    }

    public Compra(Timestamp Fecha) {
        this.Fecha = Fecha;
    }

    
    @Override
    public String toString() {
        return ID_Compra + " : " + Fecha;
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

    public Timestamp getFecha() {
        return Fecha;
    }

    public void setFecha(Timestamp Fecha) {
        this.Fecha = Fecha;
    }
    
}
