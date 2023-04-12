import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class Trie {

    // Wildcards
    final char WILDCARD = '.';
    TrieNode root;

    private class TrieNode {
        char c; //Character
        // Our trie node will only support alphanumeric characters.
        // The index of the children array will represent the ASCII value of the character.
        // 0 will hold the WILDCARD (end of the word).
        TrieNode[] children = new TrieNode[123];

        public TrieNode (char c){
            this.c = c;
        }
    }

    public Trie() {
        this.root = new TrieNode(WILDCARD);
    }

    /**
     * Inserts string s into the Trie.
     *
     * @param s string to insert into the Trie
     */
    void insert(String s) {
        TrieNode curr = root;
        for (int i = 0; i< s.length();i++){
            int ascii =  s.charAt(i); // ASCII value of the current character.
            // Search char in the children array of curr.
            if (curr.children[ascii] == null){ // Does not exist.
                curr.children[ascii] = new TrieNode(s.charAt(i)); // Set the ascii index to TrieNode
            }
            curr = curr.children[ascii]; // Update the curr;
        }
        curr.children[0] = new TrieNode(WILDCARD); // Mark the ending.
    }


    /**
     * Checks whether string s exists inside the Trie or not.
     *
     * @param s string to check for
     * @return whether string s is inside the Trie
     */
    boolean contains(String s) {
        TrieNode curr = root;
        for (int i = 0; i< s.length();i++){
            int ascii = s.charAt(i); // ASCII value of the current character.
            // Search char in the children array of curr.
            if (curr.children[ascii] == null){ // Does not exist.
                return false;
            }
            curr = curr.children[ascii]; // Update the curr;
        }
        return curr.children[0] == null ? false : true; // Must also check the end.
    }

    /**
     * Searches for strings with prefix matching the specified pattern sorted by lexicographical order. This inserts the
     * results into the specified ArrayList. Only returns at most the first limit results.
     *
     * @param s       pattern to match prefixes with
     * @param results array to add the results into
     * @param limit   max number of strings to add into results
     */
    void prefixSearch(String s, ArrayList<String> results, int limit) {
        prefixSearchrec(s, results, limit,0, root);
    }

    void prefixSearchrec(String s, ArrayList<String> results, int limit, int index, TrieNode curr) {
        if(index > s.length()-1){
            if (curr.children[0] != null && results.size() < limit) {
                // Add to result in lower case if it is the end of the word.
                results.add(s);
            }
            // Find the rest.
            prefixSearchrec(s + '.', results, limit, index, curr);
        } else if (s.charAt(index) != '.'){
            if (curr.children[s.charAt(index)] != null){
                 prefixSearchrec(s,results,limit,index+1,curr.children[s.charAt(index)]);
            }
        } else { // Find all children
            for (int i = 1;i<curr.children.length;i++){
                if (curr.children[i] != null){
                    char [] array = s.toCharArray();
                    array[index] = curr.children[i].c;
                    prefixSearchrec(String.valueOf(array),results,limit,index,curr);
                }
            }
        }
    }

    // Simplifies function call by initializing an empty array to store the results.
    // PLEASE DO NOT CHANGE the implementation for this function as it will be used
    // to run the test cases.
    String[] prefixSearch(String s, int limit) {
        ArrayList<String> results = new ArrayList<String>();
        prefixSearch(s, results, limit);
        return results.toArray(new String[0]);
    }


    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("peter");
        t.insert("pIperzZ");
        t.insert("picked");
        t.insert("a");
        t.insert("peck");
        t.insert("of");
        t.insert("pickled");
        t.insert("peppers");
        t.insert("pepppito");
        t.insert("pepi");
        t.insert("pik");
        t.insert(" ");
        t.insert("z");

        String[] result1 = t.prefixSearch("pIperZ", 10);
        for (int i = 0;i<result1.length;i++){
            System.out.print(result1[i]+ ", ");
        }
        //String[] result2 = t.prefixSearch("pe.", 10);
        //System.out.println("Check Peter: "+t.contains(" "));
        // result1 should be:
        // ["peck", "pepi", "peppers", "pepppito", "peter"]
        // result2 should contain the same elements with result1 but may be ordered arbitrarily
    }
}
