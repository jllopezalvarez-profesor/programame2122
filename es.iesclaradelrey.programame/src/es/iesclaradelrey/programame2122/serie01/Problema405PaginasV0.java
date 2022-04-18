package es.iesclaradelrey.programame2122.serie01;

import java.util.Scanner;

public class Problema405PaginasV0 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean fin = false;
		while (!fin) {
			String linea = sc.nextLine();
			if (linea.equals("0")) {
				fin = true;
			} else {
				int[] numeros = extraerNumeros(linea);
				escribirSeries(numeros);
			}
		}
	}

	private static void escribirSeries(int[] numeros) {
		if (numeros.length == 1)
		{
			System.out.println(numeros[0]);
			return;
		}

		boolean esPrimero = true;
		int inicial = numeros[0];
		int anterior = inicial;
		int actual = numeros[1];
		boolean enSerie = false;

		for (int i = 1; i < numeros.length; i++) {
			actual = numeros[i];
			if (actual == anterior + 1) {
				enSerie = true;
			} else {
				if (!esPrimero) {
					System.out.print(",");
				}
				if (enSerie) {
					System.out.print(inicial + "-" + anterior);
					enSerie = false;
				} else {
					System.out.print(anterior);
				}
				inicial = actual;
				
				esPrimero = false;
			}
			anterior = actual;
		}
		if ((inicial != actual) || ((inicial == actual) && (inicial == anterior))){
			if (!esPrimero) {
				System.out.print(",");
			}
			if (enSerie) {
				System.out.print(inicial + "-" + anterior);
			} else {
				System.out.print(anterior);
			}
		}
		System.out.println();
	}

	private static int[] extraerNumeros(String linea) {
		String[] cadenas = linea.split(" ");
		int[] numeros = new int[cadenas.length - 1];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = Integer.parseInt(cadenas[i]);
		}
		return numeros;
	}
}