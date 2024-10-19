/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class RopaClinica extends Ropa {
    int rpc_id;
    String rpc_estado;
    String rpc_dano;
    String rpc_usuario;
    int rpc_cliente;
    public RopaClinica() {
    }

    public RopaClinica(int rpc_id, String rpc_estado, String rpc_dano,String rpc_usuario,int rpc_cliente , int rp_id, String rp_nombre, String rp_marca, String rp_descripcion, String rp_color, String rp_categoria) {
        super(rp_id, rp_nombre, rp_marca, rp_descripcion, rp_color, rp_categoria);
        this.rpc_id = rpc_id;
        this.rpc_estado = rpc_estado;
        this.rpc_dano = rpc_dano;
        this.rpc_usuario=rpc_usuario;
        this.rpc_cliente=rpc_cliente;
    }

    public int getRpc_cliente() {
        return rpc_cliente;
    }

    public void setRpc_cliente(int rpc_cliente) {
        this.rpc_cliente = rpc_cliente;
    }
    
    public String getRpc_usuario() {
        return rpc_usuario;
    }

    public void setRpc_usuario(String rpc_usuario) {
        this.rpc_usuario = rpc_usuario;
    }
    

    public int getRpc_id() {
        return rpc_id;
    }

    public void setRpc_id(int rpc_id) {
        this.rpc_id = rpc_id;
    }

    public String getRpc_estado() {
        return rpc_estado;
    }

    public void setRpc_estado(String rpc_estado) {
        this.rpc_estado = rpc_estado;
    }

    public String getRpc_dano() {
        return rpc_dano;
    }

    public void setRpc_dano(String rpc_dano) {
        this.rpc_dano = rpc_dano;
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