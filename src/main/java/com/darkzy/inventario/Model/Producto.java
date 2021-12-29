package com.darkzy.inventario.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "producto" )
public class Producto {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    @Column(length = 128, nullable = false, unique = true)
    private String nombre;
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoDetalle> productoDetalle;

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, Float precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(Integer id_producto, String nombre, Float precio, Categoria categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public void añadirDetalles(String nombre, String valor) {
        this.productoDetalle.add(new ProductoDetalle(nombre, valor, this));
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ProductoDetalle> getProductoDetalle() {
        return productoDetalle;
    }

    public void setProductoDetalle(List<ProductoDetalle> productoDetalle) {
        this.productoDetalle = productoDetalle;
    }

    public void setProductoDetalles(Integer id_producto, String nombre, String valor) {
        this.productoDetalle.add(new ProductoDetalle(id_producto, nombre, valor, this));
    }
}
