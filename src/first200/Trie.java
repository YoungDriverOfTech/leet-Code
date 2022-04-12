package first200;

public class Trie {
    /*
        存储的方式就是，这个类的对象，有一个自己本来的数组，然后数组里面全是空的，加入要存apple，那么根据每一个字符，算出
        一个索引，然后把数组对应的索引的位置，再次初始化一个Trie对象，然后一直循环下去，知道字符串被存储完
        https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode-ti500/
    */

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
