package orderbyasc;

public class CompareVersion {

    // https://leetcode-cn.com/problems/compare-version-numbers/solution/bi-jiao-ban-ben-hao-by-leetcode-solution-k6wi/
    // version1 = "1.01", version2 = "1.001"
    // 把点之前的数子拿出来，分别进行比较 1 == 1 然后指针都往后移动一位
    // 在把01 和 001 进行比较。

    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();

        int i = 0;
        int j = 0;
        while (i < len1 || j < len2) {
            int x = 0;
            for (; i < len1 && version1.charAt(i) != '.'; i++) {
                x = x * 10 + (version1.charAt(i) - '0');
            }
            i++;

            int y = 0;
            for (; j < len2 && version2.charAt(j) != '.'; j++) {
                y = y * 10 + (version2.charAt(j) - '0');
            }
            j++;

            if (x != y) {
                return x > y ? 1 : -1;
            }
        }

        return 0;
    }
}
