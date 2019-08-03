package projecteuler;

import java.util.HashSet;
import java.util.Set;

public class Problem074 {

	/**
	 * Calculates the number of starting numbers below 1,000,000 that produce a digit factorial chain of exactly sixty non-repeating terms
	 */
	static void solution() {
		int ans = 0;
		for (int i = 1; i < 1000000; i++) {
			int j = i;
			Set<Integer> chain = new HashSet<Integer>();
			int currentCount = 0;
			while (true) {
				chain.add(i);
				currentCount++;
				int digitFactorial = 0;
				for (char c : new Integer(i).toString().toCharArray())
					digitFactorial += Functions.getFactorial(c - '0').intValue();
				if (chain.contains(digitFactorial))
					break;
				i = digitFactorial;
			}
			if (currentCount == 60)
				ans++;
			i = j;
		}
		System.out.println(ans);
	}
}