# 一. 剑指Offer
[剑指 Offer](./offer.md)

[快速排序模板](./src/sortTemplate/QuickSort.java)  
[归并排序模板](./src/sortTemplate/Mergesort.java)

用递归遍历二叉树
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }
}
```

二分查找
```java
/**
 * while(left < right) 和 while(left <= right)怎么使用
 * 这个问题取决于是否能确定需要寻找的元素是否存在于数组里面
 * 
 * 1. 如果存在于数组里面，那么就可以不用等于，因为要找的元素一定存在于数组中，所以最后不满足
 * 条件的那个位置，一定有要找的元素
 * 
 * 2. 如果不确定要找的元素在数组中是否存在，那么就需要等于号，因为如果等于的话，会判断等于的
 * 这个元素是不是目标元素，因为目标元素也可能不存在于数组中，所以必须判断
 * 
 */


/**
 * while(left < right) 
 * 1. 退出的时候，left和right会重合，那么就不需要讨论left/right位置关系
 * 对于这种情况，加入目标元素不在数组中，那么在二分查找完以后，需要特殊判断一下，
 * 因为最后left和right重合的那个元素并没搜索
 * 
 * 2. 如果加上等于好，那么在退出的时候left和right会错开
 */


/**
 * int mid = (left + right) / 2 和 int mid = (left + right + 1) / 2
 * 1. 左边和右边的区别是当数组的个数是偶数个的时候，其实中间元素有两个，
 * 左边的结果指向的是左边的中间元素，右边的则指向右边
 * 1  2  3       4  5  6  
 *       ↑       ↑
 *       left    right
 *       
 * 2. 鉴于以上情况，假如left和mid是相等的，那么出现以下的收缩边界的情况
 * left = mid  ->  什么也没做，整个边界没有被收缩，这时候我们必须采用加1的版本
 * int mid = (left + right + 1) / 2  ——> 把left边界强行的往后推一下
 * 
 */
```

# 二. 分类
## 2.1 字符串
[20道](./string.md)

## 2.2 数组
[20道](./array.md)

## 2.3 二分查找
[17道](./binarySearch.md)

## 2.4 哈希表
[17道](./hash.md)

## 2.5 链表
[20道](./linkedList.md)

## 2.6 双指针
[9道](./doublePointor.md)

## 2.7 栈
[15道](./stack.md)

## 2.8 树
[20道](./tree.md)

## 2.9 深度优先
[4道](./dfs.md)

## 2.10 广度优先
[6道](./bfs.md)

## 2.11 回溯法
[6道](./backTracking.md)

## 2.12 排序
[6道](./order.md)

# 二. LeetCode精选TOP面试题 剩余题目
[剩余题目（54）](./top200.md)

# 三. LeetCode热题HOT100 剩余题目
[剩余题目（18）](./hot100.md)

# 四. 按着顺序做
[剩余题目（35）](./orderbyasc.md)
