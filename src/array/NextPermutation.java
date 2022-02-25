package array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 4,5,2,6,3,1  ->  4,5,3,6,2,1  交换了2 ，3
        // 思路： 1. 从右往左找，先找到一个数，这个数比他后面的数要小，并且记录下来这个数字
        //       2. 再次从后往前找，找到第一个大于1.中找到的那个数字，并且交换他们的位置，然后把1.数字后的元素进行升序排序
        //       3. 如果全部没找到的话，那么说明这个数组就是倒序的数组，直接转变成升序的就行
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {   // 这里必须要+等号， 为了只有2个元素的数组，比如{1, 2}
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        ascOrder(nums, i);
    }

    private void ascOrder(int[] nums, int i) {
        int left = i + 1;   // 这里i要加1
        int right = nums.length - 1;
        while (left < right) {
            // 因为i之后的元素全部是倒序的，所以可以不用判断数字大小了
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 2});
    }
}
