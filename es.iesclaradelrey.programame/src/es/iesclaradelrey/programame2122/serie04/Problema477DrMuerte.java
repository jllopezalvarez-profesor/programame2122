package es.iesclaradelrey.programame2122.serie04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problema477DrMuerte {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int vitalidadDrMuerte;
		int numArmas;
		ArrayList<Arma> armas = new ArrayList<>();

		while ((vitalidadDrMuerte = Integer.parseInt(sc.nextLine())) != 0) {
			numArmas = Integer.parseInt(sc.nextLine());
			armas.clear();
			armas.ensureCapacity(numArmas);
			leerArmas(armas, numArmas);
			Collections.sort(armas);
			System.out.println(seleccionarArmas(armas, vitalidadDrMuerte));
		}

	}

	private static void leerArmas(ArrayList<Arma> armas, int numArmas) {
		// Empezamos por 1 para usar el índice para la posición
		for (int i = 1; i <= numArmas; i++) {
			int danioInocentes = Integer.parseInt(sc.next().trim());
			int danioVillanos = Integer.parseInt(sc.nextLine().trim());
			armas.add(new Arma(i, danioInocentes, danioVillanos));
		}
	}

	private static String seleccionarArmas(ArrayList<Arma> armas, int vitalidadDrMuerte) {
		StringBuilder salida = new StringBuilder();

		int danioInfligido = 0;
		int posUltimaArma = 0;
		int numArmas = armas.size();
		Arma armaActual = null;

		while ((posUltimaArma < numArmas) && (danioInfligido < vitalidadDrMuerte)) {
			armaActual = armas.get(posUltimaArma);
			danioInfligido += armaActual.getDanioVillanos();
			posUltimaArma++;
		}
		
		if (danioInfligido < vitalidadDrMuerte)
		{
			salida.append("MUERTE ESCAPA");
		}
		else
		{
			for (int i = 0; i < posUltimaArma; i++) {
				if (i > 0) {
					salida.append(" ");
				}
				salida.append(armas.get(i).getPosicionOriginal());
			}
		}
		return salida.toString();
	}

}

class Arma implements Comparable<Arma> {
	private int posicionOriginal;
	private int danioInocentes;
	private int danioVillanos;

	public Arma(int posicionOriginal, int danioInocentes, int danioVillanos) {
		this.posicionOriginal = posicionOriginal;
		this.danioInocentes = danioInocentes;
		this.danioVillanos = danioVillanos;
	}

	public int getPosicionOriginal() {
		return posicionOriginal;
	}

	public int getDanioInocentes() {
		return danioInocentes;
	}

	public int getDanioVillanos() {
		return danioVillanos;
	}

	@Override
	public int compareTo(Arma o) {

		int val = Integer.compare(this.danioInocentes, o.danioInocentes);
		if (val == 0) {
			// Lo negamos porque queremos que esté primero la que cause más daño.
			val = -Integer.compare(this.danioVillanos, o.danioVillanos);
			if (val == 0) {
				val = Integer.compare(this.posicionOriginal, o.posicionOriginal);
			}
		}
		return val;
	}

}
