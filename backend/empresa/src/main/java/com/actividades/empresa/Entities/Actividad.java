package com.actividades.empresa.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "actividad")
public class Actividad {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id_actividad;

    @Column(name ="descripcion", length = 500, nullable = false)
    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaEstimada;

    @Column(name = "estado", nullable = false)
    private String estado;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleadoId;




}
