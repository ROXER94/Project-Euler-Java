package projecteuler;

import java.util.ArrayList;

public class Problem021 {

	/**
	 * Calculates the sum of all amicable numbers under 10,000
	 */
	static void solution() {
		int ans = 0;
		for (int i = 1; i < 10000; i++) {
			int s = (int) (Functions.getLongListSum(new ArrayList<Long>(Functions.getFactors(i)))) - i;
			int d = (int) (Functions.getLongListSum(new ArrayList<Long>(Functions.getFactors(s)))) - s;
			if (i == d && s != d)
				ans += i;
		}
		System.out.println(ans);
	}
}