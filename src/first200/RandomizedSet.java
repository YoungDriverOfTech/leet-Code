package first200;

import java.util.*;

//  list可以在 O(1) get
//  哈希表可以在 O(1) inset delete
// https://leetcode-cn.com/problems/insert-delete-getrandom-o1/solution/o1-shi-jian-cha-ru-shan-chu-he-huo-qu-su-rlz2/
public class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        list.add(val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        // 移除的时候，因为数组一旦删除一个元素，需要进行位移，所以删除的时候，要把被删除的元素，放到数组最后在删除
        int index = map.get(val);

        // 把最后一个元素移动到参数值的索引位置上，然后删除最后一个元素就可以了，绕了个弯儿达成删除效果
        int lastEle = list.get(list.size() - 1);
        list.set(index, lastEle);
        map.put(lastEle, index);

        // 把数组里面最后一个元素删除，并且移除map里面的元素
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int next = random.nextInt(list.size());
        return list.get(next);
    }
}
