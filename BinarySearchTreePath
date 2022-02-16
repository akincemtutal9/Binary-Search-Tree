import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * @author Akin Cem Tutal
 * @since 29.12.2021
 * @version 1
 */
public class BinarySearchTree {

    static int x;

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

    static void printPaths(Node node, int sum, int x, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        x += node.key;
        path.add(node.key);
        if (x == sum) {
            StringBuilder sb = new StringBuilder();
            for (Integer p : path) {
                sb.append(p).append("-");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
        if (node.left != null) {
            printPaths(node.left, sum, x, path);
        }
        if (node.right != null) {
            printPaths(node.right, sum, x, path);
        }
        path.remove(path.size() - 1);
    }

    static void printSumPath(Node root, int sum) {
        ArrayList<Integer> path = new ArrayList<>();
        printPaths(root, sum, 0, path);
    }

    static boolean hasPath(Node node, int sum) {
        boolean hasPath = false;
        int subSum = sum - node.key;
        if (subSum == 0 && node.left == null && node.right == null) {
            return (hasPath = true);
        }
        if (node.left != null) {
            hasPath = hasPath || hasPath(node.left, subSum);
        }
        if (node.right != null) {
            hasPath = hasPath || hasPath(node.right, subSum);
        }
        return (hasPath);
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree bst = new BinarySearchTree();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line = reader.readLine();
            String[] nodeData = line.split(" ");
            for (int i = 0; i < nodeData.length; i++) {
                bst.insertWithKey(Integer.parseInt(nodeData[i]));
            }
            String line2 = reader.readLine();
            x = Integer.parseInt(line2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean hasPath=hasPath(bst.root,x);
        System.out.println(hasPath);
        if(hasPath==true){
        printSumPath(bst.root, x);
        }
        else{
            System.out.println("");
        }
        }
}
