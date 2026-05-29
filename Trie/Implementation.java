package Trie;

import java.util.*;

public class Implementation {

    public static class Trie {

        private class Node {
            Node childs[];
            boolean isEnd;

            Node() {
                childs = new Node[26];
            }
        }

        final private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    curr.childs[ch - 'a'] = new Node();// bas nya node bna do -> abhi pata chal jayega ki yha per
                                                       // character hai
                }
                curr = curr.childs[ch - 'a'];
            }
            curr.isEnd = true;// word ke last char ko true karega taki pta chal jaye ki last char hai
        }

        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }
            return curr.isEnd == true;
        }

        public boolean startsWith(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }
            return true;
        }
    }

    public static void main(String args[]) {
        Trie t = new Trie();

        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        t.insert("app");
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
    }
}
