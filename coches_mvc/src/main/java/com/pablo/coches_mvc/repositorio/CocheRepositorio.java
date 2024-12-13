package com.pablo.coches_mvc.repositorio;

import com.pablo.coches_mvc.entidades.Coche;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepositorio extends CrudRepository<Coche, Integer> {

}
