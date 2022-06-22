package rank;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result4 {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    // Write your code here
        /* 
    	*  First solution 
        
        List<Integer> result = new ArrayList<>();
        int qtt = 0;
          
         int Qsize = queries.size();
         int Ssize = strings.size();
         
         for(int i = 0; i < Qsize; i++){
          	qtt = 0;
             for(int j = 0; j < Ssize; j++){
                 if(strings.get(j).equals(queries.get(i))){
                     qtt++;
                 }
             }
             result.add(qtt);
         }
         */
         
         // second solution
         Map<String, Integer> result = new HashMap<>();
         strings.stream().forEach(key -> result.put(key, result.getOrDefault(key, 0)+ 1));   
         return queries.stream().map(qr -> result.getOrDefault(qr,0)).collect(Collectors.toList());
         
      

    }

}

public class SparseArrays {

	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result4.matchingStrings(strings, queries);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
