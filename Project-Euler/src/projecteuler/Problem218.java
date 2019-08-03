package projecteuler;

import java.math.BigDecimal;

public class Problem218 {

	/**
	 * @param triangle
	 * @param limit
	 * @return the count of the perfect right-angled triangles with side c less than a limit that are not super-perfect
	 */
	static int getPerfectPrimitives(BigDecimal[][] triangle, int limit) {
		if (triangle[2][0].compareTo(BigDecimal.valueOf(limit)) > 0)
			return 0;
		BigDecimal[][] a = Problem101.getMatrixMultiplication(
				new BigDecimal[][] { new BigDecimal[] { BigDecimal.valueOf(1), BigDecimal.valueOf(-2), BigDecimal.valueOf(2) },
						new BigDecimal[] { BigDecimal.valueOf(2), BigDecimal.valueOf(-1), BigDecimal.valueOf(2) },
						new BigDecimal[] { BigDecimal.valueOf(2), BigDecimal.valueOf(-2), BigDecimal.valueOf(3) } }, triangle);
		BigDecimal[][] b = Problem101.getMatrixMultiplication(
				new BigDecimal[][] { new BigDecimal[] { BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(2) },
						new BigDecimal[] { BigDecimal.valueOf(2), BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
						new BigDecimal[] { BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(3) } }, triangle);
		BigDecimal[][] c = Problem101.getMatrixMultiplication(
				new BigDecimal[][] { new BigDecimal[] { BigDecimal.valueOf(-1), BigDecimal.valueOf(2), BigDecimal.valueOf(2) },
						new BigDecimal[] { BigDecimal.valueOf(-2), BigDecimal.valueOf(1), BigDecimal.valueOf(2) },
						new BigDecimal[] { BigDecimal.valueOf(-2), BigDecimal.valueOf(2), BigDecimal.valueOf(3) } }, triangle);
		BigDecimal area = triangle[0][0].multiply(triangle[1][0]).divide(BigDecimal.valueOf(2));
		if (Functions.isSquare(triangle[2][0].longValue()) && area.longValue() % 84 != 0)
			return 1 + getPerfectPrimitives(a, limit) + getPerfectPrimitives(b, limit) + getPerfectPrimitives(c, limit);
		else
			return getPerfectPrimitives(a, limit) + getPerfectPrimitives(b, limit) + getPerfectPrimitives(c, limit);
	}

	/**
	 * Calculates the number of perfect right-angled triangles that are not super-perfect
	 */
	static void solution() {
		System.out.println(getPerfectPrimitives(new BigDecimal[][] { new BigDecimal[] { BigDecimal.valueOf(3) }, new BigDecimal[] { BigDecimal.valueOf(4) },
				new BigDecimal[] { BigDecimal.valueOf(5) } }, (int) Math.pow(Math.pow(10, 16), (1 / 3))));
	}
}