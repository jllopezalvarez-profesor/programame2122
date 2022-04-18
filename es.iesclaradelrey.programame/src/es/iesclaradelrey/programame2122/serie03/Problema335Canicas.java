package es.iesclaradelrey.programame2122.serie03;

import java.util.Scanner;

public class Problema335Canicas {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < numCasos; i++) {
			int altura = Integer.parseInt(sc.nextLine());
			System.out.println(calcularCanicas(altura));
		}
	}

	private static long calcularCanicas(int alturaTotal) {
		long total = 0;
		for (int piso = 1; piso <= alturaTotal; piso++) {
			total += numCanicasPiso(piso);
		}
		return total;
	}

	private static long numCanicasPiso(int ladoPiso) {
		long total =0;
		for (int i=1; i<= ladoPiso; i++)
			total += i;
		return total;
	}

}
