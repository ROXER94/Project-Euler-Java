package projecteuler;

public class Problem033 {

	/**
	 * Calculates the simplified denominator of the product of all two-digit digit-cancelled fractions
	 */
	static void solution() {
		double ans = 1;
		for (int N = 11; N < 100; N++)
			for (int D = N + 1; D <= 100; D++) {
				String n = new Integer(N).toString();
				String d = new Integer(D).toString();
				if (d.charAt(1) != '0')
					if (n.charAt(0) == d.charAt(0)
							&& (double) ((n.charAt(1)) - '0') / (d.charAt(1) - '0') == (double) N / D
							|| n.charAt(0) == d.charAt(1)
							&& (double) ((n.charAt(1)) - '0') / (d.charAt(0) - '0') == (double) N / D
							|| n.charAt(1) == d.charAt(0)
							&& (double) ((n.charAt(0)) - '0') / (d.charAt(1) - '0') == (double) N / D
							|| n.charAt(1) == d.charAt(1)
							&& (double) ((n.charAt(0)) - '0') / (d.charAt(0) - '0') == (double) N / D)
						ans *= (double) D / N;
			}
		System.out.println((int) ans);
	}
}