package es.iesclaradelrey.programame2122.serie05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * No aceptado.
 *
 */
public class Problema524CompeTencia {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCompras;
		while ((numCompras = Integer.parseInt(sc.nextLine())) != 0) {
			int minimoC = Integer.parseInt(sc.next().trim());
			int minimoT = Integer.parseInt(sc.nextLine().trim());
			ArrayList<Integer> importesC = getImportesOrdenados(numCompras);
			ArrayList<Integer> importesT = getImportesOrdenados(numCompras);
			ArrayList<Integer> compras = new ArrayList<>(numCompras);

			compras.addAll(importesC.subList(0, minimoC));
			importesC.subList(0, minimoC).clear();
			compras.addAll(importesT.subList(0, minimoT));
			importesT.subList(0, minimoT).clear();

			importesC.addAll(importesT);
			Collections.sort(importesC);
			compras.addAll(importesC.subList(0, numCompras - (minimoC + minimoT)));

			long total = 0;
			for (Integer importe : compras) {
				total += importe;
			}
			System.out.println(total);
		}

	}

	private static ArrayList<Integer> getImportesOrdenados(int numCompras) {
		ArrayList<Integer> importes = new ArrayList<>(numCompras);
		for (int i = 0; i < numCompras; i++) {
			importes.add(Integer.parseInt(sc.next().trim()));
		}
		sc.nextLine();
		Collections.sort(importes);
		return importes;
	}

}
