package projecteuler;

import java.util.HashSet;
import java.util.List;

public class Problem047 {

	/**
	 * @param n
	 * @return the distinct factors of n
	 */
	static HashSet<Long> getDistinctFactors(int n) {
		List<Long> primeFactors = Functions.getPrimeFactors(n);
		HashSet<Long> distinctFactors = new HashSet<Long>();
		for (long i : primeFactors) {
			int count = Functions.getOccurrenceOfValue(primeFactors, i);
			if (count == 1)
				distinctFactors.add(i);
			else
				distinctFactors.add(i * count);
		}
		return distinctFactors;
	}

	/**
	 * Calculates the first of four consecutive integers to have four distinct prime factors
	 */
	static void solution() {
		int ans = 1;
		while (true) {
			HashSet<Long> pfactors1 = getDistinctFactors(ans);
			if (pfactors1.size() == 4) {
				HashSet<Long> pfactors2 = getDistinctFactors(ans + 1);
				if (pfactors2.size() == 4) {
					HashSet<Long> pfactors3 = getDistinctFactors(ans + 2);
					if (pfactors3.size() == 4) {
						HashSet<Long> pfactors4 = getDistinctFactors(ans + 3);
						if (pfactors4.size() == 4) {
							HashSet<Long> currentPrimeFactors = pfactors1;
							for (long i : pfactors2) {
								if (currentPrimeFactors.contains(i))
									break;
								else
									currentPrimeFactors.add(i);
							}
							if (currentPrimeFactors.size() != 8)
								break;
							for (long i : pfactors3) {
								if (currentPrimeFactors.contains(i))
									break;
								else
									currentPrimeFactors.add(i);
							}
							if (currentPrimeFactors.size() != 12)
								break;
							for (long i : pfactors4) {
								if (currentPrimeFactors.contains(i))
									break;
								else
									currentPrimeFactors.add(i);
							}
							if (currentPrimeFactors.size() == 16)
								break;
						}
					}
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}