package es.iesclaradelrey.programame2122.serie03;

import java.util.Scanner;

public class Problema333BicapicuaV2 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String numeroCandidato = sc.nextLine();
		while (!numeroCandidato.equals("0")) {
			System.out.println(esBiCapicua(numeroCandidato.toCharArray()) ? "SI" : "NO");
			numeroCandidato = sc.nextLine();
		}
	}

	private static boolean esBiCapicua(char[] candidato) {
		int longitudCandidato = candidato.length;
		
		if (longitudCandidato == 1) return false;

		int posCorte = 1;
		boolean esBicap = false;
		while (!esBicap && (posCorte < candidato.length)) {
			if (esCapicua(candidato, 0, posCorte - 1)) {
				esBicap = esCapicua(candidato, posCorte, longitudCandidato - 1);
			}
			posCorte++;
		}

		return esBicap;
	}

	private static boolean esCapicua(char[] candidato, int inicio, int fin) {
		// Los números de un dígito son capicuas.
		if (inicio == fin) {
			return true;
		}

		// Si empieza por cero, dado que sabemos que es al menos de longitud 2, no es
		// capicua
		if (candidato[inicio] == '0') {
			return false;
		}

		// Miramos de ambos lados para verificar que es capicua
		while (inicio < fin) {
			if (candidato[inicio] != candidato[fin]) {
				return false;
			}
			inicio++;
			fin--;
		}

		// Si llegamos a este punto es capicua
		return true;
	}

}