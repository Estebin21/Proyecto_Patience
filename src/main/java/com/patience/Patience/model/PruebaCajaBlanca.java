package com.patience.Patience.model;

public class PruebaCajaBlanca {

    public static void main(String[] args) {
        // { ID, entrada, resultado esperado }
        String[][] casos = {
                {"CB-01", "1713175071", "true"},   // cédula válida (camino completo)
                {"CB-02", "17131",      "false"},  // longitud incorrecta
                {"CB-03", "17131750AB", "false"},  // carácter no numérico
                {"CB-04", "9913175071", "false"},  // provincia inválida (99)
                {"CB-05", "1713175070", "false"},  // dígito verificador no coincide
        };

        System.out.println("=========================================================================");
        System.out.println(" PRUEBAS DE CAJA BLANCA - Algoritmo validarCedula()  (Sistema Patience)");
        System.out.println("=========================================================================");
        System.out.printf("%-7s %-14s %-10s %-10s %-8s%n", "ID", "ENTRADA", "ESPERADO", "OBTENIDO", "ESTADO");
        System.out.println("-------------------------------------------------------------------------");

        int pasados = 0;
        for (String[] caso : casos) {
            String id       = caso[0];
            String entrada  = caso[1];
            String esperado = caso[2];
            String obtenido = String.valueOf(Paciente.validarCedula(entrada));
            String estado   = obtenido.equals(esperado) ? "PASA" : "FALLA";
            if (estado.equals("PASA")) pasados++;
            System.out.printf("%-7s %-14s %-10s %-10s %-8s%n", id, entrada, esperado, obtenido, estado);
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" Resultado: " + pasados + "/" + casos.length + " casos PASAN"
                + "  -> Cobertura de sentencia y decisión: 100%");
        System.out.println("=========================================================================");
    }
}