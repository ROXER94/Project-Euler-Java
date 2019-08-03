package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem098 {

	/**
	 * Calculates the largest square number formed by any member of a pair of anagramic squares in the text file
	 */
	static void solution() {
		List<String> words = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p098_words.txt"))) {
			String[] word = br.readLine().replaceAll("\"", "").split(",");
			Arrays.stream(word).map(String::toString).forEach(words::add);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<List<String>> anagrams = new ArrayList<List<String>>();
		for (int i = 0; i < words.size() - 1; i++)
			for (int j = i + 1; j < words.size(); j++)
				if (Functions.isAnagram(words.get(i), words.get(j)))
					if (Functions.getDistinctString(words.get(i).toString()).length() == words.get(i).toString().length())
						anagrams.add(Functions.getTuple(words.get(i), words.get(j)));
		List<Integer> squares3 = new ArrayList<Integer>();
		for (int i = 10; i < 32; i++)
			squares3.add(i * i);
		List<List<Integer>> squares3Anagrams = new ArrayList<List<Integer>>();
		for (int i = 0; i < squares3.size() - 1; i++)
			for (int j = i + 1; j < squares3.size(); j++)
				if (Functions.isAnagram(squares3.get(i).toString(), squares3.get(j).toString()))
					if (Functions.getDistinctString(squares3.get(i).toString()).length() == squares3.get(i).toString().length())
						squares3Anagrams.add(Functions.getTuple(squares3.get(i), squares3.get(j)));
		List<Integer> squares4 = new ArrayList<Integer>();
		for (int i = 32; i < 100; i++)
			squares4.add(i * i);
		List<List<Integer>> squares4Anagrams = new ArrayList<List<Integer>>();
		for (int i = 0; i < squares4.size() - 1; i++)
			for (int j = i + 1; j < squares4.size(); j++)
				if (Functions.isAnagram(squares4.get(i).toString(), squares4.get(j).toString()))
					if (Functions.getDistinctString(squares4.get(i).toString()).length() == squares4.get(i).toString().length())
						squares4Anagrams.add(Functions.getTuple(squares4.get(i), squares4.get(j)));
		List<Integer> squares5 = new ArrayList<Integer>();
		for (int i = 100; i < 315; i++)
			squares5.add(i * i);
		List<List<Integer>> squares5Anagrams = new ArrayList<List<Integer>>();
		for (int i = 0; i < squares5.size() - 1; i++)
			for (int j = i + 1; j < squares5.size(); j++)
				if (Functions.isAnagram(squares5.get(i).toString(), squares5.get(j).toString()))
					if (Functions.getDistinctString(squares5.get(i).toString()).length() == squares5.get(i).toString().length())
						squares5Anagrams.add(Functions.getTuple(squares5.get(i), squares5.get(j)));
		List<Integer> squares6 = new ArrayList<Integer>();
		for (int i = 316; i < 1000; i++)
			squares6.add(i * i);
		List<List<Integer>> squares6Anagrams = new ArrayList<List<Integer>>();
		for (int i = 0; i < squares6.size() - 1; i++)
			for (int j = i + 1; j < squares6.size(); j++)
				if (Functions.isAnagram(squares6.get(i).toString(), squares6.get(j).toString()))
					if (Functions.getDistinctString(squares6.get(i).toString()).length() == squares6.get(i).toString().length())
						squares6Anagrams.add(Functions.getTuple(squares6.get(i), squares6.get(j)));
		List<Integer> ans = new ArrayList<Integer>();
		for (List<String> i : anagrams) {
			if ((i.get(0) + i.get(1)).length() / 2 == 3) {
				int a = i.get(1).indexOf(i.get(0).charAt(0));
				int b = i.get(1).indexOf(i.get(0).charAt(1));
				int c = i.get(1).indexOf(i.get(0).charAt(2));
				for (List<Integer> j : squares3Anagrams)
					if (a == j.get(1).toString().indexOf(j.get(0).toString().charAt(0)) && b == j.get(1).toString().indexOf(j.get(0).toString().charAt(1))
							&& c == j.get(1).toString().indexOf(j.get(0).toString().charAt(2)))
						ans.add(j.get(1));
			} else if ((i.get(0) + i.get(1)).length() / 2 == 4) {
				int a = i.get(1).indexOf(i.get(0).charAt(0));
				int b = i.get(1).indexOf(i.get(0).charAt(1));
				int c = i.get(1).indexOf(i.get(0).charAt(2));
				int d = i.get(1).indexOf(i.get(0).charAt(3));
				for (List<Integer> j : squares4Anagrams)
					if (a == j.get(1).toString().indexOf(j.get(0).toString().charAt(0)) && b == j.get(1).toString().indexOf(j.get(0).toString().charAt(1))
							&& c == j.get(1).toString().indexOf(j.get(0).toString().charAt(2))
							&& d == j.get(1).toString().indexOf(j.get(0).toString().charAt(3)))
						ans.add(j.get(1));
			} else if ((i.get(0) + i.get(1)).length() / 2 == 5) {
				int a = i.get(1).indexOf(i.get(0).charAt(0));
				int b = i.get(1).indexOf(i.get(0).charAt(1));
				int c = i.get(1).indexOf(i.get(0).charAt(2));
				int d = i.get(1).indexOf(i.get(0).charAt(3));
				int e = i.get(1).indexOf(i.get(0).charAt(4));
				for (List<Integer> j : squares5Anagrams)
					if (a == j.get(1).toString().indexOf(j.get(0).toString().charAt(0)) && b == j.get(1).toString().indexOf(j.get(0).toString().charAt(1))
							&& c == j.get(1).toString().indexOf(j.get(0).toString().charAt(2))
							&& d == j.get(1).toString().indexOf(j.get(0).toString().charAt(3))
							&& e == j.get(1).toString().indexOf(j.get(0).toString().charAt(4)))
						ans.add(j.get(1));
			} else if ((i.get(0) + i.get(1)).length() / 2 == 6) {
				int a = i.get(1).indexOf(i.get(0).charAt(0));
				int b = i.get(1).indexOf(i.get(0).charAt(1));
				int c = i.get(1).indexOf(i.get(0).charAt(2));
				int d = i.get(1).indexOf(i.get(0).charAt(3));
				int e = i.get(1).indexOf(i.get(0).charAt(4));
				int f = i.get(1).indexOf(i.get(0).charAt(5));
				for (List<Integer> j : squares6Anagrams)
					if (a == j.get(1).toString().indexOf(j.get(0).toString().charAt(0)) && b == j.get(1).toString().indexOf(j.get(0).toString().charAt(1))
							&& c == j.get(1).toString().indexOf(j.get(0).toString().charAt(2))
							&& d == j.get(1).toString().indexOf(j.get(0).toString().charAt(3))
							&& e == j.get(1).toString().indexOf(j.get(0).toString().charAt(4))
							&& f == j.get(1).toString().indexOf(j.get(0).toString().charAt(5)))
						ans.add(j.get(1));
			}
		}
		System.out.println(Collections.max(ans));
	}
}