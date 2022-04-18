package es.iesclaradelrey.programame2122.serie04;

import java.util.Scanner;

public class Problema475Cameos {
	private static Scanner sc = new Scanner(System.in);
	private static final char[] STANLEE = { 's', 't', 'a', 'n', 'l', 'e', 'e' };
	private static final int NUM_LETRAS_STANLEE = 7;

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < numCasos; i++) {
			System.out.println(procesarCaso());
		}
	}

	private static int procesarCaso() {
		int numCameos = 0;
		
		// Inicializamos caracteres a buscar.
		int posCaracterBuscado = 0;
		char caracterBuscado = STANLEE[posCaracterBuscado];
		
		// Convertimos la línea en array de caracteres, y preparamos variable para almacenar el caracter de cada posición
		char[] linea = sc.nextLine().toLowerCase().toCharArray();
		char caracterActual;
		
		for (int i = 0; i < linea.length; i++) {
			caracterActual = linea[i];
			if (caracterActual == caracterBuscado)
			{
				posCaracterBuscado++;
				if (posCaracterBuscado == NUM_LETRAS_STANLEE)
				{
					numCameos++;
					posCaracterBuscado = 0;
				}
				caracterBuscado = STANLEE[posCaracterBuscado];
			}
		}
		return numCameos;
	}
}
