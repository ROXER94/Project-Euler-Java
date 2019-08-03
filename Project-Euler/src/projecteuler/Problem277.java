package projecteuler;

public class Problem277 {

	/**
	 * @param n
	 * @return the previous number in the modified Collatz sequence
	 */
	static double getModifiedCollatzDown(double n) {
		return 3 * n;
	}

	/**
	 * @param n
	 * @return the previous number in the modified Collatz sequence
	 */
	static double getModifiedCollatzUp(double n) {
		return (3 * n - 2) / 4;
	}

	/**
	 * @param n
	 * @return the previous number in the modified Collatz sequence
	 */
	static double getModifiedCollatzdown(double n) {
		return (3 * n + 1) / 2;
	}

	/**
	 * Calculates the smallest number greater than 10^15 that has a specific modified Collatz sequence
	 */
	static void solution() {
		double ans = 1;
		String s = new StringBuilder("UDDDUdddDDUDDddDdDddDDUDDdUUDd").reverse().toString();
		while (true) {
			double original = ans;
			for (char c : s.toCharArray()) {
				if (c == 'D') {
					ans = getModifiedCollatzDown(ans);
					if (ans % 1 != 0)
						break;
				} else if (c == 'U') {
					ans = getModifiedCollatzUp(ans);
					if (ans % 1 != 0)
						break;
				} else {
					ans = getModifiedCollatzdown(ans);
					if (ans % 1 != 0)
						break;
				}
			}
			if (ans % 1 == 0 && ans > Math.pow(10, 15))
				break;
			ans = original + 69;
		}
		System.out.println((long) ans);
	}
}