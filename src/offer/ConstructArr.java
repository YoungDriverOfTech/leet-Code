package offer;

public class ConstructArr {

    // my solution (over time)
    public int[] constructArr(int[] a) {

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int tempValue = a[i];
            a[i] = 1;
            result[i] = getArrayProduct(a);
            a[i] = tempValue;
        }
        return result;
    }

    private int getArrayProduct(int[] array) {
        int result = 1;
        for (int num : array) {
            result *= num;
        }
        return result;
    }

    // better solution: separate a into two array
    public int[] constructArr_1(int[] a) {

        if (a.length == 0) {
            return new int[0];
        }

        int[] result = new int[a.length];
        result[0] = 1;

        for (int i = 1; i < a.length; i++) {
            result[i] = result[i - 1] * a[i - 1]; // result[i]会存储i之前累撑的值
        }

        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1]; // temp 会存储从当前元素到树组末尾的乘积
            result[i] *= temp;
        }

        return result;
    }

}
