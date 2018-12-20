package com.pickyourtrail.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 
 * @author Karthikeyan
 *
 */
public class MinimalUniqueArraySum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//The input can be in console or input.txt file as descriped in README file
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		int[] values = new int[size];
		
		for (int i = 0; i < size; i++) {
			values[i] = Integer.parseInt(reader.readLine());
		}

		System.out.println(getMinimumUniqueSum(values));

	}

	private static int getMinimumUniqueSum(int[] values) {
		// The running complexity would be O(n log n)
		Arrays.sort(values);

		/**
		 * This logic should work as the previous elements of the current positions are
		 * sorted and being unique, incrementing the current value more than the
		 * previous value would gives the unique array
		 **/
		
		// This would run in O(n) time
		int prev = values[0];
		for (int i = 1; i < values.length; i++) {

			if (prev >= values[i]) {
				values[i] = ++prev;
			}
			prev = values[i];
		}

		return Arrays.stream(values).sum();
	}
}
