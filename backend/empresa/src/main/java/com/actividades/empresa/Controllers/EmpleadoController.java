package com.actividades.empresa.Controllers;

import com.actividades.empresa.Entities.Empleado;
import com.actividades.empresa.Excepciones.ResourceNotFoundException;
import com.actividades.empresa.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService repository;


    //Listar todos los empleados
    @GetMapping("/listar")
    public List<Empleado> listarEmpleados(){
        return repository.findAll();
    }

    //metodo para guardar empleado
    @PostMapping("/guardar")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return repository.save(empleado);
    }

    // Metodo para buscar un empleado por id
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No hemos encontrado un empleado con el id "+ id));
        return ResponseEntity.ok(empleado);
    }

    // Metodo para actualizar un empleado
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No hemos encontrado un empleado con el id "+ id));
        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellidos(detallesEmpleado.getApellidos());
        empleado.setCorreo(detallesEmpleado.getCorreo());
        empleado.setNum_identificacion(detallesEmpleado.getNum_identificacion());

        Empleado empleadoActualizado = repository.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    //metodo para eliminar una actividad
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        repository.deleteById(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
