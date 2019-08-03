package projecteuler;

import java.math.BigInteger;

public class Problem097 {

	/**
	 * Calculates the last ten digits of 28433 * 2^7830457 + 1
	 */
	static void solution() {
		System.out.println((BigInteger.valueOf(2).modPow(BigInteger.valueOf(7830457), BigInteger.valueOf(10000000000L)).multiply(BigInteger.valueOf(28433)).add(BigInteger.ONE)).mod(BigInteger.valueOf(10000000000L)));
	}
}