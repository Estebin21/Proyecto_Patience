package com.patience.Patience.model;

import javax.persistence.*;
import org.openxava.annotations.*;

@Entity
@Tab(properties = "citaid, fechaCita, horaCita, paciente.cedula, medico.nombre, estado")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int citaid;

    @Required
    @Temporal(TemporalType.DATE)
    private java.util.Date fechaCita;

    @Required
    @Temporal(TemporalType.TIME)
    private java.util.Date horaCita;

    @Column(length = 200)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Required
    private EstadoCita estado;

    @Column(length = 200)
    private String motivoCancelacion;

    @ManyToOne
    @Required
    @ReferenceView("Simple")
    private Paciente paciente;

    @ManyToOne
    @Required
    @ReferenceView("Simple")
    private Medico medico;

    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL)
    private Diagnostico diagnostico;

    public int getCitaid() { return citaid; }
    public void setCitaid(int citaid) { this.citaid = citaid; }

    public java.util.Date getFechaCita() { return fechaCita; }
    public void setFechaCita(java.util.Date fechaCita) { this.fechaCita = fechaCita; }

    public java.util.Date getHoraCita() { return horaCita; }
    public void setHoraCita(java.util.Date horaCita) { this.horaCita = horaCita; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public EstadoCita getEstado() { return estado; }
    public void setEstado(EstadoCita estado) { this.estado = estado; }

    public String getMotivoCancelacion() { return motivoCancelacion; }
    public void setMotivoCancelacion(String motivoCancelacion) { this.motivoCancelacion = motivoCancelacion; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    public Diagnostico getDiagnostico() { return diagnostico; }
    public void setDiagnostico(Diagnostico diagnostico) { this.diagnostico = diagnostico; }
}