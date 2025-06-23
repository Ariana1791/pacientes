package com.mx.pacientes.service;

import java.util.List;

import com.mx.pacientes.model.Paciente;

public interface PacienteInterfaceService {
    Paciente crearPaciente(Paciente paciente);

    List<Paciente> buscarPaciente();

    Paciente actualizarPaciente(Paciente paciente, int idPaciente);

    void eliminarPaciente(int idPaciente);

}
