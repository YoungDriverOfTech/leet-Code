package offer;

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


    // second time
    public boolean isNumber_2(String s) {
        s = s.trim();
        s = s.replace("E", "e");
        if (s.length() == 0) {
            return false;
        }

        // split s through e, if length is 2 then check 2 parts, orelse check 1 part
        //String[] strs = s.split("e");   // 按照e分割的话，比如e9，那么会分割成【""， "9"】，因此需要排除掉空字符串的场合
                                                // 分割字符串的时候不能使用split来进行分割，否则会把e这个字符给吞掉，应该是indexOf
        int eIndex = s.indexOf('e');
        if (eIndex > 0) {
            // check 2 parts between e
            String str1 = s.substring(0, eIndex);  // might be a integer or long
            String str2 = s.substring(eIndex + 1);  // must be a integer

            // delete + -
            if (str1.charAt(0) == '+' || str1.charAt(0) == '-') {
                str1 = str1.substring(1);   // 注意 substring 中间的s要小写
            }

            if (str2.length() > 0 && (str2.charAt(0) == '+' || str2.charAt(0) == '-')) {
                str2 = str2.substring(1);
            }

            // check str2
            if (!isPureNumber(str2)) {
                return false;
            }

            // check str1
            if (!isLong(str1)) {
                return false;
            }

        } else {
            // 1 part
            // delete + -
            if (s.charAt(0) == '+' || s.charAt(0) == '-') {
                s = s.substring(1);
            }

            return isLong(s);    // 可能是小数，可能是整数，需要调用这个方法
        }

        return true;    // 默认应该返回true
    }

    private boolean isLong(String str) {
        if (str.length() == 0) {
            return false;
        }

        // long has a dot
        if (str.contains(".")) {
            // String[] strArr = str.split("\\."); // .死特殊符号，需要进行转义， 如果出现.1，之类的情况，则会被分割成【"","1"】，需要对空串进行判断
                                                        // 不应该使用split对串进行分割，因为点会被吞掉，所以使用substring进行分割
            int dotIndex = str.indexOf('.');
            // 分三种情况进行判断，比如说 a .1  b 1. c 1.1
            String str1 = str.substring(0, dotIndex);
            String str2 = str.substring(dotIndex + 1);

            if (str1.length() == 0 && str2.length() > 0) {
                return isPureNumber(str2);
            } else if (str1.length() > 0 && str2.length() == 0){
                return isPureNumber(str1);
            } else {
                return isPureNumber(str1) && isPureNumber(str2);
            }
        } else {
            return isPureNumber(str);
        }
    }


    private boolean isPureNumber(String str) {
        if (str.length() == 0) {
            return false;
        }


        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsNumber().isNumber("2e0"));
    }
}
