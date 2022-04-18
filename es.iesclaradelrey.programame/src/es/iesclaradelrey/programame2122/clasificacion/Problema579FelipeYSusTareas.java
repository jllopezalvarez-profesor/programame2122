package es.iesclaradelrey.programame2122.clasificacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problema579FelipeYSusTareas {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<TareaConPrioridad> tareas = new ArrayList<>();

	public static void main(String[] args) {
		int numTareas;
		int prioridad;
		int duracion;
		while ((numTareas = Integer.parseInt(sc.nextLine())) != 0) {
			tareas.clear();
			tareas.ensureCapacity(numTareas);

			for (int i = 0; i < numTareas; i++) {
				prioridad = sc.nextInt();
				duracion = sc.nextInt();
				sc.nextLine();
				tareas.add(new TareaConPrioridad(prioridad, duracion));
			}
			Collections.sort(tareas);
			for (TareaConPrioridad t : tareas) {
				System.out.println(t);
			}
			System.out.println("---");

		}
	}
}

class TareaConPrioridad implements Comparable<TareaConPrioridad> {
	private int prioridad;
	private int duracion;

	public TareaConPrioridad(int prioridad, int duracion) {
		this.prioridad = prioridad;
		this.duracion = duracion;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public int getDuracion() {
		return duracion;
	}

	@Override
	public int compareTo(TareaConPrioridad o) {
		if (this.prioridad > o.prioridad) {
			return -1;
		} else if (this.prioridad < o.prioridad) {
			return 1;
		} else if (this.duracion < o.duracion) {
			return -1;
		} else if (this.duracion > o.duracion) {
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public String toString() {
		return "" + prioridad + " " + duracion;
	}
}
