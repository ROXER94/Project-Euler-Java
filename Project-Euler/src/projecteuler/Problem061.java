package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem061 {

	/**
	 * @param n
	 * @param m
	 * @param d
	 * @return True if the last d digits of n are the first d digits of the m
	 */
	static boolean isCyclicDigits(long n, long m, int d) {
		return new Long(n).toString().substring(new Long(n).toString().length() - d).equals(new Long(m).toString().substring(0, d));
	}

	/**
	 * Calculates the sum of the only set of six cyclic 4-digit numbers that contains a triangle, square, pentagonal, hexagonal, heptagonal, and octogonal
	 * number
	 */
	static void solution() {
		List<Long> triangles = new ArrayList<Long>();
		List<Long> squares = new ArrayList<Long>();
		List<Long> pentagons = new ArrayList<Long>();
		List<Long> hexagons = new ArrayList<Long>();
		List<Long> heptagons = new ArrayList<Long>();
		List<Long> octagons = new ArrayList<Long>();
		List<List<Long>> figurates = new ArrayList<List<Long>>();
		for (int i = 45; i <= 140; i++)
			triangles.add(Functions.getTriangle(i));
		for (int i = 32; i <= 99; i++)
			squares.add(Functions.getSquare(i));
		for (int i = 26; i <= 81; i++)
			pentagons.add(Functions.getPentagon(i));
		for (int i = 23; i <= 70; i++)
			hexagons.add(Functions.getHexagon(i));
		for (int i = 21; i <= 63; i++)
			heptagons.add(Functions.getHeptagon(i));
		for (int i = 19; i <= 58; i++)
			octagons.add(Functions.getOctagon(i));
		figurates.addAll(Arrays.asList(triangles, squares, pentagons, hexagons, heptagons, octagons));
		for (List<List<Long>> i : Functions.getPermutationsList(figurates)) {
			for (long a : i.get(0))
				for (long b : i.get(1))
					if (isCyclicDigits(a, b, 2))
						for (long c : i.get(2))
							if (isCyclicDigits(b, c, 2))
								for (long d : i.get(3))
									if (isCyclicDigits(c, d, 2))
										for (long e : i.get(4))
											if (isCyclicDigits(d, e, 2))
												for (long f : i.get(5))
													if (isCyclicDigits(e, f, 2))
														if (isCyclicDigits(f, a, 2)) {
															System.out.println(a + b + c + d + e + f);
															return;
														}
		}
	}
}