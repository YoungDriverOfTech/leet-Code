package order;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        // 排序的关键点就是相邻的两个数调转位置相加后比较谁大，谁大谁放到前面
        int len = nums.length;
        String[] strNums = new String[len];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // 排序
        Arrays.sort(strNums, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));

        // 如果排序完首字符是0的话，说明其后面都是0，那么直接返回0即可
        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }
        return sb.toString();
    }
}
