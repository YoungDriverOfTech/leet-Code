package doublePointor;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            reverseOrder(s, left, right);
            left++;
            right--;
        }
    }

    private void reverseOrder(char[] s, int left, int right) {
        char tempStr = s[left];
        s[left] = s[right];
        s[right] = tempStr;
    }
}
