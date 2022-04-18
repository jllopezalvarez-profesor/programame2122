package es.iesclaradelrey.programame2122.serie02;

import java.util.Scanner;

public class Problema462MundoLimpio {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());
		while (numCasos > 0) {
			int numLimpiezas = sc.nextInt();
			String tiempo = sc.nextLine().trim();
			long numSegundos = getTotalSegundos(tiempo);
			printResultado(numLimpiezas*numSegundos);
			numCasos--;
		}
	}

	private static void printResultado(long numSegundos) {
		long numdias = numSegundos / 86400;
		long restoDias = numSegundos % 86400;
		long numHoras = (restoDias) / 3600;
		long restoHoras = restoDias % 3600;
		long numMinutos = restoHoras / 60;
		long numsegundos = (restoHoras % 60) % 60;
		System.out.printf("%d %02d:%02d:%02d\n", numdias, numHoras, numMinutos, numsegundos);

	}

	private static long getTotalSegundos(String tiempo) {
		String[] partes = tiempo.split(":");
		return Integer.parseInt(partes[0]) * 3600 + Integer.parseInt(partes[1]) * 60 + Integer.parseInt(partes[2]);
	}
}
