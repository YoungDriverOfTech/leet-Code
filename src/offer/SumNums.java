package offer;

public class SumNums {
    public int sumNums(int n) {

        // 因为不能使用if、所以用复制语句来完成递归的推出条件，&&是短路逻辑符号，当前面的条件不满足是，后面的条件就不会去执行了
        // 所以当n是0的时候，最后一次加法并不会运算，那么就完成了退出
        boolean returnFlag = (n > 0) && (n += sumNums(n - 1)) > 0;

        return n;
    }
}
