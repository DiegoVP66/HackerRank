package rank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Result2 {

	/*
	 * Complete the 'miniMaxSum' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void miniMaxSum(List<Integer> arr) {
		long max = 0L, min = 0L;
		Collections.sort(arr);
		for (int i = 0, j = arr.size() - 1; i < arr.size() - 1; i++, j--) {
			max += arr.get(j);
			min += arr.get(i);

		}

		System.out.println(min + " " + max);

	}

}

public class MinMaxSum {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result2.miniMaxSum(arr);

		bufferedReader.close();
	}

}
