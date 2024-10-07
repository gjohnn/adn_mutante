package org.example;

import java.util.logging.Logger;


public class ADN_Mutant {
    public static int MIN = 4;
    public static String[] dna;
    static final Logger logger = Logger.getLogger("ADN_Mutant");
    static char index;
    static char indexFinal;
    static int rows;
    static int columns;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
//
//        dna = new String[]{
//                "AACCGCT",
//                "ACACCGT",
//                "CAGTGAA",
//                "AGAGTGC",
//                "TCGGATA",
//                "ATACTGT",
//                "TCTCTGG"
//        };
       dna = new String[]{
                "ATGCGTACGTACGTA",
                "CGTACGTACGTACGA",
                "TACGTACGTACTGAC",
                "GTACTGACGTACGTA",
                "CGTACGTACGTACGA",
                "TACGTACGTACTGAC",
                "GTACTGACGTACGTA",
                "ATGCGTACGTACGTA",
                "CGTACGTACGTACGA",
                "TACGTACGTACTGAC",
                "GTACTGACGTACGTA",
                "AATACTGACGTACGA", // Coincidencia en la columna 1 (cuatro 'A')
                "AAGACTGACGTACGA",
                "AAGACTGACGTACGA",
                "AACACTGACGTACGA"
        };

        rows = dna.length - 3;
        columns = dna.length - 3;
        if (isMutant()) {
            System.out.println("Es mutante");
        }else{
            System.out.println("NO es mutante");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("El código tomó " + duration + " milisegundos en ejecutarse.");

    }

    public static boolean isMutant() {
        return checkRows() || checkColumns() || checkDiagonals() || checkInverseDiagonals();
    }


    private static boolean checkRows() {

        for (String fila : dna) {
            if (checkSequence(fila)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSequence(String sequence) {
        for (int i = 0; i <= sequence.length() - MIN; i++) {
            char firstChar = sequence.charAt(i);
            char fourthChar = sequence.charAt(i + 3);
            if (firstChar == fourthChar) {
                if (firstChar == sequence.charAt(i + 1) &&
                        firstChar == sequence.charAt(i + 2)) {
                    System.out.println(firstChar);
                    System.out.println(sequence.charAt(i + 1));
                    System.out.println(sequence.charAt(i + 2));
                    System.out.println(fourthChar);
                    System.out.println("Mutante por fila");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkColumns() {
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                char firstChar = dna[row].charAt(col);
                char fourthChar = dna[row + 3].charAt(col);
                if (firstChar == fourthChar) {
                    if (firstChar == dna[row + 1].charAt(col) &&
                            firstChar == dna[row + 2].charAt(col)) {
                        System.out.println(firstChar);
                        System.out.println(dna[row + 1].charAt(col));
                        System.out.println(dna[row + 2].charAt(col));
                        System.out.println(fourthChar);
                        System.out.println("Mutante por columna");
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private static boolean checkDiagonals() {
        dna = new String[]{
                "AACCGCT",
                "ACACCGT",
                "CAGTGAA",
                "AGAAAGC",
                "TCGGATA",
                "ATACTGT",
                "TCTCTGG"
        };
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char firstChar = dna[row].charAt(column);
                char fourthChar = dna[row + 3].charAt(column + 3);
                if (firstChar == fourthChar) {
                    if (firstChar == dna[row + 1].charAt(column + 1) && firstChar == dna[row + 2].charAt(column + 2)) {
                        System.out.println(firstChar);
                        System.out.println(fourthChar);
                        System.out.println("Mutante por diagonal");
                        return true;
                    }

                }
            }
        }

        return false;
    }

    private static boolean checkInverseDiagonals() {
        for (int row = 0; row < dna.length - 3; row++) {
            for (int column = dna[0].length() - 1; column > 2; column--) {
                char firstChar = dna[row].charAt(column);
                char fourthChar = dna[row + 3].charAt(column - 3);
                if (firstChar == fourthChar) {
                    if (firstChar == dna[row + 1].charAt(column - 1) && firstChar == dna[row + 2].charAt(column - 2)) {
                        System.out.println(firstChar);
                        System.out.println(dna[row + 1].charAt(column - 1));
                        System.out.println(dna[row + 2].charAt(column - 2));
                        System.out.println(fourthChar);
                        System.out.println("Mutante por diagonal inversa");
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
