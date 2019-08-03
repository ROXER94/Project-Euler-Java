package projecteuler;

public class Problem017 {

	/**
	 * Calculates the number of letters used in writing out all the numbers from 1 to 1000
	 */
	static void solution() {
		int OneTo9 = "onetwothreefourfivesixseveneightnine".length();
		int TenTo19 = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
		int Tens = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
		int OneTo99 = 10 * Tens + 9 * OneTo9 + TenTo19;
		int OneTo999 = 9 * 99 * "hundredand".length() + 100 * OneTo9 + 9 * "hundred".length() + 10 * OneTo99;
		System.out.println(OneTo999 + "onethousand".length());
	}
}