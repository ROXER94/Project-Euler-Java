package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem079 {

	/**
	 * Calculates the shortest possible secret passcode using the keylog information in the text file
	 */
	static void solution() {
		List<Integer[]> passcodes = Functions.getPermutationsArray(new Integer[] { 0, 1, 2, 3, 6, 7, 8, 9 });
		Set<String> keylog = new HashSet<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p079_keylog.txt"))) {
			String line = br.readLine();
			while (line != null) {
				keylog.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Integer[] i : passcodes)
			for (String j : keylog)
				if (Arrays.asList(i).indexOf(j.charAt(0) - '0') < Arrays.asList(i).indexOf(j.charAt(1) - '0')
						&& Arrays.asList(i).indexOf(j.charAt(1) - '0') < Arrays.asList(i).indexOf(j.charAt(2) - '0')) {
					if (j == keylog.toArray()[keylog.size() - 1])
						System.out.println(Arrays.toString(i).replaceAll("\\[|\\]|,|\\s", ""));
				} else
					break;
	}
}