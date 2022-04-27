package orderbyasc;

import java.util.Arrays;
import java.util.List;

public class GetRow {
    public List<Integer> getRow(int rowIndex) {

        // only allocate rowIndex + 1 space for follow up
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return Arrays.asList(dp);
    }
}
