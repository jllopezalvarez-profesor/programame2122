package es.iesclaradelrey.programame2122.clasificacion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Problema580FotoConMafalda {

	private static Scanner sc = new Scanner(System.in);
	private static Set<Personaje> enFoto = new HashSet<>();
	private static LinkedList<Personaje> enEspera = new LinkedList<>();

	public static void main(String[] args) {
		int numPersonajes;
		while ((numPersonajes = sc.nextInt()) != 0) {
			enEspera.clear();
			enFoto.clear();
			int numFotos = 0;
			int numPersonajesLeidos = 0;

			while (numPersonajesLeidos < numPersonajes) {
				buscarPersonajesEnEspera();
				numPersonajesLeidos = buscarPersonajesEnCola(numPersonajesLeidos, numPersonajes);

				if (fotoCompleta()) {
					numFotos++;
					enFoto.clear();
				}
			}

			System.out.printf("%d %d\n", numFotos, enEspera.size()+enFoto.size());
		}
	}

	private static int buscarPersonajesEnCola(int numPersonajesLeidos, int numPersonajes) {
		String nomPersonaje;
		Personaje p;
		
		while (numPersonajesLeidos < numPersonajes)
		{
			nomPersonaje = sc.next().trim();
			p = Personaje.valueOf(nomPersonaje);
			numPersonajesLeidos++;
			if (enFoto.contains(p)) {
				enEspera.add(p);
			} else {
				enFoto.add(p);
				if (fotoCompleta()) {
					break;
				}
			}
		}
		return numPersonajesLeidos;
	}

	/**
	 * Busca en la lista de espera TODOS los personajes que puede añadir al conjunto
	 * de la foto, los añade y los elimina de la lista de espera
	 */
	private static void buscarPersonajesEnEspera() {
		Iterator<Personaje> iterator = enEspera.iterator();
		while (iterator.hasNext()) {
			Personaje personaje = iterator.next();
			if (!enFoto.contains(personaje)) {
				enFoto.add(personaje);
				iterator.remove();
				if (fotoCompleta()) {
					return;
				}
			}
		}
	}

	private static boolean fotoCompleta() {
		return (enFoto.contains(Personaje.Mafalda) && enFoto.size() >= 3);
	}
}

enum Personaje {
	Mafalda, Felipe, Manolito, Susanita, Miguelito, Libertad, Guille
}
