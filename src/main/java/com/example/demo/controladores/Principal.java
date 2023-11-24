package com.example.demo.controladores;

import com.example.demo.modelo.EntradaMiel;
import com.example.demo.repositorios.RepositorioEntradas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class Principal {
    @Autowired
    RepositorioEntradas repo;

    //Método principal
    @GetMapping({"/", "/index", "/index.html"})
    public String paginaInicial(Model model){
        model.addAttribute("listaEntradas", repo.findAll());

        return "index";
    }

    @GetMapping("/ubicacion")
    public String paginaUbicacion(Model model){
        return "ubicacion";
    }

    //Este va a ser el listado con las entradas para tener enlaces a modificar y eliminar
    @GetMapping("/entradas")
    public String listarEntradas(Model model){
        //Añado la lista completa de entradas para que la vista las muestre
        model.addAttribute("lista", repo.findAll());
        return "listadocrud";
    }
    @GetMapping("/entradas/eliminar/{id}")
    public String eliminar(@PathVariable long id){
        repo.deleteById(id);
        return "redirect:/entradas";
    }

    @GetMapping("/entradas/crear")
    public String crearFormulario(Model model){
        //Creo una entrada de miel vacía para pasarla al formulario
        model.addAttribute("entrada", new EntradaMiel());

        return "formulario";
    }

    @PostMapping("/entradas/crear/submit")
    public String guardarEntrada(@ModelAttribute("entrada") EntradaMiel entrada){
        repo.save(entrada);
        return "redirect:/entradas/crear";
    }

    @GetMapping("/entradas/modificar/{id}")
    public String editarEntrada(@PathVariable long id, Model model) {
        EntradaMiel entrada=repo.findById(id);
        model.addAttribute("entrada", entrada);
        return "formulario";
    }

    @PostMapping("/entradas/modificar/submit")
    public String modificarEntrada(@ModelAttribute("entrada") EntradaMiel entrada){
        repo.save(entrada);
        return "redirect:/entradas";
    }

}
