package offer;

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        // 1. 对每个元素进行异或，找出不重复的两个元素异或的结果
        int result = 0; // 任何元素对0进行异或，都是他本身
        for (int num : nums) {
            result ^= num;
        }

        // 2. 异或操作是两数不同位1，其余为0，那么就找到刚才result从右往左数的第一个1的位置
        // 找到这个位置的值，用这个值来对原树组进行异或操作的话，就可以把不重复的两个元素给分到两边去
        // 因为与操作是两个数都是1，结果才为1，那么就可以用1这个数字，与上result，只要结果是1，那么就说明找到了result的第一个出现1的位置
        int m = 1;
        while ((result & m) == 0) {
            m = m << 1;
        }

        // 3. 因为m可以通过与操作把原树组分成两波，那么我们就定义两个变量，来存储不重复的两个元素
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num; // 这里为什么要用异或操作呢？ 答；任何元素对0进行异或，第一个元素进行异或的时候，可以保证x的值是第一个元素
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};
    }

    public int[] singleNumbers_2(int[] nums) {

        // get non-duplicate numbers ^ operation result
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }

        // find number that can separate non-duplicate numbers through ^ operation
        int separateNum = 1;
        for (int i = 0; i <= 31; i++) {
            if ((temp & separateNum) == 0) {    // 注意，这里的条件不能写成 (temp & separateNum) != 1
                separateNum <<= 1;
            } else {
                break;
            }
        }

        // find non-duplicate numbers
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((separateNum & nums[i]) == 0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }

        return new int[]{num1, num2};
    }
}
