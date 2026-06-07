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

		DBServer.start("Patience-db");
		AppServer.run("Patience");
	}

}
