package com.patience.Patience.model;

import javax.persistence.*;
import org.openxava.annotations.*;

@Entity
@Tab(properties = "usuarioid, username, rol, medico.nombre")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioid;

    @Required
    @Column(length = 50, unique = true)
    private String username;

    @Required
    @Column(length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Required
    private Rol rol;

    @ManyToOne
    private Medico medico;

    public int getUsuarioid() { return usuarioid; }
    public void setUsuarioid(int usuarioid) { this.usuarioid = usuarioid; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
}