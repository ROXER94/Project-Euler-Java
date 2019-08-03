package projecteuler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Problem086 {

	/**
	 * Calculates the minimum size of cuboids, up to a maximum size of N x N x N, for which the shortest path has integer length and the number of solutions
	 * first exceeds 1,000,000
	 */
	static void solution() {
		Set<Integer> primes = Functions.ToHashSet(Functions.getPrimesList(2000));
		Map<Integer, Integer> squaresDict = new HashMap<Integer, Integer>();
		for (int i = 1; i < 6000; i++)
			squaresDict.put(i, i * i);
		Map<Integer, Boolean> isSquareDict = new HashMap<Integer, Boolean>();
		int solutions = 2;
		for (int n = 1; n < 2000; n++)
			if (!primes.contains(n)) {
				int paths = 0;
				for (int a = 1; a <= n; a++)
					for (int b = a; b <= n; b++) {
						int side = squaresDict.get(a + b) + squaresDict.get(n);
						if (!isSquareDict.containsKey(side))
							isSquareDict.put(side, Functions.isSquare(side));
						if (isSquareDict.get(side))
							paths++;
					}
				solutions += paths;
				if (solutions > 1000000) {
					System.out.println(n);
					break;
				}
			}
	}
}