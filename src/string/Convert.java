package string;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();

        // 给每一行分配一个stringBuilder，用来填装字符
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        // 定义一个flag，在首行/末行改变方向
        int flag = -1;
        int index = 0;
        for (char ch : s.toCharArray()) {
            list.get(index).append(ch); // 把字符放入各行

            // 判断是否到达了首行/末行，如果到达了的话，专项
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }

            index += flag;
        }

        // 把list里面的字符串组合起来
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }

        return result.toString();
    }
}
