package com.patience.Patience.model;

import javax.persistence.*;
import org.openxava.annotations.*;

@Entity
@Tab(properties = "diagnosticoid, cita.citaid, descripcion, fechaRevision")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diagnosticoid;

    @Required
    @Column(length = 500)
    private String descripcion;

    @Column(length = 500)
    private String tratamiento;

    @Column(length = 500)
    private String observacionesClinicas;

    @Temporal(TemporalType.DATE)
    private java.util.Date fechaRevision;

    @OneToOne
    @Required
    private Cita cita;

    @ManyToOne
    private Paciente paciente;

    public int getDiagnosticoid() { return diagnosticoid; }
    public void setDiagnosticoid(int diagnosticoid) { this.diagnosticoid = diagnosticoid; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public String getObservacionesClinicas() { return observacionesClinicas; }
    public void setObservacionesClinicas(String observacionesClinicas) { this.observacionesClinicas = observacionesClinicas; }

    public java.util.Date getFechaRevision() { return fechaRevision; }
    public void setFechaRevision(java.util.Date fechaRevision) { this.fechaRevision = fechaRevision; }

    public Cita getCita() { return cita; }
    public void setCita(Cita cita) { this.cita = cita; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}