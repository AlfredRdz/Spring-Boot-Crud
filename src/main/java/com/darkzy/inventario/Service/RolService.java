package com.darkzy.inventario.Service;

import com.darkzy.inventario.Model.Rol;
import com.darkzy.inventario.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerRoles() {
        return rolRepository.findAll();
    }

    public void guardarRol(Rol rol) {
        rolRepository.save(rol);
    }
}
