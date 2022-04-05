package first200;

public class FirstMissingPositive {
    // 解释题目 https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
    // 原本给定的是【1，n】的数组，如果每个数字都符合第几位上就是几，比如第一位是1，第二位是2，那么就是正确的数组
    // 但是现在有例子【1，2，0】，本来第三位上应该是3，但现在是0，所以应该返回缺少的3
    // 【1，-1，3，4】本来第二位上是2，但是现在是个-1，所以应该返回2
    public int firstMissingPositive(int[] nums) {
        // 遍历一边数组，如果发现第i位上的元素不是i的话，那么就把i换到其对应的位置
        for (int i = 0; i < nums.length; i++) {
            // 当元素是落在【1， n】之间的有效元素才会进行交换
            // 【3，4，-1，1】当遍历道3的时候，那么应该把3放到第三个位置，即索引为2的位置上nums[nums[i] - 1]
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 再次遍历数组，判断每个位置上对应的元素是否正确
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果产生了全部正确的结果，那么确实的元素就是N+1
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
