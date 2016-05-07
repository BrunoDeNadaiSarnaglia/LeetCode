/**
 * Created by Bruno on 5/6/2016.
 */
public class Utils {

    public static <T> void printArray(T[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        if(array.length != 0) System.out.print(array[array.length -1]);
        System.out.println("]");
    }

    public static void printArray(char[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        if(array.length != 0) System.out.print(array[array.length -1]);
        System.out.println("]");
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        if(array.length != 0) System.out.print(array[array.length -1]);
        System.out.println("]");
    }

    public static void printArray(boolean[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        if(array.length != 0) System.out.print(array[array.length -1]);
        System.out.println("]");
    }

}
