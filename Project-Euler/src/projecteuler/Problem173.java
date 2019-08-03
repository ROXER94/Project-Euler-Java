package projecteuler;

public class Problem173 {

	/**
	 * Calculates the number of different square laminae that can be formed using up to 1,000,000 tiles
	 */
	static void solution() {
		int ans = 0;
		int n = 1000000;
		for (int l = 3; l <= n / 4 + 1; l++)
			for (int s = l - 2; s > 0; s -= 2) {
				if (l * l - s * s <= n)
					ans++;
				else
					break;
			}
		System.out.println(ans);
	}
}