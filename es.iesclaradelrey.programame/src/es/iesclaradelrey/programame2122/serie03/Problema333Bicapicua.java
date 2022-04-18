package es.iesclaradelrey.programame2122.serie03;

import java.util.Scanner;

public class Problema333Bicapicua {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numeroCandidato;
		boolean esNumBiCapicua;
		while ((numeroCandidato = Integer.parseInt(sc.nextLine())) != 0) {
			esNumBiCapicua = false;
			if (numeroCandidato > 9) {
				esNumBiCapicua = esBiCapicua(numeroCandidato);
			}
			System.out.println(esNumBiCapicua ? "SI" : "NO");
		}
	}

	private static boolean esBiCapicua(int numeroCandidato) {

		int numCaracteres = String.valueOf(numeroCandidato).length();

		int posCorte = numCaracteres - 1;

		int dividendo = numeroCandidato;
		int divisor;
		int cociente;
		int resto;

		while (posCorte > 0) {
			divisor = (int) Math.pow(10, posCorte);
			cociente = dividendo / divisor;
			resto = dividendo % divisor;

			// System.out.printf("%d - %d - %d\n", dividendo, cociente, resto);

			if (esCapicua(cociente, 0)) {
				resto = dividendo % divisor;
				if (esCapicua(resto, posCorte)) {
					return true;
				}
			}
			posCorte--;
		}
		return false;
	}

	private static boolean esCapicua(int numero, int longitudEsperada) {
		char[] caracteres = String.valueOf(numero).toCharArray();

		if (caracteres.length == 1) {
			return true;
		}

		if ((longitudEsperada > 0) && (caracteres.length < longitudEsperada)) {
			return false;
		}

		int inicio = 0;
		int fin = caracteres.length - 1;
		while (inicio < fin) {
			if (caracteres[inicio] != caracteres[fin]) {
				return false;
			}
			inicio++;
			fin--;
		}
		return true;
	}
}