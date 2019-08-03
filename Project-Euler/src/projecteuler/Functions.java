package projecteuler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class of useful functions
 */
public class Functions {

	// Helper Functions

	/**
	 * @param items
	 * @return a list representing a Tuple
	 */
	@SafeVarargs
	public static <T> List<T> getTuple(T... items) {
		List<T> tuple = new ArrayList<T>();
		for (T item : items)
			tuple.add(item);
		return tuple;
	}

	/**
	 * @param list
	 * @param n
	 * @return the number of occurrences of n in list
	 */
	public static int getOccurrenceOfValue(List<Long> list, long n) {
		int count = 0;
		for (long i : list)
			if (i == n)
				count++;
		return count;
	}

	/**
	 * @param input
	 * @return converts List to HashSet
	 */
	public static <T> Set<T> ToHashSet(List<T> input) {
		Set<T> hs = new HashSet<T>();
		for (T item : input)
			hs.add(item);
		return hs;
	}

	/**
	 * @param input
	 * @return the sum of the int input
	 */
	public static long getIntListSum(List<Integer> input) {
		if (input == null || input.size() < 1)
			return 0;
		long sum = 0;
		for (Integer i : input)
			sum += i;
		return sum;
	}

	/**
	 * @param input
	 * @return the sum of the long input
	 */
	public static long getLongListSum(List<Long> input) {
		if (input == null || input.size() < 1)
			return 0;
		long sum = 0;
		for (Long i : input)
			sum += i;
		return sum;
	}

	/**
	 * @param input
	 * @return All permutations of the input array
	 */
	public static <T extends Comparable<T>> List<T[]> getPermutationsArray(T[] input) {
		List<T[]> permutations = new ArrayList<T[]>();
		Arrays.sort(input);
		boolean hasNext = true;
		while (hasNext) {
			permutations.add(input.clone());
			int a = 0;
			int b = 0;
			hasNext = false;
			for (int i = input.length - 1; i > 0; i--) {
				if (input[i].compareTo(input[i - 1]) > 0) {
					a = i - 1;
					hasNext = true;
					break;
				}
			}
			for (int i = input.length - 1; i > a; i--) {
				if (input[i].compareTo(input[a]) > 0) {
					b = i;
					break;
				}
			}
			swap(input, a, b);
			Collections.reverse(Arrays.asList(input).subList(a + 1, input.length));
		}
		return permutations;
	}

	/**
	 * @param input
	 * @param a
	 * @param b
	 */
	public static <T> void swap(T[] input, int a, int b) {
		T tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

	/**
	 * @param input
	 * @return All permutations of the input list
	 */
	public static <T> List<List<T>> getPermutationsList(List<T> input) {
		if (input.size() == 0) {
			List<List<T>> result = new ArrayList<List<T>>();
			result.add(new ArrayList<T>());
			return result;
		}
		T firstElement = input.remove(0);
		List<List<T>> returnValue = new ArrayList<List<T>>();
		List<List<T>> permutations = getPermutationsList(input);
		for (List<T> smallerPermutated : permutations) {
			for (int index = 0; index <= smallerPermutated.size(); index++) {
				List<T> temp = new ArrayList<T>(smallerPermutated);
				temp.add(index, firstElement);
				returnValue.add(temp);
			}
		}
		return returnValue;
	}

	/**
	 * @param array
	 * @param row
	 * @return the row of an int[][] array
	 * @throws IndexOutOfBoundsException
	 */
	public static int[] getArrayRow(int[][] array, int row) throws IndexOutOfBoundsException {
		int width = array[0].length;
		int height = array.length;
		if (row >= height)
			throw new IndexOutOfBoundsException("Row index out of range");
		int[] returnRow = new int[width];
		for (int i = 0; i < width; i++)
			returnRow[i] = array[row][i];
		return returnRow;
	}

	/**
	 * @param array
	 * @param col
	 * @return the column of an int[][] array
	 * @throws IndexOutOfBoundsException
	 */
	public static int[] getArrayColumn(int[][] array, int col) throws IndexOutOfBoundsException {
		int width = array.length;
		int height = array[0].length;
		if (col >= height)
			throw new IndexOutOfBoundsException("Column index out of range");
		int[] returnCol = new int[width];
		for (int i = 0; i < width; i++)
			returnCol[i] = array[i][col];
		return returnCol;
	}

	/**
	 * @param input
	 * @return the sorted list of Integer lists
	 */
	public static List<List<Integer>> getSortedIntegerLists(List<List<Integer>> input) {
		return input.stream().sorted((o1, o2) -> {
			for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
				int c = o1.get(i).compareTo(o2.get(i));
				if (c != 0)
					return c;
			}
			return Integer.compare(o1.size(), o2.size());
		}).collect(Collectors.toList());
	}

	/**
	 * @param str
	 * @return the sorted string
	 */
	public static String getSortedString(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	/**
	 * @param str
	 * @return the distinct characters of str
	 */
	public static String getDistinctString(String str) {
		String temp = "";
		for (int i = 0; i < str.length(); i++)
			if (temp.indexOf(str.charAt(i)) == -1)
				temp = temp + str.charAt(i);
		return temp;
	}

	// Boolean Functions

	/**
	 * @param array
	 * @param exclude
	 * @return True if an array has duplicates, ignoring elements of the exclude array
	 */
	public static boolean hasDuplicates(int[] array, int[] exclude) {
		for (int i = 0; i < array.length - 1; i++)
			for (int j = i + 1; j < array.length; j++)
				if (array[i] == array[j] && (exclude.length == 0 || !contains(exclude, array[i])))
					return true;
		return false;
	}

	/**
	 * @param array
	 * @param target
	 * @return True if target is in array
	 */
	public static boolean contains(int[] array, int target) {
		for (int i : array)
			if (i == target)
				return true;
		return false;
	}

	/**
	 * @param str1
	 * @param str2
	 * @return True if str1 is an anagram of str2
	 */
	public static boolean isAnagram(String str1, String str2) {
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int n1 = c1.length;
		int n2 = c2.length;
		if (n1 != n2)
			return false;
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < n1; i++)
			if (c1[i] != c2[i])
				return false;
		return true;
	}

	/**
	 * @param str
	 * @return True if str is a palindrome
	 */
	public static boolean isPalindrome(String str) {
		int n = str.length();
		for (int i = 0; i < n / 2; ++i)
			if (str.charAt(i) != str.charAt(n - i - 1))
				return false;
		return true;
	}

	/**
	 * @param n
	 * @return True if n is 1-9 pandigital
	 */
	public static boolean isPandigital(long n) {
		String s = new Long(n).toString();
		return s.contains("1") && s.contains("2") && s.contains("3") && s.contains("4") && s.contains("5") && s.contains("6") && s.contains("7")
				&& s.contains("8") && s.contains("9");
	}

	/**
	 * @param n
	 * @return True if n is prime
	 */
	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		return IntStream.rangeClosed(2, (int) (Math.sqrt(n))).allMatch(i -> n % i != 0);
	}

	/**
	 * @param n
	 * @param s
	 * @return True if n is s-smooth
	 */
	public static boolean isSmooth(BigInteger n, int s) {
		for (long p : getPrimesList(s + 1))
			while (n.mod(BigInteger.valueOf(p)).equals(BigInteger.ZERO))
				n = n.divide(BigInteger.valueOf(p));
		return n.equals(BigInteger.ONE);
	}

	/**
	 * @param n
	 * @return True if n is a square
	 */
	public static boolean isSquare(long n) {
		return Math.sqrt(n) % 1 == 0;
	}

	/**
	 * @param n
	 * @param primes
	 * @return True if n is squarefree
	 */
	public static boolean isSquarefree(BigInteger n, List<Integer> primes) {
		for (int p : primes)
			if (n.mod(BigInteger.valueOf(p * p)).equals(BigInteger.ZERO))
				return false;
		return true;
	}

	// Getter Functions

	/**
	 * HashMap used to memoize the Factorial sequence
	 */
	public static Map<Integer, BigInteger> factDict = new HashMap<Integer, BigInteger>();

	/**
	 * @param n
	 * @return the Factorial of n via memoization
	 */
	public static BigInteger getFactorial(int n) {
		if (!factDict.containsKey(n))
			factDict.put(n, getFactorialUncached(n));
		return factDict.get(n);
	}

	/**
	 * @param n
	 * @return the Factorial of n via recursion
	 */
	public static BigInteger getFactorialUncached(int n) {
		if (n == 0)
			return BigInteger.ONE;
		else
			return BigInteger.valueOf(n).multiply(getFactorial(n - 1));
	}

	/**
	 * @param n
	 * @return the Factorial of n via memoization in constant space
	 */
	public static BigInteger getFactorial2(int n) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0)
				a = b.multiply(BigInteger.valueOf(i));
			else
				b = a.multiply(BigInteger.valueOf(i));
		}
		return n % 2 == 0 ? a : b;
	}

	/**
	 * HashMap used to memoize the Fibonacci sequence
	 */
	public static Map<Integer, BigInteger> fibDict = new HashMap<Integer, BigInteger>();

	/**
	 * @param n
	 * @return the nth Fibonacci number via memoization
	 */
	public static BigInteger getFibonacci(int n) {
		if (!fibDict.containsKey(n))
			fibDict.put(n, getFibonacciUncached(n));
		return fibDict.get(n);
	}

	/**
	 * @param n
	 * @return the nth Fibonacci number via recursion
	 */
	public static BigInteger getFibonacciUncached(int n) {
		if (n < 2)
			return BigInteger.valueOf(n);
		else
			return getFibonacci(n - 1).add(getFibonacci(n - 2));
	}

	/**
	 * @param n
	 * @return the nth Fibonacci number via memoization in constant space
	 */
	public static BigInteger getFibonacci2(int n) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				a = a.add(b);
			else
				b = b.add(a);
		}
		return n % 2 == 0 ? a : b;
	}

	/**
	 * @param n
	 * @return the nth Fibonacci number via Binet's Formula
	 */
	public static BigInteger getFibonacciBinet(int n) {
		BigDecimal goldenRatio = BigDecimal.ONE.add(BigDecimal.valueOf(Math.sqrt(5))).divide(BigDecimal.valueOf(2.0), MathContext.UNLIMITED);
		BigDecimal silverRatio = BigDecimal.ONE.subtract(BigDecimal.valueOf(Math.sqrt(5))).divide(BigDecimal.valueOf(2.0), MathContext.UNLIMITED);
		return goldenRatio.pow(n).subtract(silverRatio.pow(n)).divide(BigDecimal.valueOf(Math.sqrt(5)), MathContext.UNLIMITED).toBigInteger();
	}

	/**
	 * @param limit
	 * @return a list of primes less than the limit
	 */
	public static List<Integer> getPrimesList(int limit) {
		List<Integer> primes = new ArrayList<Integer>();
		boolean[] sieve = new boolean[limit];
		Arrays.fill(sieve, true);
		for (int i = 2; i < limit; i++)
			if (sieve[i]) {
				primes.add(i);
				for (int j = 2 * i; j < limit; j += i)
					sieve[j] = false;
			}
		return primes;
	}

	/**
	 * @param limit
	 * @return A hashMap of primes less than the limit
	 */
	public static Map<Integer, Boolean> getPrimesDict(int limit) {
		Map<Integer, Boolean> primesDict = new HashMap<Integer, Boolean>();
		boolean[] sieve = new boolean[limit];
		for (int i = 2; i < limit; i++)
			sieve[i] = true;
		for (long i = 2; i < limit; i++)
			if (sieve[(int) i]) {
				primesDict.put((int) i, true);
				for (long j = i * i; j < limit; j += i)
					sieve[(int) j] = false;
			}
		return primesDict;
	}

	/**
	 * @param n
	 * @return a sortedSet of the factors of n
	 */
	public static SortedSet<Long> getFactors(long n) {
		SortedSet<Long> factors = new TreeSet<Long>();
		for (long i = 1; i <= Math.sqrt(n); i++)
			if (n % i == 0) {
				factors.add(i);
				factors.add(n / i);
			}
		return factors;
	}

	/**
	 * @param n
	 * @return a list of the prime factors of n
	 */
	public static List<Long> getPrimeFactors(long n) {
		List<Long> primeFactors = new ArrayList<Long>();
		long i = 2;
		while (i * i <= n) {
			if (n % i != 0)
				i++;
			else {
				n /= i;
				primeFactors.add(i);
			}
		}
		if (n > 1)
			primeFactors.add(n);
		return primeFactors;
	}

	/**
	 * @param n
	 * @return A hashMap of the prime factors of n and the number of occurrences
	 */
	public static Map<Long, Integer> getOmega(long n) {
		Map<Long, Integer> factorsDict = new HashMap<Long, Integer>();
		List<Long> primeFactors = Functions.getPrimeFactors(n);
		for (long p : ToHashSet(primeFactors))
			factorsDict.put(p, Functions.getOccurrenceOfValue(primeFactors, p));
		return factorsDict;
	}

	/**
	 * @param n
	 * @return the totient function of n via Euler's product formula
	 */
	public static int getPhi(long n) {
		double phi = n;
		for (Long p : new HashSet<Long>(Functions.getPrimeFactors(n)))
			phi *= 1 - 1.0 / p;
		return (int) phi;
	}

	/**
	 * @param n
	 * @return the totient function of numbers from 0 to n
	 */
	public static int[] getTotients(int n) {
		int[] phi = new int[n + 1];
		phi[1] = 1;
		for (int i = 1; i <= n; i++)
			if (phi[i] == 0) {
				phi[i] = i - 1;
				for (int j = 2; j <= n / i; j++) {
					if (phi[j] != 0) {
						int q = j;
						int f = i - 1;
						while (q % i == 0) {
							f *= i;
							q /= i;
						}
						phi[i * j] = f * phi[q];
					}
				}
			}
		return phi;
	}

	/**
	 * @param n
	 * @param k
	 * @return the binomial coefficient: n Choose k
	 */
	public static BigInteger getnCk(int n, int k) {
		BigInteger r = BigInteger.ONE;
		if (k > n)
			return BigInteger.ZERO;
		for (int d = 1; d <= k; d++) {
			r = r.multiply(BigInteger.valueOf(n));
			n--;
			r = r.divide(BigInteger.valueOf(d));
		}
		return r;
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return the distance between (x1,y1) and (x2,y2)
	 */
	public static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return the slope between (x1,y1) and (x2,y2)
	 */
	public static double getSlope(double x1, double y1, double x2, double y2) {
		return (y2 - y1) / (x2 - x1);
	}

	/**
	 * @param n
	 * @param fromBase
	 * @param toBase
	 * @return the toBase representation of s in base fromBase
	 */
	public static String getConvertBase(String s, int fromBase, int toBase) {
		return Long.toString(Integer.parseInt(s, fromBase), toBase);
	}

	/**
	 * @param a
	 * @param b
	 * @return the Greatest Common Divisor of a and b
	 */
	public static long getGCD(long a, long b) {
		return b == 0 ? a : getGCD(b, a % b);
	}

	/**
	 * @param a
	 * @param b
	 * @return the Lowest Common Multiple of a and b
	 */
	public static long getLCM(long a, long b) {
		return a * b / getGCD(a, b);
	}

	/**
	 * @param a
	 * @param b
	 * @return the Extended Euclidean Algorithm: g (the divisor), a, and b, such that a * x + b * y = g
	 */
	public static List<Long> getExtendedGCD(Long a, Long b) {
		if (a == 0)
			return Functions.getTuple(b, 0L, 1L);
		List<Long> egcd = getExtendedGCD(b % a, a);
		return Functions.getTuple(egcd.get(0), egcd.get(2) - b / a * egcd.get(1), egcd.get(1));
	}

	/**
	 * @param a
	 * @param m
	 * @return the Modular Multiplicative Inverse of a and m: ax % m == 1
	 * @throws IllegalArgumentException
	 */
	public static long getModInverse(long a, long m) throws IllegalArgumentException {
		List<Long> egcd = getExtendedGCD(a, m);
		if (egcd.get(0) != 1)
			throw new IllegalArgumentException("Mod Inverse (a % m) does not exist");
		return egcd.get(1) % m < 0 ? (egcd.get(1) + m) % m : egcd.get(1) % m;
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @return the area of triangle abc
	 */
	public static double getHeron(double a, double b, double c) {
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	/**
	 * @param n
	 * @return the sum of squares of 1 to n
	 */
	public static int getSumOfSquares(int n) {
		return n * (n + 1) * (2 * n + 1) / 6;
	}

	/**
	 * @param n
	 * @return the probability of the leading digit n (1-9) of a set of numbers with large orders of magnitude via Benford's Law
	 */
	public static double getBenford(int n) {
		return Math.log10(1 + 1 / n);
	}

	/**
	 * @param n
	 * @return the n-th triangle number
	 */
	public static long getTriangle(int n) {
		return n * (n + 1) / 2;
	}

	/**
	 * @param n
	 * @return the n-th square number
	 */
	public static long getSquare(int n) {
		return n * n;
	}

	/**
	 * @param n
	 * @return the n-th pentagon number
	 */
	public static long getPentagon(int n) {
		return (long) n * (3 * n - 1) / 2;
	}

	/**
	 * @param n
	 * @return the n-th hexagon number
	 */
	public static long getHexagon(int n) {
		return n * (2 * n - 1);
	}

	/**
	 * @param n
	 * @return the n-th heptagon number
	 */
	public static long getHeptagon(int n) {
		return n * (5 * n - 3) / 2;
	}

	/**
	 * @param n
	 * @return the n-th octagon number
	 */
	public static long getOctagon(int n) {
		return n * (3 * n - 2);
	}

	/**
	 * SortedSet used to store the squarefree numbers
	 */
	static SortedSet<Long> sq = new TreeSet<Long>();

	/**
	 * @param product
	 * @param primeIndex
	 * @param primes
	 * @return the squarefree numbers from a list of primes
	 */
	public static SortedSet<Long> getSquarefrees(long product, int primeIndex, List<Integer> primes) {
		int prime = primes.get(primeIndex);
		if (prime < primes.get(primes.size() - 1)) {
			sq.addAll(getSquarefrees(product, primeIndex + 1, primes));
			sq.addAll(getSquarefrees(product * prime, primeIndex + 1, primes));
		} else {
			sq.add(product);
			sq.add(product * primes.get(primes.size() - 1));
		}
		return sq;
	}

	/**
	 * @param D
	 * @return the first solution of a given Pell's equation
	 */
	public static List<BigInteger> getPellSolution(long D) {
		BigInteger uCur = BigInteger.ZERO;
		BigInteger vCur = BigInteger.ONE;
		BigInteger a0 = BigDecimal.valueOf(Math.sqrt(D)).toBigInteger();
		BigInteger aCur = a0;
		BigInteger pCur = a0;
		BigInteger qCur = BigInteger.ONE;
		BigInteger pPrev = BigInteger.ONE;
		BigInteger qPrev = BigInteger.ZERO;
		int count = 0;
		while (aCur.compareTo(a0) <= 0) {
			BigInteger uNext = aCur.multiply(vCur).subtract(uCur);
			BigInteger vNext = (BigInteger.valueOf(D).subtract(uNext.pow(2))).divide(vCur);
			BigInteger aNext = a0.add(uNext).divide(vNext);
			BigInteger pNext = aNext.multiply(pCur).add(pPrev);
			BigInteger qNext = aNext.multiply(qCur).add(qPrev);
			pPrev = pCur;
			qPrev = qCur;
			uCur = uNext;
			vCur = vNext;
			aCur = aNext;
			pCur = pNext;
			qCur = qNext;
			count++;
		}
		if (count % 2 == 0)
			return Functions.getTuple(pPrev, qPrev);
		else
			return Functions.getTuple(pPrev.pow(2).add(BigInteger.valueOf(D).multiply(qPrev.pow(2))), BigInteger.valueOf(2).multiply(pPrev.multiply(qPrev)));
	}

	/**
	 * @param n
	 * @return an array containing the Moebius Function values from 0 to n
	 */
	public static int[] getMoebius(int n) {
		int[] mu = new int[n + 1];
		for (int i = 0; i <= n; i++)
			mu[i] = 1;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (mu[i] == 1) {
				for (int j = i; j <= n; j += i)
					mu[j] *= -i;
				for (int j = i * i; j <= n; j += i * i)
					mu[j] *= 0;
			}
		}
		for (int i = 2; i <= n; i++) {
			if (mu[i] == i)
				mu[i] = 1;
			else if (mu[i] == -i)
				mu[i] = -1;
			else if (mu[i] < 0)
				mu[i] = 1;
			else if (mu[i] > 0)
				mu[i] = -1;
		}
		return mu;
	}

	/**
	 * @param a
	 * @param n
	 * @return the Multiplicative Order of a and n: smallest k such that a^k ≡ 1 (mod n)
	 * @throws IllegalArgumentException
	 */
	public static int getMultiplicativeOrder(int a, long n) throws IllegalArgumentException {
		if (n < 2)
			throw new IllegalArgumentException("Integer modulus n must be greater than 1");
		if (Functions.getGCD(a, n) != 1)
			throw new IllegalArgumentException("Integers a and n are not relatively prime integers");
		long r = 1;
		int k = 1;
		while (k < n) {
			r = r * a % n;
			if (r == 1)
				return k;
			k++;
		}
		throw new IllegalArgumentException("Integer overflow");
	}

	/**
	 * @param n
	 * @return the radical of n
	 */
	public static int getRadical(int n) {
		int radical = 1;
		for (long p : ToHashSet(Functions.getPrimeFactors(n)))
			radical *= p;
		return radical;
	}

	/**
	 * Array used to memoize the last non-zero digit in a factorial
	 */
	static int[] factorialLastDigitDict = { 1, 1, 2, 6, 4, 2, 2, 4, 2, 8 };

	/**
	 * @param n
	 * @return the last non-zero digit of n!
	 */
	public static long getFactorialLastDigit(long n) {
		if (n < 10)
			return factorialLastDigitDict[(int) n];
		if (((n / 10) % 10) % 2 == 0)
			return (6 * getFactorialLastDigit(n / 5) * factorialLastDigitDict[(int) (n % 10)]) % 10;
		else
			return (4 * getFactorialLastDigit(n / 5) * factorialLastDigitDict[(int) (n % 10)]) % 10;
	}

	/**
	 * @param relativePrimes
	 * @param remainders
	 * @return the minimum solution to a system of simultaneous linear congruences via the Chinese Remainder Theorem
	 * @throws IllegalArgumentException
	 */
	public static long getChineseRemainderTheorem(List<Integer> relativePrimes, List<Integer> remainders) throws IllegalArgumentException {
		if (relativePrimes.size() <= 1)
			throw new IllegalArgumentException("Length of array of relative primes must be greater than one");
		if (relativePrimes.size() != remainders.size())
			throw new IllegalArgumentException("Array of relative primes and array of remainders are not the same length");
		for (int i = 0; i < relativePrimes.size() - 1; i++)
			for (int j = i + 1; j < relativePrimes.size(); j++)
				if (Functions.getGCD(relativePrimes.get(i), relativePrimes.get(j)) != 1)
					throw new IllegalArgumentException("Array of relative primes is not a collection of pairwise relatively prime integers");
		long M = 1;
		long crm = 0;
		List<Long> mList = new ArrayList<Long>();
		List<Long> yList = new ArrayList<Long>();
		for (int p : relativePrimes)
			M *= p;
		for (int p : relativePrimes) {
			mList.add(M / p);
			yList.add(Functions.getModInverse(M / p, p));
		}
		for (int i = 0; i < relativePrimes.size(); i++)
			crm += remainders.get(i) * mList.get(i) * yList.get(i);
		return crm % M;
	}
}