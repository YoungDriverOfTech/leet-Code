package first200;

public class Multiply {
    // 以123 456为例子来计算
    public String multiply(String num1, String num2) {

        // 如果其中一个数字是0的话，那么直接返回0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // 获得长度并且声明一个数组用来做每个位的计算结果
        int len1 = num1.length();
        int len2 = num2.length();
        int[] arr = new int[len1 + len2];

        // 双重遍历两个数字，计算出他们的结果
        for (int i = len1 - 1; i >= 0; i--) {
            int value1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int value2 = num2.charAt(j) - '0';

                // 123 345 ，那么现在取到的是3 和 5，计算出乘积,并且要加上上次计算的进位
                // 因为现在i和j索引都是2，其和是4，不是数组最后一个元素，那么应该再+1，才到最后一个元素
                int sum = arr[i + j + 1] + value1 * value2;

                // 然后把本位和进位存入数组中
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum /10;  // 因为计算进位的时候，可能会多次计算，所以要使用+=，否则的话会出错
            }
        }

        // 遍历答案数组，然后返回结果、
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == 0) {
                continue;
            }
            sb.append(arr[i]);
        }

        return sb.toString();

    }
}
