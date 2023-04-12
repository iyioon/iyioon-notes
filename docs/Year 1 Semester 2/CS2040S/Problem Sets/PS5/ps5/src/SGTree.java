import java.util.ArrayList;

/**
 * ScapeGoat Tree class
 * <p>
 * This class contains some basic code for implementing a ScapeGoat tree. This version does not include any of the
 * functionality for choosing which node to scapegoat. It includes only code for inserting a node, and the code for
 * rebuilding a subtree.
 */

public class SGTree {

    // Designates which child in a binary tree
    enum Child {LEFT, RIGHT}

    /**
     * TreeNode class.
     * <p>
     * This class holds the data for a node in a binary tree.
     * <p>
     * Note: we have made things public here to facilitate problem set grading/testing. In general, making everything
     * public like this is a bad idea!
     */
    public static class TreeNode {
        int key;
        public TreeNode left = null;
        public TreeNode right = null;
        //the weight of a node u is the number of nodes in the subtree rooted at u (including u itself).
        public int weight;

        TreeNode(int k) {
            key = k;
        }
    }

    // Root of the binary tree
    public TreeNode root = null;

    /**
     * Counts the number of nodes in the specified subtree.
     *
     * @param node  the parent node, not to be counted
     * @param child the specified subtree
     * @return number of nodes
     */
    public int countNodes(TreeNode node, Child child) {
        if( child == Child.LEFT){
            if (node.left != null){
                return 1+countNodes(node.left,Child.LEFT)
                        +countNodes(node.left,Child.RIGHT);
            }else {
                return 0;
            }
        }else {
            if (node.right != null){
                return 1+countNodes(node.right,Child.LEFT)
                        +countNodes(node.right,Child.RIGHT);
            }else {
                return 0;
            }
        }
    }

    /**
     * Builds an array of nodes in the specified subtree.
     *
     * @param node  the parent node, not to be included in returned array
     * @param child the specified subtree
     * @return array of nodes
     */
    public TreeNode[] inOrder;
    public TreeNode[] enumerateNodes(TreeNode node, Child child) {
        inOrder = new TreeNode[countNodes(node,child)];
        // Pass in the child.
        if (child == Child.LEFT){
            if (node.left != null){
                recurseInorder(node.left ,0);
            }
        }else {
            if (node.right != null){
                recurseInorder(node.right,0);
            }
        }
        return inOrder;
    }

    private int recurseInorder(TreeNode node,int index){
        if (node != null) {
            // left Subtree.
            index = recurseInorder(node.left, index);
            // parent.
            inOrder[index] = node;
            index ++;
            // right subtree.
            index = recurseInorder(node.right, index);
        }
        return index;
    }


    /**
     * Builds a tree from the list of nodes Returns the node that is the new root of the subtree
     *
     * @param nodeList ordered array of nodes
     * @return the new root node
     */
    TreeNode buildTree(TreeNode[] nodeList) {
        return buildTreeRec(nodeList,0,nodeList.length-1);
    }
    private TreeNode buildTreeRec(TreeNode[] nodeList,int s, int e){
        if (s > e){
            return null;
        }else {
            int mid = (s + e) / 2;
            TreeNode parent = new TreeNode(nodeList[mid].key);
            parent.weight = e-s+1;
            parent.left = buildTreeRec(nodeList,s,mid-1);
            parent.right = buildTreeRec(nodeList,mid+1,e);
            return parent;
        }
    }

    /**
     * Determines if a node is balanced. If the node is balanced, this should return true. Otherwise, it should return
     * false. A node is unbalanced if either of its children has weight greater than 2/3 of its weight.
     *
     * @param node a node to check balance on
     * @return true if the node is balanced, false otherwise
     */
    public boolean checkBalance(TreeNode node) {
        // We say that a non-root node u is unbalanced when
        // one of its children has more than 2/3 of the total weight,
        // i.e., if v is a child of u and weight(v) > (2/3)weight(u).
        if (node == null) return true;
        if (node.left != null){
            double temp = node.weight * 2/3;
            double diff = node.left.weight-temp;
            if(diff>0) {
                return false;
            }
        }
        if (node.right != null){
            double temp = node.weight * 2/3;
            double diff = node.right.weight-temp;
            if (diff>0){
                return false;
            }
        }
        return true;
    }

    /**
     * Rebuilds the specified subtree of a node.
     *
     * @param node  the part of the subtree to rebuild
     * @param child specifies which child is the root of the subtree to rebuild
     */
    public void rebuild(TreeNode node, Child child) {
        // Error checking: cannot rebuild null tree
        if (node == null) return;
        // First, retrieve a list of all the nodes of the subtree rooted at child
        TreeNode[] nodeList = enumerateNodes(node, child);
        // Then, build a new subtree from that list
        TreeNode newChild = buildTree(nodeList);
        // Finally, replace the specified child with the new subtree
        if (child == Child.LEFT) {
            node.left = newChild;
        } else if (child == Child.RIGHT) {
            node.right = newChild;
        }
    }

    /**
     * Inserts a key into the tree.
     *
     * @param key the key to insert
     */
    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            root.weight = 1;
            return;
        }

        TreeNode node = root;

        // Use to Store the parent of the current node.
        TreeNode temp = node;
        ArrayList<TreeNode> path = new ArrayList<>();

        while (true) {
            path.add(node);
            node.weight++;
            if (key <= node.key) {
                if (node.left == null) break;
                node = node.left;
            } else {
                if (node.right == null) break;
                node = node.right;
            }
        }

        if (key <= node.key) {
            node.left = new TreeNode(key);
            node.left.weight = 1;
        } else {
            node.right = new TreeNode(key);
            node.right.weight = 1;
        }

        // Find and Rebuild
        for (int i = 1;i<path.size();i++){
            if (!checkBalance(path.get(i))){
                rebuild(path.get(i-1),
                        path.get(i).key > path.get(i-1).key ? Child.RIGHT : Child.LEFT
                        );
                break;
            }
        }

    }



    // Simple main function for debugging purposes
    public static void main(String[] args) {
        SGTree tree = new SGTree();
        for (int i = 0; i < 100; i++) {
            tree.insert(i);
        }
        tree.rebuild(tree.root, Child.RIGHT);
    }
}
