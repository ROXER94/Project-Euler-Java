package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem059 {

	/**
	 * Calculates the sum of the ASCII values in the original message of the text file
	 */
	static void solution() {
		int ans = 0;
		List<String> cipher = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p059_cipher.txt"))) {
			String[] word = br.readLine().split(",");
			Arrays.stream(word).map(String::toString).forEach(cipher::add);
			for (int p1 = 97; p1 < 123; p1++)
				for (int p2 = 97; p2 < 123; p2++)
					for (int p3 = 97; p3 < 123; p3++) {
						List<Character> A = new ArrayList<Character>();
						List<Character> B = new ArrayList<Character>();
						List<Character> C = new ArrayList<Character>();
						StringBuilder text = new StringBuilder();
						for (int i = 0; i < cipher.size(); i++) {
							if (i % 3 == 0)
								A.add((char) (Integer.parseInt(cipher.get(i)) ^ p1));
							else if (i % 3 == 1)
								B.add((char) (Integer.parseInt(cipher.get(i)) ^ p2));
							else
								C.add((char) (Integer.parseInt(cipher.get(i)) ^ p3));
						}
						for (int i = 0; i < C.size(); i++) {
							text.append(A.get(i));
							text.append(B.get(i));
							text.append(C.get(i));
						}
						if (text.toString().contains(" the ")) {
							for (char c : text.toString().toCharArray())
								ans += (int) c;
							if (A.size() != C.size())
								ans += Integer.parseInt(cipher.get(cipher.size() - 1)) ^ p1;
							if (B.size() != C.size())
								ans += Integer.parseInt(cipher.get(cipher.size() - 2)) ^ p2;
							System.out.println(ans);
							return;
						}
					}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}