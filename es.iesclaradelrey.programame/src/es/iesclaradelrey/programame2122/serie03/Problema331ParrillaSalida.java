package es.iesclaradelrey.programame2122.serie03;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problema331ParrillaSalida {

	private static final int MAX_NUM_CORREDORES = 26;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		LinkedList<Corredor> corredores = new LinkedList<>();
		int numCorredores;
		while ((numCorredores = Integer.parseInt(sc.nextLine())) != 0) {
			corredores.clear();
			leerCorredores(corredores, numCorredores);
			Collections.sort(corredores);
			Corredor primero = corredores.peekFirst();
			Corredor ultimo = corredores.peekLast();

			if ((primero.getPosicionSalida() < 1) || (ultimo.getPosicionSalida() > MAX_NUM_CORREDORES)
					|| (hayRepetidos(corredores))) {
				System.out.println("IMPOSIBLE");
			} else {
				for (Corredor corredor : corredores) {
					System.out.println(corredor);
				}
			}
			System.out.println("-----");
		}
	}

	private static boolean hayRepetidos(LinkedList<Corredor> corredores) {
		int posAnteriorCorredor = Integer.MAX_VALUE;
		for (Corredor corredor : corredores) {
			if (corredor.getPosicionSalida() == posAnteriorCorredor)
				return true;
			posAnteriorCorredor = corredor.getPosicionSalida();
		}
		return false;
	}

	private static void leerCorredores(List<Corredor> corredores, int numCorredores) {
		String nombre;
		int puestosRemontados;
		for (int i = 1; i <= numCorredores; i++) {
			puestosRemontados = Integer.parseInt(sc.next());
			nombre = sc.nextLine().trim();
			corredores.add(new Corredor(i, puestosRemontados, nombre));
		}
	}
}

class Corredor implements Comparable<Corredor> {
	int posicionLlegada;
	int puestosRemontados;
	int posicionSalida;
	String nombre;

	public Corredor(int posicionLlegada, int puestosRemontados, String nombre) {
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
	public int compareTo(Corredor o) {
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
