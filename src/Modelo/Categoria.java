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
public class Categoria {
    private int ID_CategoriaArticulo;
    private String Nombre;

    public Categoria(int id, String nombre) {
    
    }
    public Categoria(){
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.ID_CategoriaArticulo;
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
        final Categoria other = (Categoria) obj;
        if (this.ID_CategoriaArticulo != other.ID_CategoriaArticulo) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "ID_CategoriaArticulo=" + ID_CategoriaArticulo + ", Nombre=" + Nombre + '}';
    }

    /**
     * @return the ID_CategoriaArticulo
     */
    public int getID_CategoriaArticulo() {
        return ID_CategoriaArticulo;
    }

    /**
     * @param ID_CategoriaArticulo the ID_CategoriaArticulo to set
     */
    public void setID_CategoriaArticulo(int ID_CategoriaArticulo) {
        this.ID_CategoriaArticulo = ID_CategoriaArticulo;
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
}
