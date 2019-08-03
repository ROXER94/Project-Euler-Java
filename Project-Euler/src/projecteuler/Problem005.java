package projecteuler;

public class Problem005 {

	/**
	 * Calculates the smallest positive number that is evenly divisible by all numbers from 1 to 20
	 */
	static void solution() {
		long ans = 1;
		for (int i = 2; i <= 20; i++)
			ans = Functions.getLCM(i, ans);
		System.out.println(ans);
	}
}