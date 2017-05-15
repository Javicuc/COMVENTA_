/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Javicuc
 */
public class DetallePedido {
    
    private int FK_Pedido;
    private int FK_Articulo;
    private int Cantidad;
    private double Costo;

    public DetallePedido() {
    }

    public DetallePedido(int FK_Pedido, int FK_Articulo, int Cantidad, double Costo) {
        this.FK_Pedido = FK_Pedido;
        this.FK_Articulo = FK_Articulo;
        this.Cantidad = Cantidad;
        this.Costo = Costo;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "FK_Pedido=" + FK_Pedido + ", FK_Articulo=" + FK_Articulo + ", Cantidad=" + Cantidad + ", Costo=" + Costo + '}';
    }

    /**
     * @return the FK_Pedido
     */
    public int getFK_Pedido() {
        return FK_Pedido;
    }

    /**
     * @param FK_Pedido the FK_Pedido to set
     */
    public void setFK_Pedido(int FK_Pedido) {
        this.FK_Pedido = FK_Pedido;
    }

    /**
     * @return the FK_Articulo
     */
    public int getFK_Articulo() {
        return FK_Articulo;
    }

    /**
     * @param FK_Articulo the FK_Articulo to set
     */
    public void setFK_Articulo(int FK_Articulo) {
        this.FK_Articulo = FK_Articulo;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
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
}
