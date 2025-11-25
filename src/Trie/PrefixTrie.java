package Trie;

public class PrefixTrie{

    class TrieNode {
        TrieNode[] children;
        public boolean endWord;

        TrieNode() {
            this.children = new TrieNode[26];
            this.endWord = false;
        }
    }

    private TrieNode rootNode;

    public PrefixTrie() {
        this.rootNode = new TrieNode();
    }

    private int setIndexArray(char symbol) {
        return symbol - 'a';
    }

    public void insert(String word) {
        TrieNode currentNode = this.rootNode;

        for (char c: word.toCharArray()) {
            int i = setIndexArray(c);

            if (currentNode.children[i] == null) {
                currentNode.children[i] = new TrieNode();
            }

            currentNode = currentNode.children[i];
        }

        currentNode.endWord = true;
    }

    public boolean contains(String word) {

        TrieNode currentNode = this.rootNode;

        for (char c : word.toCharArray()) {
            int i = setIndexArray(c);

            if (currentNode.children[i] == null) {
                return false;
            }

            currentNode = currentNode.children[i];
        }

        return currentNode.endWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = this.rootNode;

        for (char c: prefix.toCharArray()) {
            int i = setIndexArray(c);

            if (currentNode.children[i] == null) {
                return false;
            }

            currentNode = currentNode.children[i];
        }

        return true;
    }

    private void methodDFS(TrieNode currentNode, String value, LinkedList results) {

        if (currentNode.endWord == true) {
            results.addValue(value);
        }

       for (int j = 0; j < currentNode.children.length; j++) {

           if (currentNode.children[j] != null) {
               char resultSymbol = (char) (j + 'a');

               methodDFS(currentNode.children[j], value+resultSymbol, results);
           }
        }
    }

    public LinkedList getByPrefix(String prefix) {
        TrieNode currentNode = this.rootNode;
        LinkedList results = new LinkedList();

        for (char c: prefix.toCharArray()) {
            int i = setIndexArray(c);

            if (currentNode.children[i] != null) {

                currentNode = currentNode.children[i];
            } else {
                return results;
            }
        }

        methodDFS(currentNode, prefix, results);
        return results;
    }
}
