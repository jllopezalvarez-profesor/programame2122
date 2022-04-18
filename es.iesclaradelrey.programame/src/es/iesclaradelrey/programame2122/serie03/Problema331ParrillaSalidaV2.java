package es.iesclaradelrey.programame2122.serie03;

import java.util.Arrays;
import java.util.Scanner;

public class Problema331ParrillaSalidaV2 {

	private static final int MAX_NUM_CORREDORES = 26;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCorredores;
		while ((numCorredores = Integer.parseInt(sc.nextLine())) != 0) {
			CorredorV2[] corredores = new CorredorV2[numCorredores];
			leerCorredores(corredores, numCorredores);
			Arrays.sort(corredores);
			CorredorV2 primero = corredores[0];
			CorredorV2 ultimo = corredores[corredores.length-1];

			if ((primero.getPosicionSalida() < 1) || (ultimo.getPosicionSalida() > MAX_NUM_CORREDORES)
					|| (hayRepetidos(corredores))) {
				System.out.println("IMPOSIBLE");
			} else {
				for (CorredorV2 corredor : corredores) {
					System.out.println(corredor);
				}
			}
			System.out.println("-----");
		}
	}

	private static boolean hayRepetidos(CorredorV2[] corredores) {
		int posAnteriorCorredor = Integer.MAX_VALUE;
		for (CorredorV2 corredor : corredores) {
			if (corredor.getPosicionSalida() == posAnteriorCorredor)
				return true;
			posAnteriorCorredor = corredor.getPosicionSalida();
		}
		return false;
	}

	private static void leerCorredores(CorredorV2[] corredores, int numCorredores) {
		String nombre;
		int puestosRemontados;
		for (int i = 0; i < numCorredores; i++) {
			puestosRemontados = Integer.parseInt(sc.next());
			nombre = sc.nextLine().trim();
			corredores[i] = new CorredorV2(i+1, puestosRemontados, nombre);
		}
	}
}

class CorredorV2 implements Comparable<CorredorV2> {
	int posicionLlegada;
	int puestosRemontados;
	int posicionSalida;
	String nombre;

	public CorredorV2(int posicionLlegada, int puestosRemontados, String nombre) {
		super();
		this.posicionLlegada = posicionLlegada;
		this.puestosRemontados = puestosRemontados;
		this.posicionSalida = posicionLlegada + puestosRemontados;
		this.nombre = nombre;
	}

	public int getPosicionSalida() {
		return posicionSalida;
	}

	@Override
	public int compareTo(CorredorV2 o) {
		if (this.getPosicionSalida() < o.getPosicionSalida()) {
			return -1;
		}
		if (this.getPosicionSalida() > o.getPosicionSalida()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return String.format("%d %s", this.getPosicionSalida(), this.nombre);
	}

}
