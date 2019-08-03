package projecteuler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem203 {

	/**
	 * @param n
	 * @param r
	 * @return the number located at (n,r) in Pascal's triangle
	 */
	static BigInteger getPascal(int n, int r) {
		return Functions.getnCk(n - 1, r).add(Functions.getnCk(n - 1, r - 1));
	}

	/**
	 * Calculates the sum of the distinct squarefree numbers in the first 51 rows of Pascal's triangle
	 */
	static void solution() {
		BigInteger ans = BigInteger.ONE;
		List<Integer> primes = Functions.getPrimesList(8);
		Set<BigInteger> PascalTriangle = new HashSet<BigInteger>();
		for (int i = 2; i < 51; i++)
			for (int j = 1; j < i; j++)
				PascalTriangle.add(getPascal(i, j));
		for (BigInteger i : PascalTriangle)
			if (Functions.isSquarefree(i, primes))
				ans = ans.add(i);
		System.out.println(ans);
	}
}