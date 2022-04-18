package es.iesclaradelrey.programame2122.serie03;

import java.util.Scanner;

public class Problema335CanicasV3 {

	private static Scanner sc = new Scanner(System.in);

	// Usando la soución de Harriot para aplilamiento de base triangular:
	// Tn = (n³/6) + (n²/2) + (n/3)
	// https://www.investigacionyciencia.es/blogs/matematicas/66/posts/contando-naranjas-12745

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numCasos; i++) {
			int altura = Integer.parseInt(sc.nextLine());

			double pisos = (double) altura;
			double total = (Math.pow(pisos, 3) + (3 * Math.pow(pisos, 2)) + (2 * pisos)) / 6;
			total = Math.round(total);

			System.out.println((long) total);
		}
	}
}
