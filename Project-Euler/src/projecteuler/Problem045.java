package projecteuler;

import java.util.HashSet;

public class Problem045 {

	/**
	 * Calculates the next Triangle, Pentagonal, and Hexagonal number after 40,755
	 */
	static void solution() {
		HashSet<Long> hexagons = new HashSet<Long>();
		for (int i = 144; i <= 50000; i++) {
			hexagons.add(Functions.getHexagon(i));
			if (hexagons.contains(Functions.getPentagon(i))) {
				System.out.println(Functions.getPentagon(i));
				break;
			}
		}
	}
}