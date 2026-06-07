package com.patience.Patience.run;

import org.openxava.util.*;

/**
 * Execute this class to start the application.
 *
 * With OpenXava Studio/Eclipse: Right mouse button > Run As > Java Application
 */

public class Patience {

	public static void main(String[] args) throws Exception {
		System.out.println("--- PRUEBA validarCedula ---");
		System.out.println(com.patience.Patience.model.Paciente.validarCedula("1713175071"));  // true
		System.out.println(com.patience.Patience.model.Paciente.validarCedula("17131"));       // false
		System.out.println(com.patience.Patience.model.Paciente.validarCedula("9913175071"));  // false
		System.out.println("--- FIN PRUEBA ---");

        System.out.println("\n--- PRUEBA clasificarPaciente ---");
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            System.out.println(com.patience.Patience.model.Paciente.clasificarPaciente(sdf.parse("2018-06-07")));  // Pediatrico
            System.out.println(com.patience.Patience.model.Paciente.clasificarPaciente(sdf.parse("2010-06-07")));  // Pediatrico
            System.out.println(com.patience.Patience.model.Paciente.clasificarPaciente(sdf.parse("1990-06-07")));  // Adulto
            System.out.println(com.patience.Patience.model.Paciente.clasificarPaciente(null));                     // Fecha invalida
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--- FIN PRUEBA ---");

		DBServer.start("Patience-db");
		AppServer.run("Patience");
	}

}
