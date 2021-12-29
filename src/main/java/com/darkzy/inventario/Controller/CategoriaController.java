package com.darkzy.inventario.Controller;

import com.darkzy.inventario.Model.Categoria;
import com.darkzy.inventario.Repository.CategoriaRepository;
import com.darkzy.inventario.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("listaCategorias", categoriaService.obtenerCategorias());
        return "categorias";
    }

    @GetMapping("/categorias/nuevo")
    public String mostrarFormularioCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria_formulario";
    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }
}
