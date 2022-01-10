package offer;

public class FibonacciArray {
    // better solution
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }

        int formerElement = 0, latterElement = 0, result = 1;
        for (int i = 2; i <= n; i++) {
            formerElement = latterElement;
            latterElement = result;
            result = (formerElement + latterElement) % MOD;
        }
        return result;
    }

    // my solution, time too long
    private int calculate(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return (calculate(n - 1) + calculate(n - 2)) % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciArray().fib(2));
        System.out.println(new FibonacciArray().fib(5));
    }
}
