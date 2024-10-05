package org.example;

public class ADN_mutant {
    public static int MIN = 4;
    private static final char[] BASES = {'A', 'T', 'C', 'G'};
    public static String[] dna;

    public static void main(String[] args) {
        dna = new String[]{
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "TGAAGG",
                "TATCCC",
                "TCACTG"
        };
        if (isMutant()) {
            System.out.println("Mutant");
        } else
            System.out.println("Not Mutant");
    }

    public static boolean isMutant() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (String s : dna) {
            for (int j = 0; j < dna[0].length(); j++) {
                if (j == s.length() - 3) {
                    break;
                }
                if (s.charAt(j) == s.charAt(j + 1) && s.charAt(j) == s.charAt(j + 2) && s.charAt(j) == s.charAt(j + 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkColumns() {

        for (String s : dna) {
            for (int j = 0; j < dna[0].length(); j++) {
                if (j == s.length() - 3) {
                    break;
                }
                if (s.charAt(j) == s.charAt(j + 1) && s.charAt(j) == s.charAt(j + 2) && s.charAt(j) == s.charAt(j + 3)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkDiagonals() {
        //Diagonal

        //Diagonal inversa
        return false;
    }
}


