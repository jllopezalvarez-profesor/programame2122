package es.iesclaradelrey.programame2122.serie04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * No aceptado.
 *
 */
public class Problema478ConjuritisV2 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int numHechizos;
		while ((numHechizos = Integer.parseInt(sc.nextLine())) != 0) {
			long danioEsperado = 0;
			int[] hechizos = new int[numHechizos];
			for (int i = 0; i < numHechizos; i++) {
				int danioActual = Integer.parseInt(sc.next().trim());
				hechizos[i] = danioActual;
				danioEsperado += danioActual;
			}
			sc.nextLine();
			long danioCausado = Integer.parseInt(sc.nextLine());

			buscarHechizosFallidos(hechizos, danioEsperado, danioCausado);
		}

	}

	private static void buscarHechizosFallidos(int[] hechizos, long danioEsperado, long danioCausado) {
		// Calculamos la diferencia entre daño causado y daño esperado.
		// Podemos convertirlo con tranquilidad a int porque será la suma de dos
		// hechizos, con un valor máximo de 500000 cada uno
		int diferencia = (int) (danioEsperado - danioCausado);

		// En el caso menos favorable, podemos tener el hechizo de mayor valor con valor
		// diferencia-1 y el de menor valor con valor 1.
		int hechizoMayor = diferencia - 1;
		int hechizoMenor = 1;

		// Para evitar búsqueda de complejidad cuadrática "completa", vamos a buscar con
		// búsqueda binaria la
		// posición del hechizo mayor más próximo a la diferencia en el array
		int posHechizoMayor = Arrays.binarySearch(hechizos, hechizoMayor);
		if (posHechizoMayor < 0) {
			// No se ha encontrado, y posHechizoMayor tendrá la posición del elemento mayor
			// que el valor que buscábamos. Modificamos valores para partir del elemento
			// anterior.
			posHechizoMayor = (-posHechizoMayor) - 1;
			if (posHechizoMayor == hechizos.length) {
				posHechizoMayor--;
			}
			hechizoMayor = hechizos[posHechizoMayor];
			hechizoMenor = diferencia - hechizoMayor;
		}

		// Buscamos la posición del posible hechizo menor
		int posHechizoMenor = Arrays.binarySearch(hechizos, 0, posHechizoMayor, hechizoMenor);
		if (posHechizoMenor < 0) {
			posHechizoMenor = (-posHechizoMenor);
			hechizoMenor = hechizos[posHechizoMenor];
		}

		// Probamos desde el mayor hacia abajo en la lista, buscando su complementario
		// menor. En lugar de usar búsqueda binaria, vamos a hacer un recorrido normal y
		// corriente, porque con la binaria nos daba RTE

		int sumaHechizos = hechizoMayor + hechizoMenor;
		while (sumaHechizos != diferencia) {
			posHechizoMayor--;
			hechizoMayor = hechizos[posHechizoMayor];
			hechizoMenor = diferencia - hechizoMayor;
			posHechizoMenor = Arrays.binarySearch(hechizos, posHechizoMenor - 1, posHechizoMayor, hechizoMenor);
			if (posHechizoMenor < 0) {
				posHechizoMenor = (-posHechizoMenor) - 1;
			}
			hechizoMenor = hechizos[posHechizoMenor];
			sumaHechizos = hechizoMenor + hechizoMayor;
		}

		System.out.printf("%d %d\n", hechizoMenor, hechizoMayor);
	}
}
