package com.actividades.empresa.Entities;
import lombok.Data;
import javax.persistence.*;



@Data
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id_empleado;

    @Column( name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column( name = "apellidos", length = 60, nullable = false)
    private String apellidos;

    @Column( name = "correo", length = 60, nullable = false)
    private String correo;

    @Column(name = "num_identificacion", length = 60, nullable = false)
    private String num_identificacion;


}
