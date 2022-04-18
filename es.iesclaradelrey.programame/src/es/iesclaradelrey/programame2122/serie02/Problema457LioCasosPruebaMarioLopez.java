package es.iesclaradelrey.programame2122.serie02;

import java.util.Scanner;

public class Problema457LioCasosPruebaMarioLopez {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] nums;
		int n;

		while (sc.hasNext()) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}

			nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}

			int sol = nums.length;
			for (int i = 1; i < n; i++) {
				if (nums[i] == nums.length - (i + 1)) {
					sol = i;
					break;
				}
			}
			System.out.println(sol);
		}
	}
}
