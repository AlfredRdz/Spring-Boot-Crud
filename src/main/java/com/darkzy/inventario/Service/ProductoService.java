package com.darkzy.inventario.Service;

import com.darkzy.inventario.Model.Producto;
import com.darkzy.inventario.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public Producto obtenerProductoById(Integer id_producto) {
        Optional<Producto> optional = productoRepository.findById(id_producto);
        Producto producto = null;
        if (optional.isPresent()) {
            producto = optional.get();
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
        return producto;
    }

    public void eliminarProducto(Integer id_producto) {
        productoRepository.deleteById(id_producto);
    }
}
