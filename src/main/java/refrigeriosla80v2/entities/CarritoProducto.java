/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refrigeriosla80v2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_carrito_producto")
public class CarritoProducto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito_producto")
    private int idCarritoProducto;
    
    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito idCarrito;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos idProducto;
    
    private int cantidad;
    
    private double total;
    
    public CarritoProducto(){}

    public int getIdCarritoProducto() {
        return idCarritoProducto;
    }

    public void setIdCarritoProducto(int idCarritoProducto) {
        this.idCarritoProducto = idCarritoProducto;
    }

    public Carrito getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Carrito idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public double calcularTotal(){
        return this.cantidad * this.idProducto.getPrecio();
    }
}
