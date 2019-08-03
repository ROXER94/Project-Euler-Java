package projecteuler;

import java.util.List;

public class Problem204 {

	/**
	 * @param index
	 * @param value
	 * @param primes
	 * @param limit
	 * @return the count of generalised Hamming numbers which don't exceed a limit
	 */
	static int getHammingCount(int index, long value, List<Integer> primes, int limit) {
		int count = 0;
		while (value <= limit) {
			if (index == primes.size()) {
				count++;
				break;
			}
			count += getHammingCount(index + 1, value, primes, limit);
			value *= primes.get(index);
		}
		return count;
	}

	/**
	 * Calculates the number of generalised Hamming numbers of type 100 which don't exceed 10^9
	 */
	static void solution() {
		System.out.println(getHammingCount(0, 1L, Functions.getPrimesList(100), 1000000000));
	}
}