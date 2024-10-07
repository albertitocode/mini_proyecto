/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author hgust
 */
public interface Crud <U>{
    public List<U> listar();
    public int setAgregar(U us);
    public int setActualizar(U us);
    public int setEliminar(int us);
}
