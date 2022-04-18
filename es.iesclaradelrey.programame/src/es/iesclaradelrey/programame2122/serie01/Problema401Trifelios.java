package es.iesclaradelrey.programame2122.serie01;

import java.util.Scanner;

public class Problema401Trifelios {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < numCasos; i++) {
			String palabra1 = sc.next().trim().toLowerCase().replace('b', 'v');
			String palabra2 = sc.nextLine().trim().toLowerCase().replace('b', 'v');

			boolean esTrifelio = false;

			if (!palabra1.equals(palabra2)) {
				String duplicada = palabra1 + palabra1;
				int posPalabra = duplicada.indexOf(palabra2);
				if (posPalabra != -1) {
					String otraPalabra = duplicada.substring(posPalabra + palabra2.length());
					otraPalabra += duplicada.substring(0, posPalabra);
					esTrifelio = otraPalabra.equals(palabra2);
				}

			}
			System.out.println(esTrifelio ? "SI" : "NO");
		}
	}

}
