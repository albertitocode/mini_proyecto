/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class Etiqueta {
    int etiqueta_id;
    String etiqueta_nombre;

    public Etiqueta(int etiqueta_id, String etiqueta_nombre) {
        this.etiqueta_id = etiqueta_id;
        this.etiqueta_nombre = etiqueta_nombre;
    }

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
    }

    public String getEtiqueta_nombre() {
        return etiqueta_nombre;
    }

    public void setEtiqueta_nombre(String etiqueta_nombre) {
        this.etiqueta_nombre = etiqueta_nombre;
    }
    
}
