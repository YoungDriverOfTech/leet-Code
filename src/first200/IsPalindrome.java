package first200;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        if (xStr.charAt(0) == '-' || xStr.charAt(0) == '+') {
            return false;
        }

        int left = 0;
        int right = xStr.length() - 1;
        while (left <= right) {
            if (xStr.charAt(left) != xStr.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
