package projecteuler;

public class Problem148 {

	/**
	 * @param n
	 * @param b
	 * @return the number of entries which are not divisible by 7 in the first n rows of Pascal's triangle
	 */
	static long getExplorePascal(long n, boolean b) {
		if (n < 7)
			return Functions.getTriangle((int) n);
		long b7 = n;
		if (b)
			b7 = Long.parseLong(Functions.getConvertBase(new Long(n).toString(), 10, 7));
		int n1 = new Long(b7).toString().charAt(0) - '0';
		long n2 = Long.parseLong(new Long(b7).toString().substring(1));
		return n1 * (n1 + 1) / 2 * (long) Math.pow(28, new Long(b7).toString().length() - 1) + (n1 + 1) * getExplorePascal(n2, false);
	}

	/**
	 * Calculates the number of entries which are not divisible by 7 in the first 1,000,000,000 rows of Pascal's triangle
	 */
	static void solution() {
		System.out.println(getExplorePascal(1000000000, true));
	}
}