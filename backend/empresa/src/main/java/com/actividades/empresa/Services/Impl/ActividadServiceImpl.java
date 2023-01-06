package com.actividades.empresa.Services.Impl;

import com.actividades.empresa.Entities.Actividad;
import com.actividades.empresa.Repositories.ActividadRepository;
import com.actividades.empresa.Services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository repository;

    @Override
    public List<Actividad> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Actividad> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Actividad save(Actividad actividad) {
        return   this.repository.save(actividad);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
