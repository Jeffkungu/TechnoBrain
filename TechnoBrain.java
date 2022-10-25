import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;

public class TechnoBrain {
    public static void main(String[] args) {
        // fibonacciSequence(10);
        // reverseSentence("  One Two Three ");
        String csvFile = "1000,/logout,156.45.23,2000,/home,157.45.23,3000,/dashboard,158.45.23,4000,/signup,159.45.23,5000,/login,154.45.23";
        readCSVFile(csvFile);
    }

    public static int fibonacciSequence(int n) {
        /** Create array to store the int values */
        int[] fibArry = new int[n];

        /** 1st & 2nd values are 0 & 1 */
        fibArry[0] = 0;
        fibArry[1] = 1;

        for (int i = 2; i < n; i++) {
            fibArry[i] = fibArry[i - 1] + fibArry[i - 2];
        }

        /** Nth Fibonacci number is the last item in the array */
        System.out.println(String.format("The %d fibonacci number is %d", n, fibArry[n - 1]));

        return fibArry[n - 1];
    }

    public static List<String> readCSVFile(String csvFile) {
        /* Create variables that will store in the rows of the csv file*/
        String value = "";

        int timestamp = 0;
        String ipAddress = "";

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        /* Create variable that will keep count of the CSV columns.*/
        int csvColumn = 0;

        for (int i = 0; i < csvFile.length(); i++) {
            if (csvFile.charAt(i) == ',') {
                
                if (csvColumn == 0) {
                    int val = Integer.parseInt(value);
                    timestamp = val;
                    value = "";
                } else if (csvColumn == 2) {
                    ipAddress = value;
                    System.out.println("called");
                    System.out.println(map.size());
                    System.out.println(timestamp);
                    System.out.println(ipAddress);

                    map.put(timestamp, ipAddress);
                    value = "";
                    csvColumn = 0;
                } else {
                    value = "";
                }
                csvColumn += 1;
            } else {
                value += csvFile.charAt(i);
            }
        }
        System.out.println(map.size());

        List<Integer> timeStamps = new ArrayList<>();

        for (Map.Entry entry : map.entrySet()) {
            // System.out.println(entry.getKey());
            timeStamps.add((Integer) entry.getKey());
        }

        Object[] arr = timeStamps.toArray();
        Arrays.sort(arr, Collections.reverseOrder());

        List<String> ipAddresses = new ArrayList<>();

        if (arr.length >= 10) {
            for (int i = 0; i < 10; i++) {
                ipAddresses.add(map.get(arr[i]));
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                ipAddresses.add(map.get(arr[i]));
            }
        }

        // System.out.println(Arrays.toString(arr));
        return ipAddresses;
    }

    public static String reverseSentence(String sentence) {
        /* Create array to store the words. */
        List<String> wordsArry = new ArrayList<>();

        /* Create word variable to store each word. */
        String word = "";
        String reversedSentence = "";

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                wordsArry.add(word);
                word = "";
            } else {
                word += sentence.charAt(i);
            }
        }
        wordsArry.add(word);

        for (int i = wordsArry.size() - 1; i >= 0; i--) {
            if (i == 0) {
                reversedSentence += wordsArry.get(i);
            } else {
                reversedSentence += wordsArry.get(i);
                reversedSentence += " ";
            }
        }

        System.out.println(reversedSentence);

        return reversedSentence;
    }

}
