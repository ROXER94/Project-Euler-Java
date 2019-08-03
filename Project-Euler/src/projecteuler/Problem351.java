package projecteuler;

public class Problem351 {

	/**
	 * Calculates the number of points hidden from the center in a hexagonal orchard of order 100,000,000
	 */
	static void solution() {
		long ans = Functions.getnCk(100000001, 2).longValue();
		for (int i : Functions.getTotients(100000000))
			ans -= i;
		ans *= 6;
		System.out.println(ans);
	}
}