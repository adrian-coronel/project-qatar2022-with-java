package com.footballsystem.gestion.repository;

import com.footballsystem.gestion.models.Partidos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidosRepository extends CrudRepository<Partidos, Long> {
}
