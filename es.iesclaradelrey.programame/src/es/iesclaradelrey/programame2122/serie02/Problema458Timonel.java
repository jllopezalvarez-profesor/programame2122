package es.iesclaradelrey.programame2122.serie02;

import java.util.Scanner;

public class Problema458Timonel {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numNumeros;

		while ((numNumeros = Integer.parseInt(sc.nextLine())) != 0) {
			long max, max2, min, min2;
			long valor;
			// Como al menos hay dos valores, los leemos para inicializar los cuatro valores
			// iniciales
			max = sc.nextLong();
			min = max;
			valor = sc.nextLong();
			if (max < valor) {
				max2 = max;
				max = valor;
			} else {
				max2 = valor;
			}
			if (min > valor) {
				min2 = min;
				min = valor;
			} else {
				min2 = valor;
			}

			// Leemos el resto
			for (int i = 2; i < numNumeros; i++) {
				valor = sc.nextLong();
				if (max < valor) {
					max2 = max;
					max = valor;
				} else if (max2 < valor) {
					max2 = valor;
				}
				if (min > valor) {
					min2 = min;
					min = valor;
				} else if (min2 > valor) {
					min2 = valor;
				}
			}

			System.out.println(Math.max(max * max2, min * min2));
			sc.nextLine();
		}
	}
}
