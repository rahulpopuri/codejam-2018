package p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int damage = in.nextInt();
            String sequence = in.nextLine();
            sequence = sequence.trim();

            int d = calculateDamage(sequence);
            int count = 0;
            boolean skip = false;
            while (d > damage) {
                //need to swap some things to make it less than damage
                sequence = swapFirst(sequence);
                if (sequence == null) {
                    System.out.println("Case #" + i + ": " + "Impossible");
                    skip = true;
                    break;
                }
                d = calculateDamage(sequence);
                count++;
            }
            if (!skip) {
                System.out.println("Case #" + i + ": " + count);
            }

        }
    }

    private static int calculateDamage(String s) {

        char[] values = s.toCharArray();
        int damage = 0;
        int charge = 1;
        for (char c : values) {
            if (c == 'C') { //charge
                charge = charge * 2;
            }
            if (c == 'S') { //shoot
                damage += charge;
            }
        }
        return damage;
    }

    /*
    Swap the first instance of 'CS'
     */
    private static String swapFirst(String sequence) {
        int firstIndex = sequence.indexOf("CS");
        if (firstIndex < 0) {
            return null;
        }
        return sequence.replaceFirst("CS", "SC");
    }

}
