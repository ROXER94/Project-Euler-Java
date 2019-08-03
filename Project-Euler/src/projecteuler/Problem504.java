package projecteuler;

public class Problem504 {

	/**
	 * Calculates the number of quadrilaterals that contain a square number of lattice points for a given range of coordinates
	 */
	static void solution() {
		int ans = 0;
		for (int a = 1; a <= 100; a++)
			for (int b = 1; b <= 100; b++)
				for (int c = 1; c <= 100; c++)
					for (int d = 1; d <= 100; d++)
						if (Functions.isSquare((a * b + b * c + c * d + d * a - Functions.getGCD(a, b) - Functions.getGCD(b, c) - Functions.getGCD(c, d) - Functions.getGCD(d, a)) / 2 + 1))
							ans++;
		System.out.println(ans);
	}
}