/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class Usuarios extends Persona {
    int usuario_id;
    String usuario_email;
    String usuario_contraseña;
    int usuario_telefono;

    public Usuarios(int usuario_id, String usuario_email, String usuario_contraseña, int usuario_telefono, int persona_id, String persona_nombre, String persona_apellido) {
        super(persona_id, persona_nombre, persona_apellido);
        this.usuario_id = usuario_id;
        this.usuario_email = usuario_email;
        this.usuario_contraseña = usuario_contraseña;
        this.usuario_telefono = usuario_telefono;
    }
    public Usuarios(){
        
    }    

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public String getUsuario_contraseña() {
        return usuario_contraseña;
    }

    public void setUsuario_contraseña(String usuario_contraseña) {
        this.usuario_contraseña = usuario_contraseña;
    }

    public int getUsuario_telefono() {
        return usuario_telefono;
    }

    public void setUsuario_telefono(int usuario_telefono) {
        this.usuario_telefono = usuario_telefono;
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
