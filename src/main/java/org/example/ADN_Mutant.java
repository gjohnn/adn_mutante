package org.example;

public class ADN_Mutant {
    public static String[] dna;

    public static void main(String[] args) {
        System.out.println(isMutant() ? "Es mutante" : "NO es mutante");
    }

    public static boolean isMutant() {
        int n = dna.length;
        int marcoSkip = 4;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                // Revisión horizontal HECHO
                if (j <= n - marcoSkip && checkSequence(dna, i, j, 0, 1)) {
                    return true;
                }
                //Revisión vertical HECHO
                if (i <= n - marcoSkip && checkSequence(dna, i, j, 1, 0)) {
                    return true;
                }
                // Revisión diagonal ↘ 
                if (i <= n - marcoSkip && j <= n - marcoSkip && checkSequence(dna, i, j, 1, 1)) {
                    return true;
                }
                // Revisión diagonal inversa ↙ 
                if (i <= n - marcoSkip && j >= marcoSkip - 1 && checkSequence(dna, i, j, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkSequence(String[] dna, int row, int col, int rowDir, int colDir) {
        char initial = dna[row].charAt(col); // Posicion inicial
        int cant = 0; // Iniciar variable de cantidad
        for (int i = 1; i < 4; i++) {  // Itera solo 4 posiciones consecutivas
            // Verifica si las letras consecutivas son iguales en la dirección dada
            if (dna[row + i * rowDir].charAt(col + i * colDir) == initial) {
                cant++;  // Si encuentra una que no coincide, regresa false
            } else {
                return false;
            }
        }
        return cant >= 3;
    }
}