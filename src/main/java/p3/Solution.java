package p3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = in.nextInt();
        for (int t = 1; t <= numTestCases; t++) {
            int rectSize = in.nextInt();
            // min grid has to be 3x3
            int rows = 3, cols = 3;
            while (rows * rows < rectSize) {
                rows++;
                cols++;
            }
            while (cols > 3 && rows * (cols - 1) >= rectSize) {
                cols--;
            }

            // init grid
            int[][] grid = new int[rows][cols];
            boolean won = false;
            for (int i = 0; i < grid.length; i++) {
                if (won) {
                    break;
                }
                int[] row = grid[i];
                for (int j = 0; j < row.length; j++) {
                    // i,j is the current point
                    if (won) {
                        break;
                    }
                    while (grid[i][j] == 0) {
                        int xMax = Math.max(2, Math.min(rows - 1, i + 2));
                        int yMax = Math.max(2, Math.min(cols - 1, j + 2));
                        System.out.println(xMax + " " + yMax);
                        System.out.flush();
                        int x = in.nextInt();
                        int y = in.nextInt();
                        in.nextLine();
                        if (x == 0 && y == 0) {
                            won = true;
                            break;
                        } else if (x == -1 && y == -1) {
                            System.err.println("NOOOOO");
                            return;
                        }
                        grid[x - 1][y - 1] = 1;
                    }
                }
            }
        }
    }

}
