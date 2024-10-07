/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class Persona {
    int persona_id;
    String persona_nombre;
    String persona_apellido;

    public Persona(int persona_id, String persona_nombre, String persona_apellido) {
        this.persona_id = persona_id;
        this.persona_nombre = persona_nombre;
        this.persona_apellido = persona_apellido;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public String getPersona_nombre() {
        return persona_nombre;
    }

    public void setPersona_nombre(String persona_nombre) {
        this.persona_nombre = persona_nombre;
    }

    public String getPersona_apellido() {
        return persona_apellido;
    }

    public void setPersona_apellido(String persona_apellido) {
        this.persona_apellido = persona_apellido;
    }
    
}
