package com.patience.Patience.run;

import org.openxava.util.*;

/**
 * Execute this class to start the application.
 *
 * With OpenXava Studio/Eclipse: Right mouse button > Run As > Java Application
 */

public class Patience {

	public static void main(String[] args) throws Exception {
		DBServer.start("Patience-db"); // To use your own database comment this line and configure src/main/webapp/META-INF/context.xml
		AppServer.run("Patience"); // Use AppServer.run("") to run in root context
	}

}
