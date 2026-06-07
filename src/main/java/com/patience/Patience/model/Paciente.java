package com.patience.Patience.model;

import javax.persistence.*;
import org.openxava.annotations.*;
import java.util.*;

@Entity
@Tab(properties = "cedula, nombre, apellido, telefono, correoElectronico")
public class Paciente {

	@Id
	@Column(length = 10)
	@Required
	private String cedula;

	@Required
	@Column(length = 100)
	private String nombre;

	@Required
	@Column(length = 100)
	private String apellido;

	@Required
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column(length = 200)
	private String alergias;

	@Column(length = 200)
	private String condicionEspecial;

	@Enumerated(EnumType.STRING)
	@Required
	private Genero genero;

	@Column(length = 200)
	private String direccion;

	@Column(length = 15)
	private String telefono;

	@Column(length = 100)
	private String correoElectronico;

	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Cita> citas;

	public String getCedula() { return cedula; }
	public void setCedula(String cedula) { this.cedula = cedula; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }

	public Date getFechaNacimiento() { return fechaNacimiento; }
	public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

	public String getAlergias() { return alergias; }
	public void setAlergias(String alergias) { this.alergias = alergias; }

	public String getCondicionEspecial() { return condicionEspecial; }
	public void setCondicionEspecial(String condicionEspecial) { this.condicionEspecial = condicionEspecial; }

	public Genero getGenero() { return genero; }
	public void setGenero(Genero genero) { this.genero = genero; }

	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }

	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }

	public String getCorreoElectronico() { return correoElectronico; }
	public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

	public List<Cita> getCitas() { return citas; }
	public void setCitas(List<Cita> citas) { this.citas = citas; }

	public static boolean validarCedula(String cedula) {
		if (cedula == null || cedula.length() != 10) {
			return false;
		}
		for (char c : cedula.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		int provincia = Integer.parseInt(cedula.substring(0, 2));
		if (provincia < 1 || provincia > 24) {
			return false;
		}
		int tercerDigito = Character.getNumericValue(cedula.charAt(2));
		if (tercerDigito >= 6) {
			return false;
		}
		int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
		int suma = 0;
		for (int i = 0; i < 9; i++) {
			int valor = Character.getNumericValue(cedula.charAt(i)) * coeficientes[i];
			if (valor >= 10) valor -= 9;
			suma += valor;
		}
		int digitoVerificador = Character.getNumericValue(cedula.charAt(9));
		int resultado = (10 - (suma % 10)) % 10;
		return resultado == digitoVerificador;
	}

    public static int calcularEdad(java.util.Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            return -1;
        }
        java.util.Calendar hoy = java.util.Calendar.getInstance();
        java.util.Calendar nacimiento = java.util.Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);
        int edad = hoy.get(java.util.Calendar.YEAR) - nacimiento.get(java.util.Calendar.YEAR);
        if (hoy.get(java.util.Calendar.DAY_OF_YEAR) < nacimiento.get(java.util.Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        return edad;
    }

    public static String clasificarPaciente(java.util.Date fechaNacimiento) {
        int edad = calcularEdad(fechaNacimiento);
        if (edad < 0) {
            return "Fecha invalida";
        } else if (edad <= 11) {
            return "Pediatrico";
        } else if (edad <= 17) {
            return "Adolescente";
        } else if (edad <= 64) {
            return "Adulto";
        } else {
            return "Adulto mayor";
        }
    }
}