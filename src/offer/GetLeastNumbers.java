package offer;

public class GetLeastNumbers {

    // bubble sort
    public int[] getLeastNumbers(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - i - 1; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    // quick sort
    public int[] getLeastNumbers_1(int[] arr, int k) {

        quickSort(arr, 0, arr.length - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = getMiddle(arr, left, right);
            quickSort(arr, left, middle -1);
            quickSort(arr, middle + 1, right);
        }
    }

    private int getMiddle(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            // 如果右边的值大于基准值，就把右指针往左推。 如果小于了基准值，那么就把这个值放到基准值上
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];

            // 道理同上
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
