package es.iesclaradelrey.programame2122.serie05;

import java.util.HashSet;
import java.util.Scanner;

public class Problema521PodemosEmpezar {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int numPlantas = Integer.parseInt(sc.next().trim());
		int numLetras = Integer.parseInt(sc.next().trim());
		int numAsistentes = Integer.parseInt(sc.nextLine().trim());
		while (numPlantas != 0 && numLetras != 0 && numAsistentes != 0) {
			int numViviendas = numPlantas * numLetras;
			int cuorum = (numViviendas / 2) + (numViviendas % 2);
			procesarAsistentes(numAsistentes, cuorum);
			numPlantas = Integer.parseInt(sc.next().trim());
			numLetras = Integer.parseInt(sc.next().trim());
			numAsistentes = Integer.parseInt(sc.nextLine().trim());
		}

	}

	private static void procesarAsistentes(int numAsistentes, int cuorum) {
		HashSet<String> pisosAsistentes = new HashSet<>();
		for (int i = 0; i < numAsistentes; i++) {
			String piso = sc.next().trim() + sc.next().trim();
			pisosAsistentes.add(piso);
		}
		sc.nextLine();

		System.out.println((pisosAsistentes.size() >= cuorum) ? "EMPEZAMOS" : "ESPERAMOS");
	}
}
