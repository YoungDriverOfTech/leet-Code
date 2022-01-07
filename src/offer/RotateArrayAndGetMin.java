package offer;

public class RotateArrayAndGetMin {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j <= numbers.length - 1 - i; j++) {
                if (numbers[i] >= numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers[0];
    }

    // better solution
    public int minArray_1(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int middle = 0;
        while (left < right) {
            middle = left + (right - left) / 2; // prevent outOfIndexBound error
            if (numbers[right] > numbers[middle]) {
                right = middle - 1;
            } else if (numbers[right] < numbers[middle]) {
                left = middle + 1;
            } else {
                right = right - 1;
            }
        }
        return numbers[middle];
    }

    //递增性质进一步思考，如果它本身就是递增的，未被旋转，第一个就是最小，
    //如果被旋转了，那么旋转后的数组第一个元素必定比最小的元素大，
    //只需要找出数组中第一个小于旋转后数组的第一个元素的数字即可
    public int minArray_2(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<numbers[0])
                return numbers[i];
        }
        return numbers[0];
    }

    public static void main(String[] args) {
//        System.out.println(new RotateArrayAndGetMin().minArray(new int[]{3, 4, 5, 1, 2}));
//        System.out.println(new RotateArrayAndGetMin().minArray(new int[]{3, 1}));

        System.out.println(new RotateArrayAndGetMin().minArray_1(new int[]{3,4,5,1,2}));
    }
}
