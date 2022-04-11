package first200;

public class Rotate {

    // 方法1 使用新数组
    public void rotate_1(int[] nums, int k) {
        int len = nums.length;
        int[] newArr = new int[len];

        for (int i = 0; i < len; i++) {
            newArr[(i + k) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = newArr[i];
        }
    }

    // 方法2 反转数组
    /*
        nums = "----->-->"; k =3
        result = "-->----->";

        reverse "----->-->" we can get "<--<-----"
        reverse "<--" we can get "--><-----"
        reverse "<-----" we can get "-->----->"
        this visualization help me figure it out :)
    * */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
