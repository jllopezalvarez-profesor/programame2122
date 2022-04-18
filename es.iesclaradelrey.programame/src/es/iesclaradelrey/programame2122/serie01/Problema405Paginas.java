package es.iesclaradelrey.programame2122.serie01;

import java.util.Scanner;

public class Problema405Paginas {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean fin = false;
		while (!fin) {
			int inicial = sc.nextInt();
			if (inicial == 0) {
				fin = true;
			} else {

				int actual = sc.nextInt();
				if (actual == 0) {
					System.out.println(inicial);
				} else {

					boolean esPrimero = true;
					int anterior = inicial;
					boolean enSerie = false;

					do {
						if (actual == anterior + 1) {
							enSerie = true;
						} else {
							if (!esPrimero) {
								System.out.print(",");
							}
							if (enSerie) {
								System.out.print(inicial + "-" + anterior);
								enSerie = false;
							} else {
								System.out.print(anterior);
							}
							inicial = actual;

							esPrimero = false;
						}
						anterior = actual;
						actual = sc.nextInt();
					} while (actual != 0);

					if (((inicial != anterior) && enSerie) || ((inicial == anterior) && !enSerie)) {
						if (!esPrimero) {
							System.out.print(",");
						}
						if (enSerie) {
							System.out.print(inicial + "-" + anterior);
						} else {
							System.out.print(anterior);
						}
					}
					System.out.println();
				}
			}
		}
	}
}