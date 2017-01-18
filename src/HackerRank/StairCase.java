package HackerRank;

import java.util.Scanner;

/**
 * Created by Sarnaglia on 12/30/16.
 */
public class StairCase {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printLine(n, n);
    }

    private static void printLine(int i, int n){
        if(i <= 0)   return;
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
        for (int j = i; j < n; j++) {
            System.out.print("#");
        }
        System.out.println();
        printLine(i-1, n);
    }

}
