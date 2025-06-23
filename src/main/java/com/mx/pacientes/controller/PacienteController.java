package com.mx.pacientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.pacientes.model.Paciente;
import com.mx.pacientes.service.PacienteInterfaceService;

@RestController
public class PacienteController {

    @Autowired
    PacienteInterfaceService service;

   @PostMapping(value ="/crearPaciente")
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
       Paciente crear = null;
         try {
            crear = service.crearPaciente(paciente);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        
        return crear;
    }

    @GetMapping(value = "/buscarPaciente")
    public List<Paciente> buscarPaciente() {
        List<Paciente> buscar = null;
        try {
            buscar = service.buscarPaciente();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return buscar;
    }

    @PutMapping(value = "/actualizarPaciente/{idPaciente}")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente, @PathVariable int idPaciente) {
        Paciente actualizar = null;
        try {
            actualizar = service.actualizarPaciente(paciente, idPaciente);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actualizar;
    }

    @DeleteMapping(value = "/eliminarPaciente/{idPaciente}")
    public void eliminarPaciente(@PathVariable int idPaciente) {

        try {
            service.eliminarPaciente(idPaciente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
