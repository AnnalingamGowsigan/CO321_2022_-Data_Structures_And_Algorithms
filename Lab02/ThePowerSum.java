import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER X
     * 2. INTEGER N
     */

    public static int powerSum(int X, int N) {
        // Write your code here
        return helperForCalculatePower(X, N, 1);

    }

    public static int helperForCalculatePower(int total, int power, int number) {
        int value = (int) (total - Math.pow(number, power));

        if (value == 0) {
            return 1;
        }
        if (value < 0) {
            return 0;
        }
        return helperForCalculatePower(value, power, number + 1) + helperForCalculatePower(total, power, number + 1);
    }

}

public class ThePowerSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
