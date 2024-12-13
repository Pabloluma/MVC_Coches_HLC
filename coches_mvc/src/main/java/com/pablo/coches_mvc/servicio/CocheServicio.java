package com.pablo.coches_mvc.servicio;

import com.pablo.coches_mvc.entidades.Coche;
import com.pablo.coches_mvc.repositorio.CocheRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocheServicio {
    @Autowired
    private CocheRepositorio cocheRepositorio;

    public Iterable<Coche> listaCoches(){
        return cocheRepositorio.findAll();
    }

    public void guardarCoche(Coche libro){
        cocheRepositorio.save(libro);
    }


}
