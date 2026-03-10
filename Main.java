public class Main {
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Before sorting:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("After sorting:");
        printArray(numbers);
    }

    public static int[] mergeSort(int[] array) {
        int[] left = new int[array.length/2];
        int[]right = new int[array.length - left.length];
        if (array.length == 1){
            return array;
        }
        merge(array, mergeSort(left), mergeSort(right));
    }

    public static void merge(int[] array, int[] left, int[] right) {
        int arr = 0;
        int l = 0;
        int r = 0;
        while (arr < array.length && l < left.length && r < right.length){
            if (left[l] <= right[r]){
                array[arr] = left[l];
                l++;
            }else{
                array[arr] = right[r];
                r++;
            }
            arr++;
        }
        if (l == left.length - 1 && r < right.length - 1){
            for (int i = arr; i < array.length; i++){
                array[i] = right[r];
                r++;
            }
        } else if (r == right.length - 1 && l < left.length - 1){
            for (int i = arr; i < array.length; i++){
                array[i] = left[l];
                l++;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
