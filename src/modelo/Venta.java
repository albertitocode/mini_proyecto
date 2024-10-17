/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class Venta {
    int id_venta;
    String fecha_venta;
    int cliente_venta;
    int vendedor_ventar;
    int prenda_venta;

    public Venta() {
    }

    public Venta(int id_venta, String fecha_venta, int cliente_venta, int vendedor_ventar, int prenda_venta) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.cliente_venta = cliente_venta;
        this.vendedor_ventar = vendedor_ventar;
        this.prenda_venta = prenda_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getCliente_venta() {
        return cliente_venta;
    }

    public void setCliente_venta(int cliente_venta) {
        this.cliente_venta = cliente_venta;
    }

    public int getVendedor_ventar() {
        return vendedor_ventar;
    }

    public void setVendedor_ventar(int vendedor_ventar) {
        this.vendedor_ventar = vendedor_ventar;
    }

    public int getPrenda_venta() {
        return prenda_venta;
    }

    public void setPrenda_venta(int prenda_venta) {
        this.prenda_venta = prenda_venta;
    }
    
}
