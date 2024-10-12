/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class RopaVenta extends Ropa {
    int rpv_id;
    int rpv_precio;
    int rpv_stock;

    public RopaVenta(int rpv_id,int rpv_precio, int rpv_stock, int rp_id, String rp_nombre, String rp_marca, String rp_descripcion, String rp_color, String rp_categoria) {
        super(rp_id, rp_nombre, rp_marca, rp_descripcion, rp_color, rp_categoria);
        this.rpv_id= rpv_id;
        this.rpv_precio = rpv_precio;
        this.rpv_stock = rpv_stock;
    }

    public RopaVenta() {
    }

    public int getRpv_id() {
        return rpv_id;
    }

    public void setRpv_id(int rpv_id) {
        this.rpv_id = rpv_id;
    }
    
    public int getRpv_precio() {
        return rpv_precio;
    }

    public void setRpv_precio(int rpv_precio) {
        this.rpv_precio = rpv_precio;
    }

    public int getRpv_stock() {
        return rpv_stock;
    }

    public void setRpv_stock(int rpv_stock) {
        this.rpv_stock = rpv_stock;
    }

    public int getRp_id() {
        return rp_id;
    }

    public void setRp_id(int rp_id) {
        this.rp_id = rp_id;
    }

    public String getRp_nombre() {
        return rp_nombre;
    }

    public void setRp_nombre(String rp_nombre) {
        this.rp_nombre = rp_nombre;
    }

    public String getRp_marca() {
        return rp_marca;
    }

    public void setRp_marca(String rp_marca) {
        this.rp_marca = rp_marca;
    }

    public String getRp_descripcion() {
        return rp_descripcion;
    }

    public void setRp_descripcion(String rp_descripcion) {
        this.rp_descripcion = rp_descripcion;
    }

    public String getRp_color() {
        return rp_color;
    }

    public void setRp_color(String rp_color) {
        this.rp_color = rp_color;
    }

    public String getRp_categoria() {
        return rp_categoria;
    }

    public void setRp_categoria(String rp_categoria) {
        this.rp_categoria = rp_categoria;
    }
    
}
