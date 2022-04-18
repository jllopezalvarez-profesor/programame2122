package es.iesclaradelrey.programame2122.serie03;

import java.util.Scanner;

public class Problema335CanicasV2 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numCasos; i++) {

			int altura = Integer.parseInt(sc.nextLine());
			long total = 0;
			long canicasActual = 0;

			for (int alturaActual = 1; alturaActual <= altura; alturaActual++) {
				canicasActual += alturaActual;
				total += canicasActual;
			}

			System.out.println(total);
		}
	}
}
