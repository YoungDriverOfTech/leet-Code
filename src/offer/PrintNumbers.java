package offer;

public class PrintNumbers {

    // my solution
    public int[] printNumbers(int n) {

        StringBuilder resultSize = new StringBuilder();
        while (n > 0) {
            resultSize.append(9);
            n--;
        }

        int[] result = new int[Integer.parseInt(resultSize.toString())];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    // better solution
    public int[] printNumbers_1(int n) {
        int end = (int) Math.pow(10.0, n) - 1;
        int[] result = new int[end];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}