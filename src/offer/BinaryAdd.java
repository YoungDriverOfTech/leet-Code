package offer;

public class BinaryAdd {
    // explanation: https://www.bilibili.com/video/BV1F7411j79e?from=search&seid=17789840221403858780&spm_id_from=333.337.0.0
    public int add(int a, int b) {

        int sum1 = Integer.MIN_VALUE; // 本位
        int sum2 = Integer.MIN_VALUE; // 进位

        // 没办法产生进位的时候就退出
        while (sum2 != 0) {
/**
 *         eg： 5 7 相加，换成二进制是  101 111
            本位             进位
             101            101
           + 111           +111
           = 010           =1010
            那么最后就是本位和进位在进行相加
                    1010
                   + 010
            上面的数字在进行重复的操作，直到不再产生进位
*/

            sum1 = a ^ b; // 只用来统计本位想加的情况
            sum2 = (a & b) << 1; // 只用来统计进位想相加的情况

            a = sum1; // 递归调用
            b = sum2;
        }

        return sum1;
    }
}
