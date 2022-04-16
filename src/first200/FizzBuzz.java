package first200;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final  String FIZZ = "Fizz";
    private static final  String BUZZ = "Buzz";

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            if (i % 15 == 0) {
                res.add(FIZZ_BUZZ);
            } else if (i % 5 == 0) {
                res.add(BUZZ);
            } else if (i % 3 == 0) {
                res.add(FIZZ);
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
