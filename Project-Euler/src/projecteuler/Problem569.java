package projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem569 {

	/**
	 * HashMap used to memoize the prime peaks counts
	 */
	static Map<Integer, List<Integer>> primePeakDict = new HashMap<Integer, List<Integer>>();

	/**
	 * @param n
	 * @param primePeaks
	 * @param primePeakDict
	 * @return the number of prime peaks that are visible from peak n
	 */
	static int getPrimePeakCount(int n, List<List<Long>> primePeaks, Map<Integer, List<Integer>> primePeakDict) {
		List<Integer> currentPrimePeaks = new ArrayList<Integer>();
		currentPrimePeaks.add(n - 1);
		primePeakDict.put(n, currentPrimePeaks);
		double currentMinSlope = Functions.getSlope(primePeaks.get(n - 1).get(0), primePeaks.get(n - 1).get(1), primePeaks.get(n).get(0), primePeaks.get(n).get(1));
		Set<Integer> potentiallyVisible = Functions.ToHashSet(primePeakDict.get(n - 1));
		while (potentiallyVisible.size() != 0) {
			int currentPeak = Collections.max(potentiallyVisible);
			double currentSlope = Functions.getSlope(primePeaks.get(currentPeak).get(0), primePeaks.get(currentPeak).get(1), primePeaks.get(n).get(0), primePeaks.get(n).get(1));
			if (currentSlope < currentMinSlope) {
				currentMinSlope = currentSlope;
				primePeakDict.get(n).add(currentPeak);
				potentiallyVisible.addAll(primePeakDict.get(currentPeak));
			}
			potentiallyVisible.remove(currentPeak);
		}
		if (n > 40000)
			primePeakDict.remove(n - 40000);
		return primePeakDict.get(n).size();
	}

	/**
	 * Calculates the number of peaks that are visible looking back from the kth mountain for 1 ≤ k ≤ 2500000
	 */
	static void solution() {
		int ans = 0;
		List<List<Long>> primePeaks = new ArrayList<List<Long>>();
		List<Integer> primes = Functions.getPrimesList(90000000);
		long x = 0;
		long y = 0;
		primePeaks.add(Functions.getTuple(x, y));
		primePeakDict.put(1, new ArrayList<Integer>());
		for (int i = 0; i < primes.size() - 1; i += 2) {
			x += primes.get(i);
			y += primes.get(i);
			primePeaks.add(Functions.getTuple(x, y));
			x += primes.get(i + 1);
			y -= primes.get(i + 1);
		}
		for (int i = 2; i <= 2500000; i++)
			ans += getPrimePeakCount(i, primePeaks, primePeakDict);
		System.out.println(ans);
	}
}