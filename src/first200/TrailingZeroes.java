package first200;

public class TrailingZeroes {
    //    首先题目的意思是末尾有几个0
    //    比如6! = 【1* 2* 3* 4* 5* 6】
    //    其中只有2*5末尾才有0，所以就可以抛去其他数据 专门看2 5 以及其倍数 毕竟 4 * 25末尾也是0
    //    比如10！ = 【2*4*5*6*8*10】
    //    其中 4能拆成2*2  10能拆成2*5
    //    所以10！ = 【2*（2*2）*5*（2*3）*（2*2*2）*（2*5）】
    //    一个2和一个5配对 就产生一个0 所以10！末尾2个0
    //
    //    转头一想 2肯定比5多 所以只数5的个数就行了
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
