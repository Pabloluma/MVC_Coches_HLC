package com.pablo.coches_mvc.config;

import com.pablo.coches_mvc.entidades.Coche;
import com.pablo.coches_mvc.repositorio.CocheRepositorio;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DatosInicial {
    private final CocheRepositorio cocheRepositorio;

    public DatosInicial( CocheRepositorio cocheRepositorio) {
        this.cocheRepositorio = cocheRepositorio;
    }


    @PostConstruct
    public void inicial() {
        Coche coche = new Coche();
        coche.setMarca("VW");
        coche.setModelo("Passat");
        coche.setColor("Rojo");
        coche.setMatricula("1541ABC");
        coche.setAnio(2021);
        cocheRepositorio.save(coche);
    }
}
