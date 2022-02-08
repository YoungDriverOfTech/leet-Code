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
        // 注意不能写成这样，否则会超时
        /**
         * while (middle < right) {
         *     if (postorder[middle] < postorder[right]) {
         *         middle++;
         *     }
         * }
         */
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
        return check(postorder, left, middle - 1) && check(postorder, middle, right - 1);  // 注意这个需要right - 1，因为根结点已经判断过了，这里只需要判断右子树
    }
}
