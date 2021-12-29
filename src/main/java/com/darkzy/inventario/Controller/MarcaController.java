package com.darkzy.inventario.Controller;

import com.darkzy.inventario.Model.Categoria;
import com.darkzy.inventario.Model.Marca;
import com.darkzy.inventario.Service.CategoriaService;
import com.darkzy.inventario.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MarcaController {
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/marcas")
    public String listarMarcas(Model model) {
        model.addAttribute("listaMarcas", marcaService.obtenerMarcas());
        return "marcas";
    }

    @GetMapping("/marcas/nuevo")
    public String mostrarFormularioMarca(Model model) {
        List<Categoria> categoriaList = categoriaService.obtenerCategorias();

        model.addAttribute("listaCategorias", categoriaList);
        model.addAttribute("marca", new Marca());
        return "marcas_formulario";
    }

    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca) {
        marcaService.guardarMarca(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/marcas/editar/{id_marca}")
    public String mostrarFormularioEditarMarca(@PathVariable("id_marca") Integer id_marca, Model model) {
        List<Categoria> categoriaList = categoriaService.obtenerCategorias();
        Marca marca = marcaService.obtenerMarcaById(id_marca);

        model.addAttribute("listaCategorias", categoriaList);
        model.addAttribute("marca", marca);
        return "marcas_formulario";
    }

    @GetMapping("/marcas/eliminar/{id_marca}")
    public String eliminarMarca(@PathVariable("id_marca") Integer id_marca) {
        marcaService.eliminarMarca(id_marca);
        return "redirect:/marcas";
    }
}
