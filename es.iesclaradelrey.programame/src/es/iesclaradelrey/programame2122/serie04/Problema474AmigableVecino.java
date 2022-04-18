package es.iesclaradelrey.programame2122.serie04;

import java.util.Scanner;

public class Problema474AmigableVecino {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < numCasos; i++) {
			int posicionInicial = Integer.parseInt(sc.next().trim());
			int posicionBomba1 = Integer.parseInt(sc.next().trim());
			int posicionBomba2 = Integer.parseInt(sc.nextLine().trim());

			// Ordenamos las posiciones de las bombas para ir primero a la que esté más
			// cerca del origen
			if (Math.abs(posicionInicial - posicionBomba2) < Math.abs(posicionInicial - posicionBomba1)) {
				int aux = posicionBomba1;
				posicionBomba1 = posicionBomba2;
				posicionBomba2 = aux;
			}

			int distancia = Math.abs(posicionBomba1 - posicionInicial) + Math.abs(posicionBomba2 - posicionBomba1);

			System.out.println(distancia);
		}
	}
}
