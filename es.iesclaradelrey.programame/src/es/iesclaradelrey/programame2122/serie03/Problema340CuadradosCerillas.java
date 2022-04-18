package es.iesclaradelrey.programame2122.serie03;

import java.util.Scanner;

public class Problema340CuadradosCerillas {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numCasos; i++) {
			int ancho = sc.nextInt();
			int alto = sc.nextInt();
			long cerillas = ((ancho + 1) * alto) + ((alto + 1) * ancho);
			System.out.println(cerillas);
			sc.nextLine();
		}
	}
}
