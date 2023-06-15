package com.footballsystem.gestion.service;

import com.footballsystem.gestion.models.Partidos;
import com.footballsystem.gestion.repository.PartidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidosServiceImp implements PartidosService{

    @Autowired
    PartidosRepository partidosRepository;

    @Override
    public Iterable<Partidos> getAllPartidos() {
        return partidosRepository.findAll();
    }
}
