package com.darkzy.inventario.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marca;
    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    @OneToMany
    @JoinColumn(name = "marca")
    private List<Categoria> categorias;

    public Marca() {
    }

    public Marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public Marca(String nombre, List<Categoria> categorias) {
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public Marca(Integer id_marca, String nombre, List<Categoria> categorias) {
        this.id_marca = id_marca;
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
