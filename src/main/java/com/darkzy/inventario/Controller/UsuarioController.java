package com.darkzy.inventario.Controller;

import com.darkzy.inventario.Model.Rol;
import com.darkzy.inventario.Model.Usuario;
import com.darkzy.inventario.Service.RolService;
import com.darkzy.inventario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("/usuario")
    public String listarUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.obtenerUsuarios());
        return "usuario";
    }

    @GetMapping("/usuario/nuevo")
    public String mostrarFormularioUsuario(Model model) {
        List<Rol> rolList = rolService.obtenerRoles();
        model.addAttribute("listaRoles", rolList);
        model.addAttribute("usuario", new Usuario());
        return "usuario_formulario";
    }

    @PostMapping("/usuario/guardar")
    public String guardarUsuario(Usuario usuario, HttpServletRequest request) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/usuario/editar/id_usuario")
    public String mostrarFormularioUsuarioEditar(@PathVariable("id_usuario") Integer id_usuario, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioById(id_usuario);
        model.addAttribute("usuario", usuario);

        List<Rol> rolList = rolService.obtenerRoles();
        model.addAttribute("listaRoles", rolList);

        return "usuario_formulario";
    }

    @GetMapping("/usuario/eliminar/{id_usuario}")
    public String eliminarUsuario(@PathVariable("id_usuario") Integer id_usuario) {
        usuarioService.eliminarUsuario(id_usuario);
        return "redirect:/usuario";
    }
}
