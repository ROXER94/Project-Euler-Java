package projecteuler;

public class Problem207 {

	/**
	 * Calculates the smallest m for which P(m) is less than 1/12345
	 */
	static void solution() {
		double ans = 1;
		while (true) {
			if ((int) (Math.log(ans + 1) / Math.log(2)) / ans < 1.0 / 12345)
				break;
			ans++;
		}
		ans *= ans + 1;
		System.out.println((long) ans);
	}
}