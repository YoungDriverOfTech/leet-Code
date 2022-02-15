package string;

public class NumberToWords {

    private final static String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final static String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    // explanation: https://www.bilibili.com/video/BV1EN41197Rp?from=search&seid=3299682767746046935&spm_id_from=333.337.0.0
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return helper(num);
    }

    private String helper(int num) {
        String res = "";
        if (num < 10) {
            res = belowTen[num];
        } else if (num < 20) {
            res = belowTwenty[num - 10];
        } else if (num < 100) {
            // eg: 23 -> Twenty Three
            // 那么对23求10的商得到2，对10求余数得到3
            res = belowHundred[num / 10] + " " + helper(num % 10);
        } else if (num < 1000) {
            // eg: 423 -> Four Hundred Twenty Three
            // 那么对400求10的商得到4，对100求余数得到23
            res = helper(num / 100) + " Hundred " + helper(num % 100);
        } else if (num < 1000000) { // 因为英文种千下面就是百万了，所以在百万以下，都得用千来表示
            // eg: 1423 -> One　Thousand　Four Hundred Twenty Three
            res = helper(num / 1000) + " Thousand " + helper(num % 1000);
        } else if (num < 1000000000) {  // 十亿
            res = helper(num / 1000000) + " Million " + helper(num % 1000000);
        } else {
            res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }

        return res.trim();
    }
}
