package projecteuler;

public class Problem035 {

	/**
	 * @param n
	 * @return True if n is a circular prime
	 */
	static boolean isCircularPrime(int n) {
		String s = new Integer(n).toString();
		if (s.length() == 1 || s.length() == 2
				&& Functions.isPrime(Integer.parseInt(s.substring(1) + s.substring(0, 1))) || s.length() == 3
				&& Functions.isPrime(Integer.parseInt(s.substring(1) + s.substring(0, 1)))
				&& Functions.isPrime(Integer.parseInt(s.substring(2) + s.substring(0, 2))) || s.length() == 4
				&& Functions.isPrime(Integer.parseInt(s.substring(1) + s.substring(0, 1)))
				&& Functions.isPrime(Integer.parseInt(s.substring(2) + s.substring(0, 2)))
				&& Functions.isPrime(Integer.parseInt(s.substring(3) + s.substring(0, 3))) || s.length() == 5
				&& Functions.isPrime(Integer.parseInt(s.substring(1) + s.substring(0, 1)))
				&& Functions.isPrime(Integer.parseInt(s.substring(2) + s.substring(0, 2)))
				&& Functions.isPrime(Integer.parseInt(s.substring(3) + s.substring(0, 3)))
				&& Functions.isPrime(Integer.parseInt(s.substring(4) + s.substring(0, 4))) || s.length() == 6
				&& Functions.isPrime(Integer.parseInt(s.substring(1) + s.substring(0, 1)))
				&& Functions.isPrime(Integer.parseInt(s.substring(2) + s.substring(0, 2)))
				&& Functions.isPrime(Integer.parseInt(s.substring(3) + s.substring(0, 3)))
				&& Functions.isPrime(Integer.parseInt(s.substring(4) + s.substring(0, 4)))
				&& Functions.isPrime(Integer.parseInt(s.substring(5) + s.substring(0, 5))))
			return true;
		return false;
	}

	/**
	 * Calculates the number of circular primes below 1,000,000
	 */
	static void solution() {
		int ans = 2;
		for (int p : Functions.getPrimesList(1000000))
			if (!new Integer(p).toString().contains("2") && !new Integer(p).toString().contains("5"))
				if (isCircularPrime(p))
					ans++;
		System.out.println(ans);
	}
}