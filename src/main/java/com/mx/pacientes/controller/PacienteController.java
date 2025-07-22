package com.mx.pacientes.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.pacientes.model.Paciente;
import com.mx.pacientes.service.PacienteInterfaceService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class PacienteController {

    @Autowired
    PacienteInterfaceService service;

    @PostMapping(value = "/crearPaciente")
    public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente) {
        Paciente recuperado = service.buscarTelefono(paciente.getTelefono());
        if (recuperado == null) {
            service.crearPaciente(paciente);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito", "el paciente se a guardado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "el paciente ya se encuentra registrado"));
    }

    @PostMapping(value = "/buscarPaciente")
    public ResponseEntity <?> buscarPaciente(@RequestBody Paciente paciente) {
        Paciente buscar = service.buscarTelefono(paciente.getTelefono());
        if(buscar != null){
            return ResponseEntity.status(HttpStatus.OK).body(buscar);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","servicio no encontrado"));
       
    }

    @PutMapping(value = "/actualizarPaciente/{idPaciente}")
    public ResponseEntity <?> actualizarPaciente(@RequestBody Paciente paciente, @PathVariable int idPaciente) {
        boolean recuperado = service.buscarPorId(idPaciente);
        if(recuperado == true){
            service.actualizarPaciente(paciente, idPaciente);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito","el paciente se a actualizado correctamente"));
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","paciente no encontrado"));
        
    }

    @DeleteMapping(value = "/eliminarPaciente/{idPaciente}")
    public ResponseEntity <?> eliminarPaciente(@PathVariable int idPaciente) {
        boolean recuperdo = service.buscarPorId(idPaciente);
        if(recuperdo == true){
            service.eliminarPaciente(idPaciente);
         return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito","el paciente se a eliminado correctamente"));
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","paciente no encontrado"));
    }

}
