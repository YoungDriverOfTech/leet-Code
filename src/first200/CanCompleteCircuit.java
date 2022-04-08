package first200;

public class CanCompleteCircuit {
    // https://leetcode-cn.com/problems/gas-station/solution/tan-xin-dong-hua-tu-jie-dai-ma-jian-ji-b-na6b/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 统计所有油耗和油量，如果油耗>油量，说明行不通
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalCost > totalGas) {
            return -1;
        }

        // 判断每个加油站能否走到下一个加油站，如果走不到，那么就把加油站的起始位置设置为下一个加油站
        // 最后能跑通的那个，不一定是完全经过测试，跑完一轮的，是排除掉其他错误答案，剩下的就是正确的
        // 因为题目告诉了，一定有一个唯一的答案 If there exists a solution, it is guaranteed to be unique
        int start = 0;
        int currentGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas = currentGas + gas[i] - cost[i];
            if (currentGas < 0) {
                start = (i + 1) % gas.length;
                currentGas = 0;
            }
        }

        return start;
    }
}
