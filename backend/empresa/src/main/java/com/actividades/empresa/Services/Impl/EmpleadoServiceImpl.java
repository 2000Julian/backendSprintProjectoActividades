package com.actividades.empresa.Services.Impl;

import com.actividades.empresa.Entities.Empleado;
import com.actividades.empresa.Repositories.EmpleadoRepository;
import com.actividades.empresa.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public List<Empleado> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Empleado> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Empleado save(Empleado empleado) {
      return   this.repository.save(empleado);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
