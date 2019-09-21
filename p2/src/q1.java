import java.io.*;

public class q1 {
    static int arr1[] = new int[]{2, 3, 4, 5, 6};
    static int arr2[] = new int[]{0, 3, 4, 15, 6};
    static int arr3[] = new int[]{1, 6, 24, 4, 6};

    static boolean check(int c, int arr[]) {
        for (int i : arr
        ) {
            if (i== c) {
                return true;
            }
        }
        return false;
    }

    static void printCommon() {
        System.out.print("comon elements : ");
        for (int i : arr1
        ) {
            if (check(i, arr2) && check(i, arr3)) {
                System.out.print(i + ",");
            }

        }
    }

    public static void main(String args[]) {
        printCommon();
    }
}
