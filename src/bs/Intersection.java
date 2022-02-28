package bs;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
}
