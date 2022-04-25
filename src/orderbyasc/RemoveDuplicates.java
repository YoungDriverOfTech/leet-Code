package orderbyasc;

public class RemoveDuplicates {
    //  举个🌰，我们令 k=2，假设有如下样例
    //  [1,1,1,1,1,1,2,2,2,2,2,2,3]
    //  首先我们先让前 2 位直接保留，得到 1,1
    //  对后面的每一位进行继续遍历，能够保留的前提是与当前位置的前面 k 个元素不同（答案中的第一个 1），因此我们会跳过剩余的 1，将第一个 2 追加，得到 1,1,2
    //  继续这个过程，这时候是和答案中的第 2 个 1 进行对比，因此可以得到 1,1,2,2
    //  这时候和答案中的第 1 个 2 比较，只有与其不同的元素能追加到答案，因此剩余的 2 被跳过，3 被追加到答案：1,1,2,2,3
    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-yec2/
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }

        int res = 2;
        for (int i = 2; i < len; i++) {
            int num = nums[i];
            if (nums[res - 2] != num) {
                nums[res++] = num;
            }
        }
        return res;
    }
}
