package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /**
     * 假定n是3，那么左右括号加起来就是6个，使用回溯法
     * https://www.bilibili.com/video/BV11L411p7Hx/?spm_id_from=333.788.recommend_more_video.0
     * https://www.bilibili.com/video/BV1rV411U7ak/?spm_id_from=333.788.recommend_more_video.2
     * */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, 0, 0, n, "");
        return result;
    }

    private void backTrack(List<String> result, int left, int right, int n, String str) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }

        if (left < n) {
            str += "(";
            backTrack(result, left + 1, right, n, str);
            str = str.substring(0, str.length() - 1);
        }

        if (right < left) {
            str += ")";
            backTrack(result, left, right + 1, n, str);
//            str = str.substring(0, str.length() - 1);
        }
    }
}
