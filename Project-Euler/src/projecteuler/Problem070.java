package projecteuler;

public class Problem070 {

	/**
	 * Calculates the number under 10,000,000 for which the value of the number/phi(number) is minimized and phi(number) is a permutation of the number
	 */
	static void solution() {
		int ans = 0;
		double minimumValue = 1.5;
		for (int i = 2; i < 10000000; i++) {
			int totient = Functions.getPhi(i);
			double currentValue = (double) i / totient;
			String s = new Integer(i).toString();
			String t = new Integer(totient).toString();
			if (s.length() == t.length() && Functions.getSortedString(s).equals(Functions.getSortedString(t)) && currentValue < minimumValue) {
				minimumValue = currentValue;
				ans = i;
			}
		}
		System.out.println(ans);
	}
}