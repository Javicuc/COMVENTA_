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
public class DetalleCompra {
    private int FK_Compra;
    private int FK_Articulo;
    private int NoArticulo;
    private int Cantidad;
    private double Importe;
    private int FK_Empleado;
    private int FK_Cliente;

    public DetalleCompra(int fk_compra, int fk_articulo, int noArticulo, int cantidad, double importe, int fk_empleado, int fk_cliente) {
    
    }
    public DetalleCompra(){
        
    }

    @Override
    public String toString() {
        return "DetalleCompra{" + "FK_Compra=" + FK_Compra + ", FK_Articulo=" + FK_Articulo + ", NoArticulo=" + NoArticulo + ", Cantidad=" + Cantidad + ", Importe=" + Importe + ", FK_Empleado=" + FK_Empleado + ", FK_Cliente=" + FK_Cliente + '}';
    }

    /**
     * @return the FK_Compra
     */
    public int getFK_Compra() {
        return FK_Compra;
    }

    /**
     * @param FK_Compra the FK_Compra to set
     */
    public void setFK_Compra(int FK_Compra) {
        this.FK_Compra = FK_Compra;
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
     * @return the NoArticulo
     */
    public int getNoArticulo() {
        return NoArticulo;
    }

    /**
     * @param NoArticulo the NoArticulo to set
     */
    public void setNoArticulo(int NoArticulo) {
        this.NoArticulo = NoArticulo;
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
     * @return the Importe
     */
    public double getImporte() {
        return Importe;
    }

    /**
     * @param Importe the Importe to set
     */
    public void setImporte(double Importe) {
        this.Importe = Importe;
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
     * @return the FK_Cliente
     */
    public int getFK_Cliente() {
        return FK_Cliente;
    }

    /**
     * @param FK_Cliente the FK_Cliente to set
     */
    public void setFK_Cliente(int FK_Cliente) {
        this.FK_Cliente = FK_Cliente;
    }
    
}
