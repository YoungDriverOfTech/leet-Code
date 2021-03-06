package orderbyasc;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    // https://www.bilibili.com/video/BV17r4y1s7q2?spm_id_from=333.337.search-card.all.click
    // time/space O(2^n)
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                // 先把每个数字左移一位，即对称先的上半部分
                int num = res.get(j) << 1;// 上半部分后面+0
                res.set(j, num);    // 上半部分后面+0
                res.add(num + 1);   // 下班部分后面+1
            }
        }
        return res;
    }
}
