package doublePointor;

public class StrStrc {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i + n <= m; i++) {  // 条件写上等于是因为要考虑needle为空串的情况

            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        new StrStrc().strStr("mississippi", "issip");
    }
}
