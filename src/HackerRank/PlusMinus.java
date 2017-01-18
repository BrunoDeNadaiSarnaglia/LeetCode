package HackerRank;

import java.util.Scanner;

/**
 * Created by Sarnaglia on 12/30/16.
 */
public class PlusMinus {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int positive = 0;
        int zero = 0;
        int negative = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            positive += (num > 0 ? 1 : 0);
            negative += (num < 0 ? 1 : 0);
            zero += (num == 0 ? 1 : 0);
        }
        int total = positive + negative + zero;
        System.out.println((float)positive / total);
        System.out.println((float)negative / total);
        System.out.println((float)zero / total);
    }

}
