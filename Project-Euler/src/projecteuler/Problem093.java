package projecteuler;

import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Problem093 {

	/**
	 * @param expression
	 * @return the result of the Reverse Polish Notation expression
	 * @throws IllegalArgumentException
	 */
	static double getReversePolishNotation(String[] expression) throws IllegalArgumentException {
		Stack<Double> stack = new Stack<Double>();
		for (String s : expression) {
			if (s == "+" || s == "-" || s == "*" || s == "/") {
				if (s == "+") {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b + a);
				} else if (s == "-") {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b - a);
				} else if (s == "*") {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b * a);
				} else if (s == "/") {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b / a);
				}
			} else
				stack.push(Double.parseDouble(s));
		}
		if (Double.isInfinite(stack.peek()) || Double.isNaN(stack.peek()))
			throw new IllegalArgumentException("Division by constant zero");
		return stack.peek();
	}

	/**
	 * Calculates the set of four distinct digits for which the longest set of consecutive positive integers from 1 to n can be obtained using arithmetic
	 * operators
	 */
	static void solution() {
		int ans = 0;
		int limit = 10;
		int consecutiveCount = 0;
		for (int a = 1; a < limit; a++)
			for (int b = a + 1; b < limit; b++)
				for (int c = b + 1; c < limit; c++)
					for (int d = c + 1; d < limit; d++) {
						SortedSet<Double> RPN = new TreeSet<Double>();
						for (String op1 : new String[] { "+", "-", "*", "/" })
							for (String op2 : new String[] { "+", "-", "*", "/" })
								for (String op3 : new String[] { "+", "-", "*", "/" })
									for (String[] i : Functions.getPermutationsArray(new String[] { new Integer(a).toString(), new Integer(b).toString(),
											new Integer(c).toString(), new Integer(d).toString() })) {
										try {
											RPN.add(getReversePolishNotation(new String[] { i[0], i[1], op1, i[2], op2, i[3], op3 }));
										} catch (Exception e) {
										}
										try {
											RPN.add(getReversePolishNotation(new String[] { i[0], i[1], i[2], op1, op2, i[3], op3 }));
										} catch (Exception e) {
										}
										try {
											RPN.add(getReversePolishNotation(new String[] { i[0], i[1], op1, i[2], i[3], op2, op3 }));
										} catch (Exception e) {
										}
									}
						RPN.removeIf(n -> n <= 0 || n % 1 != 0);
						Double[] rpn = RPN.toArray(new Double[RPN.size()]);
						int currentCount = 0;
						for (int i = 0; i < RPN.size() - 1; i++) {
							if (rpn[i] + 1 == rpn[i + 1])
								currentCount++;
							else
								break;
						}
						if (currentCount > consecutiveCount) {
							consecutiveCount = currentCount;
							ans = 1000 * a + 100 * b + 10 * c + d;
						}
					}
		System.out.println(ans);
	}
}