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
    private int FK_Categoria;

    public DetallePedido(int fk_pedido, int fk_articulo, int cantidad, double costo, int fk_categoria) {
    }
    public DetallePedido(){
        
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "FK_Pedido=" + FK_Pedido + ", FK_Articulo=" + FK_Articulo + ", Cantidad=" + Cantidad + ", Costo=" + Costo + ", FK_Categoria=" + FK_Categoria + '}';
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

    /**
     * @return the FK_Categoria
     */
    public int getFK_Categoria() {
        return FK_Categoria;
    }

    /**
     * @param FK_Categoria the FK_Categoria to set
     */
    public void setFK_Categoria(int FK_Categoria) {
        this.FK_Categoria = FK_Categoria;
    }
}
