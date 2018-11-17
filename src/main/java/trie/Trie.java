package trie;

/**
 * 描述: 实现一颗Trie树
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/#/description
 *
 *思路 :
 *      声明TrieNode数据节点
 *      结构为{
 *          val值,
 *          是否为单词,
 *          子节点
 *      }
 *
 *      数据结构小技巧 :
 *          利用英文字符的char的有序性..直接算出对应的数组下标(nchar - 'a')
 * 2018-11-17
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char val = word.charAt(i);
            int charIndex = getCharIndex(val);
            if (node.children[charIndex] == null){
                node.children[charIndex] = new TrieNode(val);
            }
            node = node.children[charIndex];
        }
        node.isWord = true;
    }



    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return traversing(word) == null ? false : traversing(word).isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return traversing(prefix) == null ? false : true;
    }

    /**
     * 迭代遍历单词并返回是否能找到这个单词Node
     * @param word
     * @return
     */
    private TrieNode traversing(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char val = word.charAt(i);
            if (node.children[getCharIndex(val)] == null) return null;

            node = node.children[getCharIndex(val)];
        }
        return node;
    }

    /**
     * 计算字符数组下标
     * @param val
     * @return
     */
    private int getCharIndex(char val) {
        return val - 'a';
    }
}
