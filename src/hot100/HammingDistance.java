package hot100;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 1 << i;
            if (((x & temp) ^ (y & temp)) != 0) {
                count++;
            }
        }
        return count;
    }
}
