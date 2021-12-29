package com.darkzy.inventario.Model;

import javax.persistence.*;

@Entity
@Table(name = "producto_detalles")
public class ProductoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_productoDetalle;
    @Column(length = 45, nullable = false)
    private String nombre;
    @Column(length = 45, nullable = false)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;

    public ProductoDetalle(Integer id_productoDetalle, String nombre, String valor, Producto producto) {
        this.id_productoDetalle = id_productoDetalle;
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    public ProductoDetalle(String nombre, String valor, Producto producto) {
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    public ProductoDetalle() {

    }

    public Integer getId_productoDetalle() {
        return id_productoDetalle;
    }

    public void setId_productoDetalle(Integer id_productoDetalle) {
        this.id_productoDetalle = id_productoDetalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", valor='" + valor;
    }
}
