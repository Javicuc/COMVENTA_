/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Objects;
/**
 *
 * @author Javicuc
 */
public class Acceso {
    private String Usuario;
    private String Clave;
    private String Tipo;

    public Acceso(int id, String usuario, String clave, String tipo) {
        
    }
    
    public Acceso(){
        this("","","");
    }

    public Acceso(String Usuario, String Clave) {
        this.Usuario = Usuario;
        this.Clave = MD5(Clave);
    }
    
    public Acceso(String Usuario, String Clave, String Tipo) {
        this.Usuario = Usuario;
        this.Clave = MD5(Clave);
        this.Tipo = Tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        return "Acceso{Usuario=" + Usuario + ", Clave=" + Clave + '}';
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
    
    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    private String MD5(String pass) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md5.digest(pass.getBytes());
            BigInteger numero = new BigInteger(1, messageDigest);
            String hashtext = numero.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}