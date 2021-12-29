package com.darkzy.inventario.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(length = 45, nullable = false, unique = true)
    private String email;
    @Column(length = 10, nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(String email, String password, Set<Rol> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Usuario(Integer id_usuario, String email, String password, Set<Rol> roles) {
        this.id_usuario = id_usuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public void añadirRol(Rol rol) {
        this.roles.add(rol);
    }

    public void eliminarRol(Rol rol) {
        this.roles.remove(rol);
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
