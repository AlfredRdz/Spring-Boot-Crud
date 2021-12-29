package com.darkzy.inventario.Service;

import com.darkzy.inventario.Model.Categoria;
import com.darkzy.inventario.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    public void guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
}
