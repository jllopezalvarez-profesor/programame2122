package es.iesclaradelrey.programame2122.serie01;

import java.util.Scanner;

public class ProblemaPuzzle {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numPiezas;
		while ((numPiezas = Integer.parseInt(sc.nextLine())) != 0) {
			int ladoMenor = (int)Math.sqrt(numPiezas);
			int resto;
			resto = numPiezas % ladoMenor;
			while (resto != 0)
			{
				ladoMenor--;
				resto = numPiezas % ladoMenor;
			}
			System.out.println(numPiezas/ladoMenor);
		}
	}
}
