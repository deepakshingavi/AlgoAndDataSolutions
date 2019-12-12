package com.training;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SparseArrays {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> stringsList = IntStream.range(0, stringsCount).mapToObj(i -> scanner.next()).collect(Collectors.toList());

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] res = IntStream.range(0, scanner.nextInt()).mapToObj(i -> scanner.next()).mapToLong(q -> stringsList.stream().filter(q::equals).count()).mapToInt(i -> (int)i).toArray();

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
