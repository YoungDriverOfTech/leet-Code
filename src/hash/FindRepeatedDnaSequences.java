package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRepeatedDnaSequences {
    static final int L = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - L; i++) { // 注意，这里要小于 等于， 要不然可能截取不到最后一位
            String str = s.substring(i, i + L);
            int count = map.getOrDefault(str, 0) + 1;
            if (count == 2) {
                result.add(str);
            }
            map.put(str, count);
        }

        return result;
    }
}
