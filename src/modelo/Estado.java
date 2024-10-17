/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class Estado {
    int estado_id;
    String estado_nombre;

    public Estado(int estado_id, String estado_nombre) {
        this.estado_id = estado_id;
        this.estado_nombre = estado_nombre;
    }

    public Estado() {
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado_nombre() {
        return estado_nombre;
    }

    public void setEstado_nombre(String estado_nombre) {
        this.estado_nombre = estado_nombre;
    }
    @Override
    public String toString() {
        return estado_nombre; // Esto se mostrará en el JComboBox
    }
}
