package com.stackroute;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSpan {

	// Do not print anything other than what's expected/asked in problem
	public static void main(String[] args) {
		// Use Scanner to get input from console
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] values = input.split(" ");
		int size = Integer.parseInt(values[0].trim());
		int[] numbers = new int[size];
		for (int i = 1; i <= size; i++) {
			numbers[i - 1] = Integer.parseInt(values[i].trim());
		}
		String output = findLongestSpan(numbers);
		if (output.equals("-1")) {
			System.out.println("Empty Array");
		} else {
			System.out.println(findLongestSpan(numbers));
		}
	}

	public static String findLongestSpan(int[] numbers) {

		if (numbers == null || numbers.length == 0)
			return "-1";

		HashMap<Integer, Integer> numSpan = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			int actSpan = 1;
			int tempSpan = 1;
			if (numSpan.containsKey(numbers[i])) {
				continue;
			}
			for (int j = i + 1; j < numbers.length; j++) {
				tempSpan += 1;
				if (numbers[i] == numbers[j]) {
					actSpan = tempSpan;
				}
			}

			numSpan.put(numbers[i], actSpan);
		}

		int actualValue = 0;
		int actualSpan = 0;

		for (int key : numSpan.keySet()) {
			if (numSpan.get(key) >= actualSpan) {
				actualSpan = numSpan.get(key);
				if (key > actualValue) {
					actualValue = key;
				}
			}

		}

		return actualValue + ":" + actualSpan;
	}
}
