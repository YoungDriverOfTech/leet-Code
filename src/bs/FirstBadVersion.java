package bs;

public class FirstBadVersion {

    // mid不+1mid大等，mid给right其余增
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int mid) {

        return true;
    }
}
