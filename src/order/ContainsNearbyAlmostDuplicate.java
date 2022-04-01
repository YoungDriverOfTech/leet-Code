package order;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    // floor(E e) 从左边接近目标元素，不存在返回null
    // ceiling(E e) 从右边接近目标元素，不存在返回null
    // https://leetcode-cn.com/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < len; i++) {
            Long cur = nums[i]  * 1L;
            Long leftEle = set.floor(cur);
            Long rightEle = set.ceiling(cur);

            if (leftEle != null && cur - leftEle <= t) {
                return true;
            }
            if (rightEle != null && rightEle - cur <= t) {
                return true;
            }

            set.add(cur);

            // 维护滑动窗口在[i, i + k]
            if (i >= k) {
                set.remove(nums[i - k] * 1L);
            }
        }

        return false;
    }
}
