package org.example;

public class ADN_Mutant {
    public static int MIN = 4;
    public static String[] dna;
    static int rows;
    static int columns;
    static char firstChar;
    static char fourthChar;

    public static void main(String[] args) {
        dna = new String[]{
                "ATGCGT",
                "TGTTCG",
                "GCTCTG",
                "CTTACG",
                "TGAACC",
        };
        rows = dna.length;
        columns = dna.length;
        if (isMutant()) {
            System.out.println("Es mutante");
        } else {
            System.out.println("NO es mutante");
        }
    }

    public static boolean isMutant() {
        return checkRows() || checkColumns() || checkDiagonals() || checkInverseDiagonals();
    }

    private static boolean checkRows() {
        for (String fila : dna) {
            if (checkSequence(fila)) {
                System.out.println("FILA");
                return true;
            }
        }
        return false;
    }

    private static boolean checkSequence(String sequence) {
        for (int i = 0; i <= sequence.length() - MIN; i++) {
            firstChar = sequence.charAt(i);
            fourthChar = sequence.charAt(i + 3);
            if (firstChar == fourthChar) {
                if (firstChar == sequence.charAt(i + 1) &&
                        firstChar == sequence.charAt(i + 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkColumns() {
        for (int col = 0; col < columns - 1; col++) {
            for (int row = 0; row < rows - 3; row++) {
                firstChar = dna[row].charAt(col);
                fourthChar = dna[row + 3].charAt(col);
                if (firstChar == fourthChar) {
                    if (firstChar == dna[row + 1].charAt(col) &&
                            firstChar == dna[row + 2].charAt(col)) {
                        System.out.println("COLUMNA");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        for (int row = 0; row < rows - 3; row++) {
            for (int column = 0; column < columns - 3; column++) {
                firstChar = dna[row].charAt(column);
                fourthChar = dna[row + 3].charAt(column + 3);
                if (firstChar == fourthChar) {
                    if (firstChar == dna[row + 1].charAt(column + 1) && firstChar == dna[row + 2].charAt(column + 2)) {
                        System.out.println("DIAGONAL");
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private static boolean checkInverseDiagonals() {
        for (int row = 0; row < rows - 3; row++) {
            for (int column = columns - 1; column > 2; column--) {
                firstChar = dna[row].charAt(column);
                fourthChar = dna[row + 3].charAt(column - 3);
                if (firstChar == fourthChar) {
                    if (firstChar == dna[row + 1].charAt(column - 1) && firstChar == dna[row + 2].charAt(column - 2)) {
                        System.out.println("DIAGONAL INVERSA");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}