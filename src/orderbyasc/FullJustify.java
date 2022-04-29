package orderbyasc;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    // https://leetcode-cn.com/problems/text-justification/solution/gong-shui-san-xie-zi-fu-chuan-mo-ni-by-a-s3v7/

    // words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    // 1.如果当前行只有一个单词，特殊处理为左对齐；
    // 2.如果当前行为最后一行，特殊处理为左对齐；
    // 3.其余为一般情况，分别计算「当前行单词总长度」、「当前行空格总长度」和「往下取整后的单位空格长度」，然后依次进行拼接。当空格无法均分时，每次往靠左的间隙多添加一个空格，直到剩余的空格能够被后面的间隙所均分。
    public List<String> fullJustify(String[] words, int maxWidth) {

        int len = words.length;
        List<String> res = new ArrayList<>();   // 用来装最终答案
        List<String> list = new ArrayList<>();  // 用来装每一行的答案

        for (int i = 0; i < len; ) {

            // 填充当前行的所有单词
            list.clear();
            list.add(words[i]);
            int curLen = words[i++].length(); // 当前行的长度
            while (i < len && curLen + 1 + words[i].length() <= maxWidth) {   // 当前单词 + 空格 + 下一个单词长度
                list.add(words[i]);
                curLen = curLen + 1 + words[i].length();
                i++;
            }

            // 填充满一行后，需要判断分属哪种情况
            // 如果是最后一行
            if (i == len) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int j = 1; j < list.size(); j++) {
                    sb.append(" ").append(list.get(j));
                }

                // 然后补充完剩余的空格
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
                res.add(sb.toString());

                break;  // 最后别忘记退出
            }

            // 如果只有一行，那么特殊左对齐
            int wordCount = list.size();
            if (wordCount == 1) {
                String str = list.get(0);
                while (str.length() < maxWidth) {
                    str += " ";
                }
                res.add(str);

                // 那么这行就已经处理完了，继续处理下一行
                continue;
            }


            /**
             * 其余为一般情况
             * wordWidth : 当前行单词总长度 = 当前行总长度 - 空白长度;
             * spaceWidth : 当前行空格总长度 = 每行最大长度 - 没行单词总长度;
             * spaceItemWidth ; 每两个单词之间应该夹着几个空白 = maxWidth / 单词个数;
             * spaceItem : 往下取整后的单位空格长度
             */
            int wordWidth = curLen - (wordCount - 1);   // 例如"example  of text", 三个单词夹着两个空白
            int spaceWidth = maxWidth - wordWidth;
            int spaceItemWidth = spaceWidth / (wordCount - 1); // -1 必须的，带入这个例子就能明白"example  of text"
            String spaceItem = " ";

            // 根据每个空白应该有的空白数，把spaceItem填充好
            while (spaceItem.length() < spaceItemWidth) {
                spaceItem += " ";
            }

            // 下面遍历list，把每个单词和空白填充完以后，根据spaceItemWidth算出，如果都以spaceItemWidth来填充剩下的单词
            // 其长度和这一行真正的长度spaceWidth想不想等，如果不想等，则在本行单词后面再加上一个空白
            StringBuilder sb = new StringBuilder();
            for (int k = 0, sum = 0; k < wordCount; k++) {

                // 填充单词
                String word = list.get(k);
                sb.append(word);

                // 如果是最后一个单词了，那么应该能直接填满本行，直接退出即可
                if (k == wordCount - 1) {
                    break;
                }

                // 如果不是最后一行，那么添加空格，并且计算剩余空格长度
                sb.append(spaceItem);

                // sum 用来统计添加过的空格的长度
                sum += spaceItemWidth;

                // 剩余的间隙数量（可填入空格的次数）,三个单词 -> 两个间隙,因为数组是0基的，所以后面-2
                int remain = wordCount - k - 2;
                // 剩余间隙数量 * 最小单位空格长度 + 当前空格长度 < 单词总长度，则在当前间隙多补充一个空格
                if (remain * spaceItemWidth + sum < spaceWidth) {
                    sb.append(" ");
                    sum++;
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
