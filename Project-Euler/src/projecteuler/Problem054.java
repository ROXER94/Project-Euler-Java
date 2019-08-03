package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem054 {

	/**
	 * @param c
	 * @return the value of a card (Two = 2, ..., Ace = 14)
	 */
	static int getEvaluateCard(char c) {
		if (Character.isDigit(c))
			return (int) Character.getNumericValue(c);
		else if (c == 'T')
			return 10;
		else if (c == 'J')
			return 11;
		else if (c == 'Q')
			return 12;
		else if (c == 'K')
			return 13;
		else
			return 14;
	}

	static List<Integer> getEvaluateHand(String line) {
		List<Character> RoyalFlush = new ArrayList<Character>();
		RoyalFlush.addAll(Arrays.asList('T', 'J', 'Q', 'K', 'A'));
		int[] numbers = new int[] { getEvaluateCard(line.charAt(0)), getEvaluateCard(line.charAt(3)), getEvaluateCard(line.charAt(6)),
				getEvaluateCard(line.charAt(9)), getEvaluateCard(line.charAt(12)) };
		Arrays.sort(numbers);
		List<Long> numbersList = new ArrayList<Long>();
		for (int i : numbers)
			numbersList.add((long) i);
		// Same Suit
		if (line.charAt(1) == line.charAt(4) && line.charAt(4) == line.charAt(7) && line.charAt(7) == line.charAt(10) && line.charAt(10) == line.charAt(13)) {
			// Royal Flush
			if (RoyalFlush.contains(line.charAt(0)) && RoyalFlush.contains(line.charAt(3)) && RoyalFlush.contains(line.charAt(6))
					&& RoyalFlush.contains(line.charAt(9)) && RoyalFlush.contains(line.charAt(12)))
				return Functions.getTuple(10, 10);
			// Straight Flush
			if (numbers[0] + 4 == numbers[1] + 3 && numbers[1] + 3 == numbers[2] + 2 && numbers[2] + 2 == numbers[3] + 1 && numbers[3] + 1 == numbers[4])
				return Functions.getTuple(9, numbers[4]);
			// Flush
			else
				return Functions.getTuple(6, numbers[4]);
		}
		if (Arrays.stream(numbers).distinct().count() == 2) {
			int firstNumberCount = Functions.getOccurrenceOfValue(numbersList, (long) numbers[0]);
			if (firstNumberCount == 2 || firstNumberCount == 3)
				return Functions.getTuple(7, numbers[2]);
			// Four of a Kind
			else
				return Functions.getTuple(8, numbers[2]);
		}
		// Straight
		if (numbers[0] + 4 == numbers[1] + 3 && numbers[1] + 3 == numbers[2] + 2 && numbers[2] + 2 == numbers[3] + 1 && numbers[3] + 1 == numbers[4])
			return Functions.getTuple(5, numbers[4]);
		if (Arrays.stream(numbers).distinct().count() == 3) {
			// Three of a Kind
			int firstNumberCount = Functions.getOccurrenceOfValue(numbersList, (long) numbers[0]);
			int thirdNumberCount = Functions.getOccurrenceOfValue(numbersList, (long) numbers[2]);
			int lastNumberCount = Functions.getOccurrenceOfValue(numbersList, (long) numbers[4]);
			if (firstNumberCount == 3 || thirdNumberCount == 3 || lastNumberCount == 3)
				return Functions.getTuple(4, numbers[2]);
			// Two Pairs
			else
				return Functions.getTuple(3, Math.max(numbers[1], numbers[3]));
		}
		// One Pair
		if (Arrays.stream(numbers).distinct().count() == 4) {
			for (int i = 0; i < 4; i++)
				for (int j = i + 1; j < 5; j++)
					if (numbers[i] == numbers[j])
						return Functions.getTuple(2, numbers[i]);
			return null;
		} else
			// High Card
			return Functions.getTuple(1, numbers[4]);
	}

	/**
	 * Calculates the number of Poker hands that Player 1 wins
	 */
	static void solution() {
		int ans = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p054_poker.txt"))) {
			String line = br.readLine();
			while (line != null) {
				List<Integer> hand1 = getEvaluateHand(line.substring(0, 14));
				List<Integer> hand2 = getEvaluateHand(line.substring(15, 29));
				if (hand1.get(0) > hand2.get(0) || hand1.get(0) == hand2.get(0) && hand1.get(1) > hand2.get(1))
					ans++;
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ans);
	}
}