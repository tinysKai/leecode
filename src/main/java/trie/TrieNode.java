package trie;

/**
 * 描述: 字典树的节点
 * 2018-11-17
 */
public class TrieNode {
    /**
     * 是否是一个单词的标志
     */
    protected boolean isWord;
    /**
     * 此节点的值
     */
    protected char val;

    /**
     * 此节点对应的子节点
     */
    protected  TrieNode[] children = new TrieNode[26];

    public TrieNode() {}

    public TrieNode(char val) {
        this.val = val;
    }
}
