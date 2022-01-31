package offer;

public class NthUglyNumber {

    // explanation: https://www.bilibili.com/video/BV1o541177He?from=search&seid=11252206013957966124&spm_id_from=333.337.0.0
    public int nthUglyNumber(int n) {
        int[] resultArray = new int[n + 1];
        int p2 = 1, p3 = 1, p5 = 1;
        resultArray[0] = 0; // dummy
        resultArray[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            int nextUglyNo = Math.min(Math.min(resultArray[p2] * 2, resultArray[p3] * 3), resultArray[p5] * 5);
            resultArray[i] = nextUglyNo;

            if (nextUglyNo == resultArray[p2] * 2) {
                p2++;
            }

            if (nextUglyNo == resultArray[p3] * 3) {
                p3++;
            }

            if (nextUglyNo == resultArray[p5] * 5) {
                p5++;
            }
        }

        return resultArray[n];
    }

    public static void main(String[] args) {
        new NthUglyNumber().nthUglyNumber(11);
    }
}
