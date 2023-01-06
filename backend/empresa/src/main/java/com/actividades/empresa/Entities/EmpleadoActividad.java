package com.actividades.empresa.Entities;

import javax.persistence.*;


@Entity
@Table(name = "empleadoActividad")
public class EmpleadoActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_empleado")
    private Long id_empleado;

    @Column(name = "id_actividad")
    private Long id_actividad;

    public EmpleadoActividad() {
    }

    public EmpleadoActividad(Long id, Long id_empleado, Long id_actividad) {
        this.id = id;
        this.id_empleado = id_empleado;
        this.id_actividad = id_actividad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Long getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(Long id_actividad) {
        this.id_actividad = id_actividad;
    }
}
