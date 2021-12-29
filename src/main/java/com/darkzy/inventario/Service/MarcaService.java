package com.darkzy.inventario.Service;

import com.darkzy.inventario.Model.Marca;
import com.darkzy.inventario.Repository.CategoriaRepository;
import com.darkzy.inventario.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Marca> obtenerMarcas() {
        return marcaRepository.findAll();
    }

    public void guardarMarca(Marca marca) {
        marcaRepository.save(marca);
    }

    public Marca obtenerMarcaById(Integer id_marca) {
        Optional<Marca> optional = marcaRepository.findById(id_marca);
        Marca marca = null;

        if (optional.isPresent()) {
            marca = optional.get();
        } else {
            throw new RuntimeException("Marca no encontrada");
        }
        return marca;
    }

    public void eliminarMarca(Integer id_marca) {
        marcaRepository.deleteById(id_marca);
    }
}
