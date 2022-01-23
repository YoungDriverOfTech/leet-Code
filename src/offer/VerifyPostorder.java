package offer;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {

        return check(postorder, 0, postorder.length - 1);
    }

    private boolean check(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        // find first index larger than root value
        int middle = left;
        while (postorder[middle] < postorder[right]) {
            middle++;
        }

        // check if right side elements all larger than root
        int temp = middle;
        while (temp < right) {
            if (postorder[temp] < postorder[right]) {
                return false;
            }
            temp++;
        }

        // check if the subTreeNode match the requirement
        return check(postorder, left, middle - 1) && check(postorder, middle, right - 1);
    }
}
