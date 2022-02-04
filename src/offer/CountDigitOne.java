package offer;

public class CountDigitOne {

    /**
     *  例如求3101592
     *  把base定位100，那么用100可以把n分成三部分 a: 3101  cur: 5  b: 592
     *  切这三部分的计算方法为 a = (n/base)/10;  cur = (n/base)%10; b = n % base
     *  1. 当cur是大于1的话,那么1在n中出现的次数就是 (a+1) * base
     *      a: 3105 -> [0000, 3105] -> a + 1
     *      b: 92 -> [00, 99] -> base(正好100个)
     *  2. 当cur是等于1的话,那么1在n中出现的次数要分情况讨论，现在假定base是1000
     *      那么a：310； cur：1； b：592
     *      a. 当a的范围是【000，309】时，b的范围是【000，999】 -> （a * base）是总数
     *      b. 当a取值是310时，b的范围只能是【0，b】-> (1*(b+1))
     *  由ab两种情况可知总次数=（a * base）+ (b+1)
     *
     *  3. 当cur是小于1的话（也就是0）的时候
     *      那么a：31； cur：0； b：1592
     *      这时候a的取值范围是【00， 30】因为如果取到1的话就已经超过了n。一共有a种
     *      b的取值范围是【0000，9999】，一共有base种
     *  那么总次数是=a * base
     */
    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;

        // 假定123， high:12;  cur:3;  low:0
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        while (digit <= n) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;

            // 下次循环 low: 3;  cur: 2;  high: 1;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountDigitOne().countDigitOne(1410065408));
    }
}
