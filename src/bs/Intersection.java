package bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

    // 排序+二分查找
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public int[] intersection_1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;

        int index1 = 0;
        int index2 = 0;
        List<Integer> list = new ArrayList<>();
        while (index1 < length1 && index2 < length2) {
            // 避免重复
            while (index1 + 1 < length1 && nums1[index1] == nums1[index1 + 1]) {
                index1++;
            }
            while (index2 + 1 < length2 && nums2[index2] == nums2[index2 + 1]) {
                index2++;
            }

            if (index1 >= length1 || index2 >= length2) {
                break;
            }

            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 == num2) {
                list.add(num1);
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
