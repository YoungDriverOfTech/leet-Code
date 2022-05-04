package hash;

import java.util.Arrays;

public class CountPrimes {

    // 埃氏筛, 一个质数，他的倍数就是合数，那么就把这个质数的倍数全部标记为合数，然后遍历整个n
    // https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);    // 用1填充数组，表明都是质数

        int result = 0;
        for (int i = 2; i < n; i++) {
            // 如果当前的数字是质数，那么就给结果加上1
            if (isPrime[i] == 1) {
                result++;

                // 遍历该指数的倍数，然后设置为合数,比如2 -> 4, 6, 8, 10
                for (int j = i; j < n; j = j + i) {     // 这个for应该写进isPrime[i] == 1 里面，因为如果是一个合数，那么就没有必要把合数后面的倍数在重置成0了
                    isPrime[j] = 0;
                }
            }
        }

        return result;
    }
}
