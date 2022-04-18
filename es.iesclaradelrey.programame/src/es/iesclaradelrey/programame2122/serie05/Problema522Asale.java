package es.iesclaradelrey.programame2122.serie05;

import java.util.Scanner;

/**
 * 
 * No aceptado.
 *
 */
public class Problema522Asale {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (sc.hasNext()) {
			String palabraA = sc.next().trim();
			String palabraB = sc.nextLine().trim();

			char[] charsA = palabraA.toCharArray();
			char[] charsB = palabraB.toCharArray();

			int posicion = 0;
			boolean encontrado = false;
			boolean segundaMenor = false;

			while ((posicion < charsA.length) && (posicion < charsB.length) && !encontrado) {
				char letraA1 = charsA[posicion];
				char letraB1 = charsB[posicion];
				if (letraA1 == letraB1) {
					int posicionLetra2 = posicion + 1;
					if (((letraA1 == 'c') || (letraB1 == 'l')) && (posicionLetra2 < charsA.length)
							&& (posicionLetra2 < charsB.length)) {
						char letraA2 = charsA[posicionLetra2];
						char letraB2 = charsB[posicionLetra2];
						if (letraA2 == letraB2) {
							posicion++;
						} else {
							if (letraA1 == 'c') {
								if (letraA2 == 'h') {
									encontrado = true;
									segundaMenor = true;
								} else if (letraB2 == 'h') {
									encontrado = true;
									segundaMenor = false;
								}
							}
							if (letraA1 == 'l') {
								if (letraA2 == 'l') {
									encontrado = true;
									segundaMenor = true;
								} else if (letraB2 == 'l') {
									encontrado = true;
									segundaMenor = false;
								}
							}
						}

					}

				} else {
					encontrado = true;
					segundaMenor = (letraA1 > letraB1);
				}
				posicion++;
			}

			if (!encontrado)
				segundaMenor = palabraB.length() < palabraA.length();

			System.out.println(segundaMenor ? palabraB : palabraA);

		}

	}

}
