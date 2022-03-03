package bs;

import java.util.*;

public class Intersect {
    // https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
    // hash表
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    // 双指针
    public int[] intersect_0(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    // my solution, ac but
    // Runtime: 17 ms, faster than 5.14% of Java online submissions for Intersection of Two Arrays II.
    //  Memory Usage: 49.4 MB, less than 5.90% of Java online submissions for Intersection of Two Arrays II.
    public int[] intersect_1(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        for (int num : nums2) {
            int left = 0;
            int right = nums1.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums1[mid] > num) {
                    right = mid - 1;
                } else if (nums1[mid] < num) {
                    left = mid + 1;
                } else {
                    result.add(num);
                    nums1[mid] = -1; // 替换完之后需要重新排序
                    Arrays.sort(nums1);
                    break;
                }
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Intersect().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
