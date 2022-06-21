package rank;

//Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with 6 places after the decimal.
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'plusMinus' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void plusMinus(List<Integer> arr) {
		Locale.setDefault(Locale.US);
		double[] ar = { 0, 0, 0 };

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > 0) {
				ar[0] += 1;
			} else if (arr.get(i) < 0) {
				ar[1] += 1;
			} else {
				ar[2] += 1;
			}
		}

		for (int j = 0; j < ar.length; j++) {
			System.out.printf("%.6f\n", ar[j] / arr.size());
		}

	}

}

public class PlusMinus {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result.plusMinus(arr);

		bufferedReader.close();
	}

}
