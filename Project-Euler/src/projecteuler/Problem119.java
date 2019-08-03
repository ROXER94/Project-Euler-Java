package projecteuler;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem119 {

	/**
	 * @param n
	 * @return True if n is equal to the sum of its digits raised to some power
	 */
	static boolean isDigitPowerSum(long n) {
		int sum = 0;
		for (char c : new Long(n).toString().toCharArray())
			sum += c - '0';
		if (sum == 1)
			return false;
		while ((double) n / sum % 1 == 0)
			n /= sum;
		if (n == 1)
			return true;
		else
			return false;
	}

	/**
	 * Calculates the 30th number for which the sum of its digits is some number raised to a power
	 */
	static void solution() {
		SortedSet<Long> digitPowerSums = new TreeSet<Long>();
		for (int b = 3; b < 70; b++)
			for (int e = 3; e < 10; e++)
				if (isDigitPowerSum((long) Math.pow(b, e)))
					digitPowerSums.add((long) Math.pow(b, e));
		System.out.println(new ArrayList<Long>(digitPowerSums).get(29));
	}
}