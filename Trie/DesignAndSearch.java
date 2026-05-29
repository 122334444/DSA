package Trie;

import java.util.*;

//leetcode 211 -> pepcoding 
public class DesignAndSearch {

    private class Node {
        Node[] childs;
        boolean isEnd;

        Node() {
            childs = new Node[26];
        }
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
            }
            curr = curr.childs[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return find(root, word, 0);
    }

    private boolean find(Node node, String word, int i) {
        if (i == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(i);
        if (ch == '.') {
            for (Node child : node.childs) {
                if (child != null && find(child, word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
        if (node.childs[ch - 'a'] == null) {
            return false;
        }
        return find(node.childs[ch - 'a'], word, i + 1);
    }
}
