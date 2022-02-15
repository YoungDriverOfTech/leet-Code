package string;

import java.util.Arrays;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);   // 按照空格划分，并且只划分成2等份
            String[] split2 = log2.split(" ", 2);

            // 判断log是属于字符串log还是数字log
            boolean isDidital1 = Character.isDigit(split1[1].charAt(0));
            boolean isDidital2 = Character.isDigit(split2[1].charAt(0));

            // case1. 如果两个都是字符log，那么先判断内容，在判断标识符
            if (!isDidital1 && !isDidital2) {
                int tempResult = split1[1].compareTo(split2[1]);
                // 自定义比较器里面，对于两个元素 o1, o2，根据起相减结果来决定是否排序，如果返回1，代表真，说明需要调换顺序
                // 如果返回-1， 说明为假，不用调换顺序，为0则代表保持原样

                // 如果tempResult > 0, 代表o1 > o2, 如果想要顺序，那么o2应该到前面，所以应该返回1来进行调换顺序
                if (tempResult != 0) {
                    return tempResult;
                }

                // 如果内容相等的话，那么我们需要比较标识符
                return split1[0].compareTo(split2[0]);
            }

            // case2. log1是字符串 log2是数字 -> 字符串排前面，不需要调换顺序，返回-1
            // case3. log1是数字 log2是字符串 -> 字符串排前面，需要调换顺序，返回1
            // case4. 两个都是数字，不需要变换顺序，返回0
            if (!isDidital1 && isDidital2) {
                return -1;
            }

            if (isDidital1 && !isDidital2) {
                return 1;
            }

            return 0;
        });

        return logs;
    }
}
