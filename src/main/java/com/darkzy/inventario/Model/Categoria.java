package com.darkzy.inventario.Model;

import javax.persistence.*;

@Entity
@Table( name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_categoria;
    @Column(length = 40, nullable = false, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "marca")
    private Marca marca;

    public Categoria() {
    }

    public Categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(String nombre, Marca marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    public Categoria(Integer id_categoria, String nombre, Marca marca) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
