import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * 
 * @author Akin Cem Tutal
 * @since 29.12.2021
 * @version 1
 */
public class BinarySearchTree {

    class Node {

        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insertWithKey(int key) {
        root = insertNode(root, key);
    }

    Node insertNode(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertNode(root.left, key);
        } else if (key > root.key) {
            root.right = insertNode(root.right, key);
        }
        return root;
    }
   boolean isTreeBalanced(Node node)
    {
        int leftHeight; 
        int rightHeight; 
        if (node == null)
            return true;

        leftHeight = nodeHeight(node.left);
        rightHeight = nodeHeight(node.right);
 
        if (Math.abs(leftHeight - rightHeight) <= 1
            && isTreeBalanced(node.left)
            && isTreeBalanced(node.right))
            return true;
        return false;
    }
    int nodeHeight(Node node)
    {
        if (node == null)
            return 0;
        return 1 + Math.max(nodeHeight(node.left), nodeHeight(node.right));
    }
    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree bst = new BinarySearchTree();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line = reader.readLine();
            String[] nodeData = line.split(" ");
            for (int i = 0; i < nodeData.length; i++) {
                bst.insertWithKey(Integer.parseInt(nodeData[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean isBalance = false;
        isBalance = bst.isTreeBalanced(bst.root);
        System.out.println(isBalance);
    }
}
