package hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {

    // https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/xian-pai-xu-zai-cha-dui-dong-hua-yan-shi-suan-fa-g/
    public int[][] reconstructQueue(int[][] people) {
        // 先根据身高进行降序排序，身高相同在根据人数升序
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });

        // 判断结果集的size和人数组的人数，如果人数大于等于结果集size，那么应该放到结果集后面
        // 如果小于了，那么就把这个人插入到对应的人数的位置
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            if (person[1] >= res.size()) {
                res.add(person);
            } else {
                res.add(person[1], person);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
