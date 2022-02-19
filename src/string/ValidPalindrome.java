package string;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return checkValidity(s, low + 1, high) || checkValidity(s, low, high - 1);  // 注意，这里high - 1,不是加1
            }
        }

        return true;
    }

    private boolean checkValidity(String s, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
