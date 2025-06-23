package com.mx.pacientes.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="paciente")
public class Paciente {

    @Id
    @Column(name ="id_paciente")
    private int idPaciente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name ="fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name ="sexo")
    private String sexo;
    @Column(name ="tipo_sangre")
    private String tipoSangre;
    @Column(name = "alergias")
    private String  alergias;
    @Column(name ="domicilio")
    private String domicilio;
    @Column(name = "telefono")
    private Long telefono;
    @Column(name ="correo")
    private String correo;

    public Paciente(){
        
    }

    public Paciente(int idPaciente, String nombre, Date fechaNacimiento, String sexo, String tipoSangre,
            String alergias, String domicilio, Long telefono, String correo) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
}
