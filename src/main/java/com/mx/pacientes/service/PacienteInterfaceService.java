package com.mx.pacientes.service;

import com.mx.pacientes.model.Paciente;

public interface PacienteInterfaceService {
    Paciente crearPaciente(Paciente paciente);

    Paciente buscarPaciente(Paciente Paciente);

    Paciente actualizarPaciente(Paciente paciente, int idPaciente);

    void eliminarPaciente(int idPaciente);

    boolean buscarPorId(int Id);
    
    Paciente buscarTelefono(long telefono);

}
