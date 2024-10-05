package org.example;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ADN_Mutant {
    public static int MIN = 4;
    public static String[] dna;
    static final Logger logger = Logger.getLogger("ADN_Mutant");
    static char index;
    public static String[] dnaX = new String[] {
            "XXXXXXX",
            "XXXXXXX",
            "XXXXXXX",
            "XXXXXXX",
            "XXXXXXX",
            "XXXXXXX",
            "XXXXXXX"
    };

    public static void main(String[] args) {
        logger.info("ADN MUTANT - STARTED");
        dna = new String[] {
                "AACCGCT",
                "ACAATCT",
                "AAGTGAA",
                "AGATGGC",
                "TCGCTTA",
                "ATAGTTA",
                "TCTCTGC"
        };
        isMutant();
        logger.info("ADN MUTANT - FINISHED");

    }

    public static void isMutant() {
        ArrayList<String> causas = new ArrayList<>();
        if (checkRows(dna)) {
            causas.add("Fila");
        }
        if (checkColumns(transponerDNA(dna))) {
            causas.add("Columna");
        }
        if (checkDiagonals()) {
            causas.add("Diagonal");
        }
        if (checkInverseDiagonals()) {
            causas.add("Diagonal inversa");
        }
        if (!causas.isEmpty()) {
            System.out.println("Es mutante por: ");
            for (String causa : causas) {
                System.out.println(causa);
            }
        } else
            logger.info("No es mutante.");
    }

    public static String[] transponerDNA(String[] dna) {
        int columnas = dna[0].length();

        // Crear un arreglo de StringBuilder para construir las nuevas cadenas
        StringBuilder[] dnaTranspuesto = new StringBuilder[columnas];

        // Inicializar los StringBuilder
        for (int i = 0; i < columnas; i++) {
            dnaTranspuesto[i] = new StringBuilder();
        }

        // Transponer el arreglo
        for (String s : dna) {
            for (int j = 0; j < columnas; j++) {
                dnaTranspuesto[j].append(s.charAt(j));
            }
        }

        // Convertir los StringBuilder a String
        String[] resultado = new String[columnas];
        for (int i = 0; i < columnas; i++) {
            resultado[i] = dnaTranspuesto[i].toString();
        }

        return resultado;
    }

    private static boolean checkRows(String[] dna) {

        for (String fila : dna) {
            if (checkSequence(fila)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns(String[] dna) {
        for (String column : dna) {
            if (checkSequence(column)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSequence(String sequence) {
        for (int i = 0; i <= sequence.length() - MIN; i++) {
            char index = sequence.charAt(i);
            if (index == sequence.charAt(i + 1) &&
                    index == sequence.charAt(i + 2) &&
                    index == sequence.charAt(i + 3)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        for (int row = 0; row < dna[0].length() - 3; row++) {
            for (int column = 0; column < dna[0].length() - 3; column++) {
                index = dna[row].charAt(column);
                if (index == dna[row + 1].charAt(column + 1) && index == dna[row + 2].charAt(column + 2)
                        && index == dna[row + 3].charAt(column + 3)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkInverseDiagonals() {
        for (int row = 0; row < dna.length - 3; row++) {
            for (int column = dna[0].length() - 1; column > 2; column--) {
                index = dna[row].charAt(column);
                if (index == dna[row + 1].charAt(column - 1) &&
                        index == dna[row + 2].charAt(column - 2) &&
                        index == dna[row + 3].charAt(column - 3)) {
                    return true;
                }
            }
        }
        return false;
    }

}
