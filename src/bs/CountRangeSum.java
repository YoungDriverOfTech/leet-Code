package bs;

public class CountRangeSum {

    // https://juejin.cn/post/7052154137202393096
    // 以后需要优化一下写法 https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
    private int lower;
    private int upper;
    private int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        // 先做一个前缀和数组，即当前元素和之前元素的和，作为当前的新的元素
        int len = nums.length;
        long[] sums = new long[len + 1];
        sums[0] = 0;    // 默认首元素是0方便计算
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        this.lower = lower;
        this.upper = upper;

        // 进行归并排序
        // nums = [-2,5,-1]   sums = [0, -2, 3, 2]    lower = -2  upper = 2
        // 现在我们设想前缀和数组里面如果某个元素减去他前面的元素的结果，正好落在了【lower，upper】上，那么说明这个区间就是有效区间
        // 比如说 最后两个 2-3 = -1，  结果是落在了【-2， 2】上面，所以结果数量 += 右索引-左索引
        splitArr(sums, 0, sums.length - 1);     // left的指针应该从1开始，应为首个元素0，是我们自己塞进去的假值

        return this.count;
    }

    private void splitArr(long[] sums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            splitArr(sums, left, mid);
            splitArr(sums, mid + 1, right);
            mergeArr(sums, left, mid, right);
        }
    }

    private void mergeArr(long[] sums, int left, int mid, int right) {
        // 合并时，如果只有一个元素，那么直接返回即可
        if (left >= right) {
            return;
        }

        // 记录左区间索引i，右区间为j，那么如果满足条件的话，应该是
        // sums[j] - sums[i] >= lower  && sums[j] - sums[i] <= upper 那我们在把这个不等是改写一些
        // sums[j] - upper <= sums[i] <= sums[j] - lower    给左右边界一个名字min， max
        // min             <= sums[i] <= max
        // 那么我们就先遍历右数组，并且求出右数组j元素的最大值和最小值，在根据上面的不等式
        // 则左区间中所有满足 min<=sums[i]<=max 的元素，都可以和右区间中当前的 sums[j] 组成符合要求的区间和。

        // 遍历右区间
        int start = left;
        int end = left;
        for (int j = mid + 1; j <= right; j++) {
            // 取得最大最小值的索引
            long min = sums[j] - this.upper;
            long max = sums[j] - this.lower;

            // 遍历左区间，找到满足此条件min<=sums[i]<=max 的i的范围
            while (start <= mid && sums[start] < min) {    // 注意这里的大于小于号
                start++;
            }
            while (end <= mid && sums[end] <= max) {    // 注意这里的大于小于号
                end++;
            }

            // 对于右元素j来说，左数组【start，end】之间的数量是满足条件的
            // 并且由于左右数组都是经过排序的，所以min 和 max在遍历j的时候，也会增大； start和end在左数组原来的基础上进行递增就OK的
            this.count += end - start;
        }

        // 接下来就是要进行排序然后覆盖掉原来的数组了
        long[] tempArr = new long[right - left + 1];
        int tempIndex = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (sums[leftIndex] <= sums[rightIndex]) {
                tempArr[tempIndex++] = sums[leftIndex++];
            } else {
                tempArr[tempIndex++] = sums[rightIndex++];
            }
        }

        // 合并掉剩余的没合并完的元素
        while (leftIndex <= mid) {
            tempArr[tempIndex++] = sums[leftIndex++];
        }
        while (rightIndex <= right) {
            tempArr[tempIndex++] = sums[rightIndex++];
        }

        // 覆盖原树组
        for (int i = 0; i < tempArr.length; i++) {
            sums[left + i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
//        System.out.println(new CountRangeSum().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(new CountRangeSum().countRangeSum(new int[]{0}, 0, 0));
    }
}
