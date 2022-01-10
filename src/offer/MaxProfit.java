package offer;

import java.util.HashMap;
import java.util.Map;

public class MaxProfit {

    // my solution
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("profit", 0);
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > map.get("profit")) {
                    map.put("profit", profit);
                }
            }
        }
        return map.get("profit");
    }

    // better solution
    public int maxProfit_1(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfit().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new MaxProfit().maxProfit(new int[]{2,4,1}));
        System.out.println(new MaxProfit().maxProfit(new int[]{2,1,4}));
    }
}
