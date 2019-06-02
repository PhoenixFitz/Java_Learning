package stage.two.klaus;

import sun.text.normalizer.Trie;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class ImplementTrie_PrefixTree {
    private TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTrie_PrefixTree(){
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public TrieNode searchWord(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchWord(word);
        return node != null && node.isEnd();
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix){
        TrieNode node = searchWord(prefix);
        return node != null;
    }
}


class TrieNode{

    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){ //若对应位置元素不为空，则表示对应的字符存在 0-a ，1-b ……
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch,TrieNode node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }

}