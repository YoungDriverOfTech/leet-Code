package first200;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }


        return -1;
    }
}
