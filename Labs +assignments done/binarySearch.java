
public class binarySearch {
    static int arr[] = new int[]{0,1, 2, 3,4,5,6,7,8,9};

    public static int binarySearch(int n) {
        int mid = arr.length / 2, start = 0, end = arr.length-1;

        while (start <= end) {
            if (arr[mid] == n) {
                return mid;
            }
            else if (n < arr[mid]) {
                //start remain same
                end = mid-1;
                mid = start+(mid-start)/ 2-1;

            }
            else if (n > arr[mid]) {
                //end remain same

                start = mid+1;
                mid = mid+(end - mid) / 2+1;
            }

        }
        return -1;

    }
    public static void main(String arg[]){

        System.out.println( binarySearch(7));
    }


}
