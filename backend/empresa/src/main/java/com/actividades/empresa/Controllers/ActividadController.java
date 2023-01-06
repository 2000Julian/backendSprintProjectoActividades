package com.actividades.empresa.Controllers;

import com.actividades.empresa.Entities.Actividad;
import com.actividades.empresa.Excepciones.ResourceNotFoundException;
import com.actividades.empresa.Services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/actividades")
public class ActividadController {

    @Autowired
    private ActividadService repository;

    //Metodo para listar todas las actividades
    @GetMapping("/listar")
    public List<Actividad> listarActividades(){
        return repository.findAll();
    }

    //Metodo para guardar actividad
    @PostMapping("/guardar")
    public Actividad guardarActividad(@RequestBody Actividad actividad){
        return repository.save(actividad);
    }

    // Metodo para buscar una actividad por id
    @GetMapping("/{id}")
    public ResponseEntity<Actividad> obtenerActividadPorId(@PathVariable Long id){
        Actividad actividad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No hemos encontrado una actividad con el id "+ id));
        return ResponseEntity.ok(actividad);
    }

    // Metodo para actualizar una actividad
    @PutMapping("/{id}")
    public ResponseEntity<Actividad> actualizarActividad(@PathVariable Long id, @RequestBody Actividad detallesActividad){
        Actividad actividad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No hemos encontrado una actividad con el id "+ id));
        actividad.setDescripcion(detallesActividad.getDescripcion());
        actividad.setFechaEstimada(detallesActividad.getFechaEstimada());
        actividad.setEstado(detallesActividad.getEstado());

        Actividad actividadActualizada = repository.save(actividad);
        return ResponseEntity.ok(actividadActualizada);
    }

    //metodo para eliminar una actividad
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarActividad(@PathVariable Long id){
        Actividad actividad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe una actividad con el ID : " + id));

        repository.deleteById(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
