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

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int res = 0;
        int[] remain = new int[k];

        // Frequency of remainders
        for (int a : s) {
            remain[a % k]++;
        }

        for(int i = 1; i <= k / 2; i++) {
            /*
                To go through an example, let's say k is 7 and the remain array is smth like this
                remain = [1, 5, 6, 8, 1, 3, 0]
                The first index is the number of evenly divisible numbers. We don't care them yet.
                So, we start the i from 1.

                If the sum will be not evenly divisible by k, the sum of the remainders mustn't be k.
                So we need to choose the maximum from the pairs of sum of indexes (remainders) will result k.
                For example, in the array above, we cannot add 6 and 3 to the result.
                Because, 6 is at the index 2, so the count of the numbers that has 2 remainders is 6.
                And, 3 is at the index 4, so the count of the numbers that has 4 remainders is 3.
                We cannot add both of them, because the sum of any numbers from them will result a number divisible by 6.
                We need to choose max of them.
            */

            res += k - i == i ? 1 : Math.max(remain[i], remain[k - i]);

            /* If k - i == i, it means we are at the middle of the list
            Which means, sum of those elements that have k - i remainder will result 0 remainder
            E.g. If k = 4, and the list is [1, 2, 5, 3], we can't add 5 to the result
            Because sum of 2 number that has remainder of 2, will result a number that is divisible by 4
            The reason of adding 1 is, we can have only 1 number in the array that has remainder of 2
            Because result of summing will not be divisible by 4 for any pair.
            */
        }

        /*
        The reason of adding 1, if we have a evenly divisible number, is the same reason of adding 1
        When k - i == i. Because we can have 1 number that is divisible by k. So that, the result of
        any summing will not be divisible by k.
        */
        return remain[0] == 0 ? res : res + 1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
