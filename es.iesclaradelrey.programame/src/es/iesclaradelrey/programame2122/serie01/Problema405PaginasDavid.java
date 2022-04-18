package es.iesclaradelrey.programame2122.serie01;

import java.util.ArrayList;
import java.util.Scanner;

public class Problema405PaginasDavid {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int primero = -1;
		do {
			primero = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			if (primero != 0) {
				ArrayList<Integer> paginas = leerPaginas(primero);

				int uno = paginas.get(0);
				int dos = -1;
				sb.append(uno);
				int contador = 1;
				boolean rango = false;
				for (int i = 1; i < paginas.size(); i++) {
					dos = paginas.get(i);
					if (uno + contador == dos) {
						contador++;
						rango = true;
					} else {
						if (rango == true) {
							sb.append("-");
							sb.append(paginas.get(i - 1));
							sb.append(",");
							sb.append(dos);
							uno = dos;
							rango = false;
							contador = 1;
						} else {
							sb.append(",");
							sb.append(dos);
							uno = dos;
						}
					}
				}
				if (rango == true) {
					sb.append("-");
					sb.append(dos);
				}
			}
			System.out.println(sb.toString());
		} while (primero != 0);

		sc.close();
	}

	private static ArrayList<Integer> leerPaginas(int i) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(i);
		int i2 = -1;
		do {
			i2 = sc.nextInt();
			if (i2 != 0) {
				a.add(i2);
			}
		} while (i2 != 0);
		return a;
	}
}