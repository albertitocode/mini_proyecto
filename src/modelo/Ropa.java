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
    int ropa_id;
    String ropa_nombre;
    int ropa_precio;
    int ropa_color;
    String ropa_marca;
    String ropa_descripcion;
    String ropa_categoria;
    String ropa_fecha_registro;

    public Ropa(int ropa_id, String ropa_nombre, int ropa_precio, int ropa_color, String ropa_marca, String ropa_descripcion, String ropa_categoria, String ropa_fecha_registro) {
        this.ropa_id = ropa_id;
        this.ropa_nombre = ropa_nombre;
        this.ropa_precio = ropa_precio;
        this.ropa_color = ropa_color;
        this.ropa_marca = ropa_marca;
        this.ropa_descripcion = ropa_descripcion;
        this.ropa_categoria = ropa_categoria;
        this.ropa_fecha_registro = ropa_fecha_registro;
    }

    public int getRopa_id() {
        return ropa_id;
    }

    public void setRopa_id(int ropa_id) {
        this.ropa_id = ropa_id;
    }

    public String getRopa_nombre() {
        return ropa_nombre;
    }

    public void setRopa_nombre(String ropa_nombre) {
        this.ropa_nombre = ropa_nombre;
    }

    public int getRopa_precio() {
        return ropa_precio;
    }

    public void setRopa_precio(int ropa_precio) {
        this.ropa_precio = ropa_precio;
    }

    public int getRopa_color() {
        return ropa_color;
    }

    public void setRopa_color(int ropa_color) {
        this.ropa_color = ropa_color;
    }

    public String getRopa_marca() {
        return ropa_marca;
    }

    public void setRopa_marca(String ropa_marca) {
        this.ropa_marca = ropa_marca;
    }

    public String getRopa_descripcion() {
        return ropa_descripcion;
    }

    public void setRopa_descripcion(String ropa_descripcion) {
        this.ropa_descripcion = ropa_descripcion;
    }

    public String getRopa_categoria() {
        return ropa_categoria;
    }

    public void setRopa_categoria(String ropa_categoria) {
        this.ropa_categoria = ropa_categoria;
    }

    public String getRopa_fecha_registro() {
        return ropa_fecha_registro;
    }

    public void setRopa_fecha_registro(String ropa_fecha_registro) {
        this.ropa_fecha_registro = ropa_fecha_registro;
    }
    
}
