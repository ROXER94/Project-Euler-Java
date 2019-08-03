package projecteuler;

public class Problem193 {

	/**
	 * Calculates the number of squarefree numbers below 2^50
	 */
	static void solution() {
		long ans = 0;
		int[] M = Functions.getMoebius((int) Math.pow(2, 25));
		for (int i = 1; i <= (int) Math.pow(2, 25); i++)
			ans += (long) (M[i] * Math.pow(2, 50) / (1.0 * i * i));
		System.out.println(ans);
	}
}