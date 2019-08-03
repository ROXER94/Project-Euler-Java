package projecteuler;

import java.text.DecimalFormat;

public class Problem587 {

	/**
	 * @param n
	 * @return the base of a trapezoid
	 */
	static double getTrapezoidBase(double n) {
		return 1 - Math.pow(1 - n * n, .5);
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return the solution to the quadratic equation: a * x^2 + b * x + c = 0
	 */
	static double getQuadraticSolution(int a, int b, int c) {
		return Double.parseDouble(new DecimalFormat("#.########").format((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a)));
	}

	/**
	 * Calculates the least value of n for which the concave triangle occupies less than 0.1% of the L-section
	 */
	static void solution() {
		int ans = 0;
		double blue = 1 - Math.PI / 4;
		while (true) {
			double y = getQuadraticSolution(ans * ans + 1, -(2 * ans + 2), 1);
			double x = y * ans;
			double dx = (1 - x) / 50;
			double area = 0;
			for (int i = 1; i <= (int) ((1 - x) / dx); i++)
				area += dx * (getTrapezoidBase((i - 1) * dx) + getTrapezoidBase(i * dx)) / 2;
			if ((area + x * y / 2) / blue < .001)
				break;
			ans++;
		}
		System.out.println(ans);
	}
}