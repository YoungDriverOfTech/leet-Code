package doublePointor;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char ch : chars) {
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
                sb.append(ch);
            }
        }

        // 判断回文数
        char[] charsAfterRemoving = sb.toString().toCharArray();
        int left = 0;
        int right = charsAfterRemoving.length - 1;
        while (left <= right) {
            if (charsAfterRemoving[left] != charsAfterRemoving[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
