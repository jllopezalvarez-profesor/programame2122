package es.iesclaradelrey.programame2122.serie02;

import java.util.Scanner;

public class Problema455ParticipantesEstadistica {

	private static Scanner sc = new Scanner(System.in);
	private static final int DIEZMIL = 10000;

	public static void main(String[] args) {

		int numCasos = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < numCasos; i++) {
			// Tramos el porcentaje (tanto por diezmil) como una fracción de denominador
			// 10000. Si la simplificamos, obtenemos el menor número posible de encuestados
			// en el denominador.
			int numerador = Integer.parseInt(sc.nextLine());
			System.out.println(calcularDenominadorSimplificado(numerador));
		}
	}

	private static int calcularDenominadorSimplificado(int numerador) {
		int divisor = mcd(numerador, DIEZMIL);
		return DIEZMIL / divisor;
	}

	private static int mcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return mcd(b, a % b);
	}
}
