package projecteuler;

public class Problem075 {

	/**
	 * Calculates the number of values of L ≤ 1,500,000 as a perimeter for which exactly one integer sided right angle triangle can be formed
	 */
	static void solution() {
		int ans = 0;
		for (int L = 12; L <= 1500000; L += 2) {
			int currentCount = 0;
			int s = L / 2;
			int mlimit = (int) Math.pow(s, .5);
			for (int m = 2; m <= mlimit; m++)
				if (s % m == 0) {
					int sm = s / m;
					while (sm % 2 == 0)
						sm /= 2;
					int k;
					if (m % 2 == 1)
						k = m + 2;
					else
						k = m + 1;
					while (k < 2 * m && k <= sm) {
						if (sm % k == 0 && Functions.getGCD(k, m) == 1)
							currentCount++;
						k += 2;
					}
				}
			if (currentCount == 1)
				ans++;
		}
		System.out.println(ans);
	}
}