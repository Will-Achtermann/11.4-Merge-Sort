public class Main {
    public static void main(String[] args) {
        int[] numbers = {3100, 12, 56, 43, 20, 18, 9, 5};

        System.out.println("Before sorting:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("After sorting:");
        printArray(numbers);
    }

    public static void mergeSort(int[] array) {
        if(array.length > 1){
            int[] left = new int[array.length/2];
            for (int i = 0; i < left.length; i++){
                left[i] = array[i];
            }
            int[]right = new int[array.length - left.length];
            for (int i = 0; i < right.length; i++){
                right[i] = array[i + left.length];
            }
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
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
        if (l == left.length && r < right.length){
            for (int i = arr; i < array.length; i++){
                array[i] = right[r];
                r++;
            }
        } else if (r == right.length && l < left.length){
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
