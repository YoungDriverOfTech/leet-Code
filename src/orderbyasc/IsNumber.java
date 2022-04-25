package orderbyasc;

public class IsNumber {
    // 参考：https://www.bilibili.com/video/BV1G7411U7ti?from=search&seid=14931812880591595159&spm_id_from=333.337.0.0
    public boolean isNumber(String s) {
        // 把字符串两边空格去掉，字符串前面右+-号的也去掉
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }

        // 把e统一成小写，方便后续代码计算
        s = s.replace('E', 'e');

        // 看看字符串里面右没有e，因为有e的情况是 【小数或整数 e 整数】，用e将他们分开后，分别进行计算
        if (s.indexOf('e') > 0) {
            int eIndex = s.indexOf('e');
            String first = s.substring(0, eIndex);
            String second = s.substring(eIndex + 1);

            // e后面必须有数字，如果没有那么说明这个字符串不是数值
            if (second.length() > 0) {
                if (second.charAt(0) == '+' || second.charAt(0) == '-') {
                    second = second.substring(1);
                }
                if (!ifIsPureNumber(second)) {
                    return false;
                }
            }

            // 判断前半部分
            return ifIsNumber(first) && ifIsPureNumber(second);
        }

        // 如果没有e的话，那么就判断s字符串是不是一个数字【小数 或 整数】
        return ifIsNumber(s);
    }

    // 判断是不是一个纯数字
    private boolean ifIsPureNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    // 判断是不是一个小数或者整数
    private boolean ifIsNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        // 判断有没有小数点，有的话也分成两部分尽享判断
        if (s.indexOf('.') >= 0) {
            int dotIndex = s.indexOf(".");
            String first = s.substring(0, dotIndex);
            String second = s.substring(dotIndex + 1);

            // 总共有三张情况
            // 1. 至少一位数字，后面跟着一个点 '.'
            // 2. 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
            // 3. 一个点 '.' ，后面跟着至少一位数字
            if (first.length() > 0 && second.length() > 0) {
                return ifIsPureNumber(first) && ifIsPureNumber(second);
            } else if (first.length() > 0) {
                return ifIsPureNumber(first);
            } else if (second.length() > 0) {
                return ifIsPureNumber(second);
            } else {
                return false;
            }
        }
        return ifIsPureNumber(s);
    }
}
