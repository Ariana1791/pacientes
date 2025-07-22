package com.mx.pacientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.pacientes.model.Paciente;
import com.mx.pacientes.repository.PacienteInterfaceRepository;

@Service
public class PacienteServiceImpl implements PacienteInterfaceService {

    @Autowired
    PacienteInterfaceRepository repository;

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        Paciente result = null;
        try {
            result = repository.save(paciente);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Paciente buscarPaciente(Paciente paciente) {
        Paciente resultado = null;
        try {
            resultado = repository.findByTelefono(paciente.getTelefono());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente, int idPaciente) {
        Paciente guardar = new Paciente();
        try {
            boolean recuperado = repository.existsById(idPaciente);
            if (recuperado == true) {
                guardar.setIdPaciente(idPaciente);
                guardar.setNombre(paciente.getNombre());
                guardar.setFechaNacimiento(paciente.getFechaNacimiento());
                guardar.setSexo(paciente.getSexo());
                guardar.setTipoSangre(paciente.getTipoSangre());
                guardar.setAlergias(paciente.getAlergias());
                guardar.setTelefono(paciente.getTelefono());
                guardar.setCorreo(paciente.getCorreo());
                guardar = repository.save(guardar);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return guardar;
    }

    @Override
    public void eliminarPaciente(int idPaciente) {
        {
            int id = (int) idPaciente;
            try {
                repository.deleteById(id);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public Paciente buscarTelefono(long telefono) {
        Paciente recuperado = null;
        try {
            recuperado = repository.findByTelefono(telefono);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recuperado;
    }

    @Override
    public boolean buscarPorId(int id) {
        boolean recuperado = false;
        try {
            recuperado = repository.existsById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recuperado;
    }
}
