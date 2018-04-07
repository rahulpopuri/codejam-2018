package p2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = in.nextInt();
        for (int i = 1; i <= numTestCases; i++) {
            if (in.hasNext()) {
                int numValues = in.nextInt();
                in.nextLine();
                if (numValues > 0) {
                    int[] input = new int[numValues];
                    for (int j = 1; j <= numValues; j++) {
                        input[j - 1] = in.nextInt();
                    }
                    troubleSort(input);
                    checkSorted(input, i);
                } else {
                    System.out.println("Case #" + i + ": " + "OK");

                }
            }
            in.nextLine();
            System.out.flush();
        }
    }

    private static void troubleSort(int[] input) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < input.length - 2; i++) {
                if (input[i] > input[i + 2]) {
                    done = false;
                    swap(input, i, i + 2);
                }
            }
        }
    }

    private static void swap(int[] input, int start, int end) {
        int tmp = input[end];
        input[end] = input[start];
        input[start] = tmp;
    }

    private static void checkSorted(int[] input, int caseNum) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {
                System.out.println("Case #" + caseNum + ": " + i);
                return;
            }
        }
        System.out.println("Case #" + caseNum + ": " + "OK");
    }
}
