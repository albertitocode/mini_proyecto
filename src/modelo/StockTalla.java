/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hgust
 */
public class StockTalla {
    int stock_id;
    String stock_talla;
    int stock;

    public StockTalla(int stock_id, String stock_talla, int stock) {
        this.stock_id = stock_id;
        this.stock_talla = stock_talla;
        this.stock = stock;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_talla() {
        return stock_talla;
    }

    public void setStock_talla(String stock_talla) {
        this.stock_talla = stock_talla;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
