package com.pablo.coches_mvc.servicio;

import com.pablo.coches_mvc.entidades.Coche;

import java.time.Year;

//Se definen los metodos que nos van a hacer falta
public interface CocheService {
    Iterable<Coche> listaCoches();

    boolean guardarCoche(Coche coche);

    Coche obtenerPorId(int id);

    void eliminarCoche(int id);
}
