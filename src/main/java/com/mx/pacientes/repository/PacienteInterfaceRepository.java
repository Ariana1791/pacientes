package com.mx.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.pacientes.model.Paciente;

public interface PacienteInterfaceRepository extends JpaRepository<Paciente, Integer>{

     Paciente findByTelefono(long  telefono);
}
