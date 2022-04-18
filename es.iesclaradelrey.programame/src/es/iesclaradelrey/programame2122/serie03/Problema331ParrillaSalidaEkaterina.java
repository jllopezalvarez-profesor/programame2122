package es.iesclaradelrey.programame2122.serie03;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Problema331ParrillaSalidaEkaterina {

	  static Scanner sc = new Scanner(System.in);
	    public static void main(String[] args){
	        parrilla();
	    }

	    private static void parrilla(){
	        boolean fin = false;
	        // Mientras que el siguiente número no sea 0 y haya más casos
	        while (!fin && sc.hasNext()){
	            int nums = sc.nextInt();
	            if(nums == 0){
	                fin = true;
	            }else {
	                // Se guarda en la variable si el caso es imposible o no
	                boolean imposible = false;
	                // Se crea un sorted map para poder guardar los valores de los puestos que ha subido o bajado el corredor y su nombre
	                SortedMap<Integer, String> corredores = new TreeMap<>();
	                // Se van añadiendo las posiciones iniciales y nombres de los corredores al mapa en tanto que no sea un caso imposible,
	                // es decir que la posición inicial sea mayor de 26
	                for (int i = 1; i <= nums; i++) {
	                    int puestos = sc.nextInt();
	                    String nombre = sc.nextLine();
	                    int posicion = i + puestos;
	                    if (posicion > 26) {
	                        imposible = true;
	                    } else {
	                        corredores.put(posicion, nombre);
	                    }

	                }
	                // Si el caso es imposible se imprime IMPOSIBLE, si no lo es se recorre el mapa (que está ordenado numéricamente de menor a mayor)
	                // y se imprime la posición del corredor y su nombre
	                if (imposible) {
	                    System.out.println("IMPOSIBLE");
	                } else {
	                    for (Map.Entry<Integer, String> corredor : corredores.entrySet()) {
	                        System.out.println((int) corredor.getKey() + corredor.getValue());
	                    }
	                }
	                System.out.println("-----");
	            }
	        }
	    }
}

