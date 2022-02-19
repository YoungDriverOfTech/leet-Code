package string;

public class MyAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        // deal with +/-
        int sign = 1;
        int index = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
        } else if (s.charAt(0) != '+') {
            // start with number
            index = 0;
        }

        // boundary and result
        int boundary = Integer.MAX_VALUE / 10;
        int result = 0;

        for (int i = index; i < s.length(); i++) {

            // break loop if char is not valid
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }

            // check out of boundary or not
            if (result > boundary || (result == boundary && ch > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // dealing with valid char
            result = result * 10 + (ch - '0');
        }

        return sign * result;
    }

    public static void main(String[] args) {
        new MyAtoi().myAtoi("4193 with words");
    }
}
