package first200;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {

    // https://leetcode-cn.com/problems/4sum-ii/solution/si-shu-xiang-jia-ii-by-leetcode-solution/
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums1.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int temp = nums1[i] + nums2[j];

                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int temp = nums3[i] + nums4[j];

                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }

            }
        }

        return res;
    }
}
