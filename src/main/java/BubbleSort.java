public class BubbleSort {


    public static void sort(int[] arr) {

        int temp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }


    public static void main(String[] args) {


        int[] arr = {1, 3, 5, 8, 7, 11, 2, 13, 22, 19, 17};

        System.out.println("Unsorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }


        BubbleSort.sort(arr);


        System.out.println("\nSorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
