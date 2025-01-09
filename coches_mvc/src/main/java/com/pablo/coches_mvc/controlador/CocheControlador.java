package com.pablo.coches_mvc.controlador;

import com.pablo.coches_mvc.entidades.Coche;
import com.pablo.coches_mvc.servicio.CocheServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CocheControlador {
    @Autowired
    CocheServicio cocheServicio;

    @GetMapping("/")
    public String getCoches(Model model) {
        Iterable<Coche> listar = cocheServicio.listaCoches();
        model.addAttribute("listaCoches", listar);
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/coche/nuevo")
    public String nuevoCoche(Model model) {
        Coche coche = new Coche();
        model.addAttribute("coche", coche);
        return "formulario";
    }

    @PostMapping("/coche")
    public String guardarCoche(@ModelAttribute("coche") Coche coche) {
        if (cocheServicio.guardarCoche(coche)) {
            return "redirect:/";
        } else {
            return "redirect:/error";
        }
    }

    @GetMapping("/coche/editar/{id}")
    public String mostrarformularioEditarCoche(@PathVariable int id, Model model) {
        Coche coche = cocheServicio.obtenerPorId(id);
        model.addAttribute("coche", coche);
        return "formulario";
    }

    @PostMapping("/coche/eliminar/{id}")
    public String mostrarformularioEliminarCoche(@PathVariable int id, Model model) {
        Coche coche = cocheServicio.obtenerPorId(id);
        model.addAttribute("coche", coche);
        return "formularioEliminar";
    }

    @PostMapping("/coche/eliminado/{id}")
    public String eliminadoCoche(@PathVariable int id) {
        cocheServicio.eliminarCoche(id);
        return "redirect:/";
    }


}
