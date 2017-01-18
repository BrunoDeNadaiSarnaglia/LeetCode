package HackerRank;

import java.util.Scanner;

/**
 * Created by Sarnaglia on 12/30/16.
 */
public class TimeConvension {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String type = time.substring(time.length() - 2);
        int hour = Integer.parseInt(time.substring(0,2));
        if((type.equals("PM") && hour != 12)|| ( hour == 12  && type.equals("AM"))){
            String hourString = (hour + 12) % 24 + "";
            System.out.print((hourString.length() == 1 ? "0" : "") + hourString);
            System.out.print(time.substring(2,time.length() - 2));
        } else {
            System.out.print(time.substring(0,time.length() - 2));
        }
    }

}
