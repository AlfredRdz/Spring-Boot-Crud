package com.darkzy.inventario.Controller;

import com.darkzy.inventario.Model.Categoria;
import com.darkzy.inventario.Model.Producto;
import com.darkzy.inventario.Service.CategoriaService;
import com.darkzy.inventario.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("listaProductos", productoService.obtenerProductos());
        return "productos";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioProducto(Model model) {
        List<Categoria> categoriaList = categoriaService.obtenerCategorias();

        model.addAttribute("producto", new Producto());
        model.addAttribute("listaCategorias", categoriaList);
        return "producto_formulario";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto, HttpServletRequest request) {
        String[] detalleId = request.getParameterValues("detallesId");
        String[] detalleNombres = request.getParameterValues("detallesNombre");
        String[] detalleValor = request.getParameterValues("detallesValor");

        for (int i = 0; i < detalleNombres.length; i++) {
            if (detalleId != null && detalleId.length > 0) {
                producto.setProductoDetalles(Integer.valueOf(detalleId[i]), detalleNombres[i], detalleValor[i]);
            } else {
                producto.añadirDetalles(detalleNombres[i], detalleValor[i]);
            }
        }

        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id_producto}")
    public String mostrarFormularioEditarProducto(@PathVariable("id_producto") Integer id_producto, Model model) {
        Producto producto = productoService.obtenerProductoById(id_producto);
        model.addAttribute("producto", producto);

        List<Categoria> categoriaList = categoriaService.obtenerCategorias();

        model.addAttribute("listaCategorias", categoriaList);

        return "producto_formulario";
    }

    @GetMapping("/productos/eliminar/{id_producto}")
    public String eliminarProducto(@PathVariable("id_producto") Integer id_producto) {
        productoService.eliminarProducto(id_producto);
        return "redirect:/productos";
    }
}
