/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */

    public class Clientes extends Persona{
    int cliente_id;
    String cliente_email;
    String cliente_direccion;
    int cliente_telefono;

    public Clientes(int cliente_id, String cliente_email, String cliente_direccion, int cliente_telefono, int persona_id, String persona_nombre, String persona_apellido) {
        super(persona_id, persona_nombre, persona_apellido);
        this.cliente_id = cliente_id;
        this.cliente_email = cliente_email;
        this.cliente_direccion = cliente_direccion;
        this.cliente_telefono = cliente_telefono;
    }

    public Clientes() {
       
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    public String getCliente_direccion() {
        return cliente_direccion;
    }

    public void setCliente_direccion(String cliente_direccion) {
        this.cliente_direccion = cliente_direccion;
    }

    public int getCliente_telefono() {
        return cliente_telefono;
    }

    public void setCliente_telefono(int cliente_telefono) {
        this.cliente_telefono = cliente_telefono;
    }
    
    

}

