package com.patience.Patience.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import java.util.*;

@Entity
@Tab(properties = "medicoid, nombre, apellido, especialidad, telefono")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicoid;

    @Required
    @Column(length = 100)
    private String nombre;

    @Required
    @Column(length = 100)
    private String apellido;

    private int edad;

    @Required
    @Column(length = 100)
    private String especialidad;

    @Column(length = 50)
    private String registroProfesional;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String correoElectronico;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Cita> citas;

    public int getMedicoid() { return medicoid; }
    public void setMedicoid(int medicoid) { this.medicoid = medicoid; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getRegistroProfesional() { return registroProfesional; }
    public void setRegistroProfesional(String registroProfesional) { this.registroProfesional = registroProfesional; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public List<Cita> getCitas() { return citas; }
    public void setCitas(List<Cita> citas) { this.citas = citas; }
}