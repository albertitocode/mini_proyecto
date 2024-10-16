/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class Ropa {
    int rp_id;
    String rp_nombre;
    String rp_marca;
    String rp_descripcion;
    String rp_color;
    String rp_categoria;
    public Ropa(int rp_id, String rp_nombre, String rp_marca, String rp_descripcion, String rp_color, String rp_categoria) {
        this.rp_id = rp_id;
        this.rp_nombre = rp_nombre;
        this.rp_marca = rp_marca;
        this.rp_descripcion = rp_descripcion;
        this.rp_color = rp_color;
        this.rp_categoria = rp_categoria;
    }

    public Ropa() {
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

    public void setRp_categoria( String rp_categoria) {
        this.rp_categoria = rp_categoria;
    }
    

}