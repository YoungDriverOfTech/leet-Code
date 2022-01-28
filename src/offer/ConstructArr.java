package offer;

import java.util.Arrays;

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

        System.out.println("first loop start----------");
        for (int i = 1; i < a.length; i++) {
            System.out.println("----------start " + i + " ----------");
            System.out.println("result[" + (i - 1) + "] = " + result[i - 1]);
            System.out.println("a[" + (i - 1) + "] = " + a[i - 1]);
            result[i] = result[i - 1] * a[i - 1]; // result[i]会存储i之前累撑的值
            System.out.println("result[" + (i) + "] = " + result[i]);
            System.out.println("----------end " + i + " ----------");
        }
        System.out.println("first loop end----------");

        System.out.println(Arrays.toString(result));

        System.out.println("second loop start----------");


        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            System.out.println("----------start " + i + " ----------");
            System.out.println("a[" + (i + 1) + "] = " + a[i + 1]);
            System.out.println("temp = " + temp);
            temp *= a[i + 1]; // temp 会存储从当前元素到树组末尾的乘积
            System.out.println("result[" + (i) + "] before = " + result[i]);
            result[i] *= temp;
            System.out.println("result[" + (i) + "] after = " + result[i]);
            System.out.println("----------end " + i + " ----------");
        }
        System.out.println("second loop end----------");
        return result;
    }

    public static void main(String[] args) {
        new ConstructArr().constructArr_1(new int[]{1, 2, 3, 4, 5});
    }
}
