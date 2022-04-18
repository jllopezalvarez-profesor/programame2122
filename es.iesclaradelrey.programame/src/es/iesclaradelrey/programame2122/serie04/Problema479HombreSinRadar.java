package es.iesclaradelrey.programame2122.serie04;

import java.util.Scanner;

public class Problema479HombreSinRadar {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int numFilas = Integer.parseInt(sc.next().trim());
		int numColumnas = Integer.parseInt(sc.nextLine().trim());
		while (numFilas != 0 && numColumnas != 0) {
			boolean[][] mapa = leerMapa(numFilas, numColumnas);
			procesarLecturas(mapa);
			System.out.println("---");
			numFilas = Integer.parseInt(sc.next().trim());
			numColumnas = Integer.parseInt(sc.nextLine().trim());
		}

	}

	private static void procesarLecturas(boolean[][] mapa) {
		int numLecturas = Integer.parseInt(sc.nextLine());
		while (numLecturas > 0) {
			int fila = Integer.parseInt(sc.next().trim());
			int columna = Integer.parseInt(sc.next().trim());
			Direccion direccion = Direccion.valueOf(sc.nextLine().trim());

			System.out.println(calcularDistancia(mapa, fila, columna, direccion));
			numLecturas--;
		}

	}

	private static String calcularDistancia(boolean[][] mapa, int fila, int columna, Direccion direccion) {

		// Ajustamos los valores con origen 1 a origen 0
		fila--;
		columna--;

		int variacionFila = 0;
		int variacionColumna = 0;

		switch (direccion) {
		case ARRIBA:
			variacionFila = -1;
			break;
		case ABAJO:
			variacionFila = 1;
			break;
		case IZQUIERDA:
			variacionColumna = -1;
			break;
		case DERECHA:
			variacionColumna = 1;
			break;
		}

		boolean encontrado = false;
		int distancia = 0;

		while (fila >= 0 && fila < mapa.length && columna >= 0 && columna < mapa[0].length && !encontrado) {
			if (mapa[fila][columna]) {
				encontrado = true;
			} else {
				fila += variacionFila;
				columna += variacionColumna;
				distancia++;
			}
		}

		if (encontrado) {
			return String.valueOf(distancia);

		}

		return "NINGUNO";

	}

	private static boolean[][] leerMapa(int numFilas, int numColumnas) {
		boolean[][] mapa = new boolean[numFilas][numColumnas];

		for (int fila = 0; fila < mapa.length; fila++) {
			char[] datosFila = sc.nextLine().toCharArray();
			for (int columna = 0; columna < mapa[fila].length; columna++) {
				if (datosFila[columna] == 'X') {
					mapa[fila][columna] = true;
				}
			}
		}
		return mapa;
	}

}

enum Direccion {
	IZQUIERDA, DERECHA, ARRIBA, ABAJO;
}
