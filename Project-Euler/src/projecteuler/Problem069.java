package projecteuler;

public class Problem069 {

	/**
	 * Calculates the number under 1,000,000 for which the value of the number/phi(number) is maximized
	 */
	static void solution() {
		int ans = 0;
		double maximumValue = 0;
		for (int i = 1; i <= 1000000; i++) {
			double currentValue = (double) i / Functions.getPhi(i);
			if (currentValue > maximumValue) {
				maximumValue = currentValue;
				ans = i;
			}
		}
		System.out.println(ans);
	}
}