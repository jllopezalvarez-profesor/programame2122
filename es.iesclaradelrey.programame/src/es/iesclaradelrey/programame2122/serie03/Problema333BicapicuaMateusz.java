package es.iesclaradelrey.programame2122.serie03;

import java.util.Scanner;

public class Problema333BicapicuaMateusz {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// el numero que escribimos por pantalla y una variable auxiliar que utilizo
		// como contador mas adelante
		long bicapicua, aux;

		// variables que usare mas adelante
		long posibleCapicua, restoCapicua;
		boolean resultado;
		while ((bicapicua = Long.parseLong(sc.nextLine())) != 0) {
			posibleCapicua = 0;
			resultado = false;
			aux = 0;
			while (bicapicua / 10 != 0) {
				// introduzco en posibleCapicua el ultimo numero de bicapicua y en restoCapicua
				// el resto de bicapicua
				// si bicapicua fuese 4224, posibleCapicua seria 4 y restoCapicua seria 422
				// asi seguira
				// la siguiente vuelta seria posibleCapicua 42 y restoCapicua seria 42
				// luego 422 y 4 (aqui terminaria el bucle)

				posibleCapicua = (posibleCapicua * 10) + bicapicua % 10;
				restoCapicua = bicapicua / 10;
				

				// cada 0 que aparezca sumara uno a aux
				if (posibleCapicua == 0) {
					aux++;
				}
				// con el metodo capicua compruebo que cada cacho de bicapicua sea capicua, si
				// es asi terminaria el bucle y se confirmaria q seria un numero bicapicua
				if (capicua(posibleCapicua) && capicua(restoCapicua)) {
					resultado = true;
					bicapicua = 0;
				}

				// si aparecen 2 o mas 0 seguidos estariamos hablando de un caso como 100, o
				// 1000. ...
				// que sin esto segun mi codigo aparecerian como SI siendo realmente NO
				if (aux >= 2) {
					resultado = false;
					bicapicua = 0;
				}
				bicapicua = bicapicua / 10;
			}
			if (resultado) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}
		}
	}

	// un metodo que simplemente invierte el numero
	public static long invertir(long capicua) {
		long invertido = 0;
		while (capicua != 0) {
			invertido = (invertido * 10) + (capicua % 10);
			capicua = capicua / 10;
		}
		return invertido;
	}

	// y aqui comprueba que el invertido sea igual al original
	public static boolean capicua(long capicua) {
		return capicua == invertir(capicua);
	}

}