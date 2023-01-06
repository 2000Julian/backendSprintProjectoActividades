package com.actividades.empresa.Services;

import com.actividades.empresa.Entities.Actividad;

import java.util.List;
import java.util.Optional;

public interface ActividadService {

    public List<Actividad> findAll();

    public Optional<Actividad> findById(Long id);

    public Actividad save(Actividad actividad);

    public void deleteById(Long id);
}
