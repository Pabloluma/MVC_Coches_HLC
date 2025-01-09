package com.pablo.coches_mvc.servicio;

import com.pablo.coches_mvc.entidades.Coche;
import com.pablo.coches_mvc.repositorio.CocheRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class CocheServicio {
    @Autowired
    private CocheRepositorio cocheRepositorio;

    public Iterable<Coche> listaCoches() {
        return cocheRepositorio.findAll();
    }

    public boolean guardarCoche(Coche coche) {
        int anioActual = Year.now().getValue();
        if (coche.getAnio() < 1990 || coche.getAnio() > anioActual) {
            return false;
        } else {
            cocheRepositorio.save(coche);
            return true;
        }
    }

    public Coche obtenerPorId(int id) {
        return cocheRepositorio.findById(id).orElseThrow();
    }

    public void eliminarCoche(int id) {
        cocheRepositorio.deleteById(id);
    }
}
