package string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/restore-ip-addresses/solution/shou-hua-tu-jie-huan-yuan-dfs-hui-su-de-xi-jie-by-/
public class RestoreIpAddresses {
    List<String> res;
    List<String> temp;//temp用于将原字符串截取分成四段

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        res = new ArrayList<>();
        temp = new ArrayList<>();
        if (n <= 3 || n >= 13) {
            return res;
        }
        dfs(s, 0);
        return res;

    }

    public void dfs(String s, int begin) {
        if (begin == s.length() && temp.size() == 4) {
            String str = temp.get(0);
            for (int i = 1; i < 4; i++) {
                str = str + '.' + temp.get(i);
            }
            res.add(str);
            return;
        }


        if (begin < s.length() && temp.size() == 4) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            //保证后续s.substring(begin,begin+len)合法
            if (begin + len - 1 >= s.length()) {
                return;
            }

            //剔除不合法的前导0
            if (len != 1 && s.charAt(begin) == '0') {
                return;
            }
            //截取字符串
            String st = s.substring(begin, begin + len);
            //截取的字符串长度为3时，大小不能超过255
            if (len == 3 && Integer.parseInt(st) > 255) {
                return;
            }
            temp.add(st);
            dfs(s, begin + len);
            temp.remove(temp.size() - 1);
        }

    }

//    List<String> result = new ArrayList<>();
//    public List<String> restoreIpAddresses(String s) {
//        search(s, 1, "");
//        return result;
//    }
//
//    private void search(String s, int n, String ipAddress) {
//
//        // 如果前面4段已经被划分完，那么就把ip地址存入result中
//        if (n == 5 && s.length() == 0) {
//            // 需要将ipAddress最后一个点给去掉
//            result.add(ipAddress.substring(0, ipAddress.length() - 1));
//            return;
//        }
//        if (n >= 5) {
//            return;
//        }
//
//        // 剩余的还有几段没找,假如n=1，那么就剩下4段还没找（因为第一段还没开始找）
//        int remain = 5 - n;
//
//        // 判断长度，如果剩余的字符串长度 < remain -> 说明无法分为4份
//        //         如果剩余的字符串长度 > remain * 3 -> 说明能被分为4份以上，那么字符串长度溢出了
//        if (s.length() < remain || s.length() > remain * 3) {
//            return;
//        }
//
//        // 因为ip地址每一部分最多有3为，因此需要分别遍历分别是1，2，3位的情况
//        for (int i = 1; i <= 3; i++) {  // 因为要截取字符串，所以必须要保证能截到，i从1开始
//
//            // 如果字符串s不满足所需要的最少的字符串数量要求，那么就返回
//            if (s.length() < i) {
//                return;
//            }
//
//            // 裁剪出这个数字
//            String part = s.substring(0, i);
//            int num = Integer.parseInt(part);
//
//            // 特例，如果对00001进行判断，那么0.0.0.01; 就会不满足条件，因为01不能用作填充，把01转换成数字以后，长度变成了1，与原来的字符串不符，返回
//            if (part.length() != String.valueOf(num).length()) {
//                return;
//            }
//
//            // 判断他的最大值，如果>255了，那么就返回
//            if (num > 255) {
//                return;
//            }
//
//            // 如果满足条件，那么就去寻找第二段
//            search(s.substring(i), n + 1, ipAddress + part + ".");
//        }
//    }
}
