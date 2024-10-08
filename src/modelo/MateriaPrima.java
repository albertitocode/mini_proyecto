/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class MateriaPrima {
    int materia_id;
    String materia_nombre;
    int materia_stock;

    public MateriaPrima(int materia_id, String materia_nombre,int materia_stock ) {
        this.materia_id = materia_id;
        this.materia_nombre = materia_nombre;
        this.materia_stock = materia_stock;
        
    }

    public MateriaPrima() {
    }

    public int getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(int materia_id) {
        this.materia_id = materia_id;
    }

    public int getMateria_stock() {
        return materia_stock;
    }

    public void setMateria_stock(int materia_stock) {
        this.materia_stock = materia_stock;
    }

    public String getMateria_nombre() {
        return materia_nombre;
    }

    public void setMateria_nombre(String materia_nombre) {
        this.materia_nombre = materia_nombre;
    }
    
}
