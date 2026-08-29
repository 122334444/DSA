package Heaps;

import java.util.LinkedList;
import java.util.ArrayList;

public class Impplemetation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;// number of nodes
        private int N;// number of buckets
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bi = key.hashCode();// can return any val -12365 or 12367
            return Math.abs(bi) % N;// so bi will be in range of 0 to N-1

        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;// not exist
        }

        private void rehash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N * 2];

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        private void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);// data index

            if (di == -1) {// key not exist
                buckets[bi].add(new Node(key, value));
                n++;// number of nodes
            } else {// key exist
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {// threshold value
                // re-hashing
                rehash();
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);// data index

            if (di == -1) {// key not exist
                return null;
            } else {// key exist
                Node node = buckets[bi].get(di);
                return node.value;
            }

        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);// data index

            if (di == -1) {// key not exist
                return false;
            } else {// key exist
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);// data index

            if (di == -1) {// key not exist
                return null;
            } else {// key exist
                Node node = buckets[bi].remove(di);
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 150);
        map.put("china", 150);
        map.put("USA", 150);
        map.put("UK", 150);

        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            System.out.print(keys.get(i) + " ");
        }
    }

}
