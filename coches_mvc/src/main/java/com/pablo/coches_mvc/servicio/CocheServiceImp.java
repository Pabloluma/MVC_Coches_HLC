package com.pablo.coches_mvc.servicio;

import com.pablo.coches_mvc.entidades.Coche;
import com.pablo.coches_mvc.repositorio.CocheRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
//Se desarrollan las funcionalidades de los metdos
@Service
public class CocheServiceImp implements CocheService {

//   Se inicializa el contructor en lugar de poner @Autowired
    private CocheRepositorio cocheRepositorio;

    public CocheServiceImp(CocheRepositorio cocheRepositorio) {
        this.cocheRepositorio = cocheRepositorio;
    }

    @Override
    public Iterable<Coche> listaCoches() {
        return cocheRepositorio.findAll();
    }

    @Override
    public boolean guardarCoche(Coche coche) {
        int anioActual = Year.now().getValue();
        if (coche.getAnio() < 1990 || coche.getAnio() > anioActual) {
            return false;
        } else {
            cocheRepositorio.save(coche);
            return true;
        }
    }

    @Override
    public Coche obtenerPorId(int id) {
        return cocheRepositorio.findById(id).orElseThrow();
    }

    @Override
    public void eliminarCoche(int id) {
        cocheRepositorio.deleteById(id);
    }
}
