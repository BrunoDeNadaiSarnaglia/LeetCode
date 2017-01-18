package HackerRank;

import java.util.Scanner;

/**
 * Created by Sarnaglia on 12/30/16.
 */
public class DiagonalDifference {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int MainDiagonalSum = 0;
        int SecondDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            MainDiagonalSum += a[i][i];
            SecondDiagonalSum += a[i][n - i - 1];
        }
        System.out.print((MainDiagonalSum > SecondDiagonalSum ? MainDiagonalSum - SecondDiagonalSum : SecondDiagonalSum - MainDiagonalSum));
    }

}
