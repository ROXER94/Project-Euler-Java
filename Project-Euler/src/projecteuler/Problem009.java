package projecteuler;

public class Problem009 {

	/**
	 * Calculates the product of a Pythagorean triplet that sums to 1000
	 */
	static void solution() {
		for (int a = 1; a < 500; a++)
			for (int b = a + 1; b < 500; b++)
				if (a + b + Math.sqrt(a * a + b * b) == 1000)
					System.out.println(a * b * (int) Math.sqrt(a * a + b * b));
	}
}