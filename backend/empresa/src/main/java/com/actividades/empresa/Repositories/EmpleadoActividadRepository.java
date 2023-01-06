package com.actividades.empresa.Repositories;

import com.actividades.empresa.Entities.EmpleadoActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoActividadRepository extends JpaRepository<EmpleadoActividad, Long> {
}
