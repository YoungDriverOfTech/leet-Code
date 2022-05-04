package bs;

public class LengthOfLIS {
    // 遍历这个数组，把每个数组的数字放进dp数组里面去查找，如果发现大于dp的任何一个，则存到最后
    // 否则就放到比这个元素大的那一些元素中，最小的那个元素的位置上
    // [10,9,2,5,3,7,101,18]
    // dp: 10
    // dp: 9(因为9比10小，所以10被替换掉)
    // dp: 2(同上)
    // dp: 2, 5(5比dp中的所有元素都大，所以放入后面)
    // dp: 3,5 ,7, 101
    // dp: 3,5,7, 18
    // https://www.bilibili.com/video/BV11S4y1M7sd?spm_id_from=333.337.search-card.all.click
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-e/
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        // 定义一个数组用来存储最长递增子树组的长度
        int[] dp = new int[len];
        dp[0] = nums[0];
        int result = 1;
        int start = 0;
        int end = 0;

        for (int i = 1; i < len; i++) {
            int num = nums[i];

            // 如果num大于dp里面的任何元素，那么就需要把这个元素放入dp最后，并且dp的end索引要加1
            if (num > dp[end]) {
                dp[++end] = num;
                result++;
            } else {
                // 二分查找dp
                int left = start;
                int right = end;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (dp[mid] >= num) {
                        right = mid;    // right就相当于开始位置， 记得口诀，mid不+1mid大等，mid给right剩余增
                    } else {
                        left = mid + 1;
                    }
                }

                // 就像找到开始位置一样，然后替换掉这个元素即可
                dp[right] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
