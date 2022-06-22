package rank;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Result3 {

	/*
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String timeConversion(String s) {
		// Write your code here
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		try {
			Date dt = sd.parse(s);
			String txt = dt.toString().substring(11, 19);
			if (s.contains("PM") && !s.startsWith("12") || s.contains("12") && s.contains("AM")) {
				cal.setTime(dt);
				cal.add(Calendar.HOUR_OF_DAY, 12);
				txt = cal.getTime().toString().substring(11, 19);
				return txt;
			}
			return txt;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}

public class TimeConversion {
	public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * String s = bufferedReader.readLine();
		 * 
		 * String result = Result3.timeConversion(s);
		 * 
		 * bufferedWriter.write(result); bufferedWriter.newLine();
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */

		Scanner sc = new Scanner(System.in);

		String s = "12:45:54PM";
		String result = Result3.timeConversion(s);
		System.out.println(result);

		sc.close();
	}
}
