package es.iesclaradelrey.programame2122.serie02;

import java.util.Scanner;

public class Problema457LioCasosPrueba {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numNumeros;
		while ((numNumeros = Integer.parseInt(sc.nextLine())) != 0) {
			int[] numeros = new int[numNumeros];
			llenarArayNumeros(numeros);
			System.out.println(buscarNumeroPerdido(numeros));
		}
	}

	private static int buscarNumeroPerdido(int[] numeros) {
		// System.out.println("\n\n\n\n");
		return buscarNumeroPerdido(numeros, numeros.length - 2, 1);
	}

	private static int buscarNumeroPerdido(int[] numeros, int inicioCaso, int longitudCaso) {
		// Si hemos llegado al inicio del array es que hemos encontrado una posible
		// solución
		if (inicioCaso < 0) {
			return longitudCaso;
		}

		int posibleSolucion = Integer.MAX_VALUE;
		while (inicioCaso > 0) {
			if (numeros[inicioCaso] == longitudCaso) {
				posibleSolucion = Math.min(posibleSolucion, buscarNumeroPerdido(numeros, inicioCaso - 2, 1));
			}
			inicioCaso--;
			longitudCaso++;
		}

		posibleSolucion = Math.min(posibleSolucion, longitudCaso + 1);

		return posibleSolucion;
	}

	private static void llenarArayNumeros(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = sc.nextInt();
		}
		// Leemos el salto de línea final para dejar el scanner en orden...
		sc.nextLine();
	}
}
