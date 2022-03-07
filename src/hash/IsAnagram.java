package hash;

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.toString(sChars).equals(Arrays.toString(tChars));
    }
}
