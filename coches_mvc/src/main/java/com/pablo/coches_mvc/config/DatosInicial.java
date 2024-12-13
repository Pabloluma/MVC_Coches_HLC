package com.pablo.coches_mvc.config;

import com.pablo.coches_mvc.entidades.Coche;
import com.pablo.coches_mvc.repositorio.CocheRepositorio;
import com.pablo.coches_mvc.servicio.CocheServicio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatosInicial {
    @Autowired
    private CocheServicio cocheServicio;

    @PostConstruct
    public void inicial(){
        Coche coche = new Coche();
        coche.setMarca("VW");
        coche.setModelo("Passat");
        coche.setColor("Rojo");
        coche.setAnio(2021);
        cocheServicio.guardarCoche(coche);
    }
}
