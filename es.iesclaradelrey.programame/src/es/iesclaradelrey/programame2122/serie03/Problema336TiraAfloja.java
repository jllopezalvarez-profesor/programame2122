package es.iesclaradelrey.programame2122.serie03;

import java.util.Scanner;

public class Problema336TiraAfloja {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (sc.hasNext()) {
			int numJugadores = Integer.parseInt(sc.nextLine());
			int[] pesos = new int[numJugadores];
			leerPesos(pesos);
			procesarPesos(pesos);
		}
	}

	private static void procesarPesos(int[] pesos) {
		int limiteIzquierdo = 0;
		int limiteDerecho = pesos.length - 1;
		int totalIzquierdo = pesos[0];
		int totalDerecho = pesos[pesos.length - 1];

		while (limiteIzquierdo < (limiteDerecho - 1)) {
			if (totalIzquierdo < totalDerecho) {
				limiteIzquierdo++;
				totalIzquierdo += pesos[limiteIzquierdo];
			} else if (totalDerecho < totalIzquierdo) {
				limiteDerecho--;
				totalDerecho += pesos[limiteDerecho];
			} else {
				limiteIzquierdo++;
				totalIzquierdo += pesos[limiteIzquierdo];
				limiteDerecho--;
				totalDerecho += pesos[limiteDerecho];
			}
		}

		boolean imposible = false;
		if (totalDerecho == totalIzquierdo) {
			imposible = true;
		} else if (limiteIzquierdo == limiteDerecho) {
			// El peso del elemento común se ha sumado a los dos.
			// Se resta el peso en exceso del grupo más pesado y se ajustan indices.
			if (totalIzquierdo > totalDerecho) {
				totalIzquierdo -= pesos[limiteIzquierdo];
				limiteIzquierdo--;
			} else {
				totalDerecho -= pesos[limiteDerecho];
				limiteDerecho++;
			}
		}

		if (imposible) {
			System.out.println("NO JUEGAN");
		} else {
			System.out.printf("%d %d %d\n", limiteIzquierdo + 1, totalIzquierdo, totalDerecho);
		}
	}

	private static void leerPesos(int[] pesos) {
		for (int i = 0; i < pesos.length; i++)
			pesos[i] = sc.nextInt();
		sc.nextLine();
	}
}
