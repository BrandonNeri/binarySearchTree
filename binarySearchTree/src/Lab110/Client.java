package Lab110;

import java.util.Random;

/**
 *
 * @author Brandon Neri
 * @version 04/17/2021
 *
 * Client.java is a Java class that conducts several tests on a 
 * given Binary Search Tree and prints the results into a ASCII 
 * table. The first test verifies that the given BST is a valid
 * BST that meets basic requirements of a BST. The second test
 * returns the height of the given BST after elements are 
 * inserted into the given trees. All results are printed out
 * into a ASCII table after tests conclude.
 * 
 */
public class Client {

    public static void main(String[] args) {

        BinarySearchTree BST1 = new BinarySearchTree();
        BinarySearchTree BST2 = new BinarySearchTree();
        BinarySearchTree BST3 = new BinarySearchTree();
        BinarySearchTree BST4 = new BinarySearchTree();
        BinarySearchTree BST5 = new BinarySearchTree();
        BinarySearchTree BST6 = new BinarySearchTree();
        BinarySearchTree BST7 = new BinarySearchTree();

        Random r = new Random();

        // Header for the ASCII table
        String bar = "+-------------------+-------------------+-------------------+";
        System.out.printf(bar +"\n| \t%s     |\n" + bar + "\n", "Binary Search Tree: Height And Validation Table");
        System.out.printf("|  %-15s  |  %-15s  |  %-15s  |\n" + bar + "\n", "Test", "Height", "Is A Valid BST");

        int n = 10000;

        // Test 1: Add n integers to a BST in ascending order.
        for (int i = 0; i < n; i++) { BST1.insert(i); }
        System.out.printf("|  %-15s  |  %-15s  |  %-15s  |\n" + bar + "\n", "Test 1",
                BinarySearchTree.height(BST1.getRoot()), BinarySearchTree.validateBST(BST1.getRoot()));

        // Test 2: Add n integers to a BST in descending order. 
        for (int i = n; i > 0; i--) { BST2.insert(i); }
        System.out.printf("|  %-15s  |  %-15s  |  %-15s  |\n" + bar + "\n", "Test 2",
                BinarySearchTree.height(BST2.getRoot()), BinarySearchTree.validateBST(BST2.getRoot()));

        // Test 3: Add n integers to a BST in a random order
        for (int i = 0; i < n; i++) { BST3.insert(r.nextInt(1000000)); }
        System.out.printf("|  %-15s  |  %-15s  |  %-15s  |\n" + bar + "\n", "Test 3",
                BinarySearchTree.height(BST3.getRoot()), BinarySearchTree.validateBST(BST3.getRoot()));

        // Test 4: Add n integers to a BST in a random order
        for (int i = 0; i < n; i++) { BST4.insert(r.nextInt(1000000)); }
        System.out.printf("|  %-15s  |  %-15s  |  %-15s  |\n" + bar + "\n", "Test 4",
                BinarySearchTree.height(BST4.getRoot()), BinarySearchTree.validateBST(BST4.getRoot()));

        // Test 5: Add n integers to a BST in a random order
        for (int i = 0; i < n; i++) { BST5.insert(r.nextInt(1000000)); }
        System.out.printf("|  %-15s  |  %-15s  |  %-15s  |\n" + bar + "\n", "Test 5",
                BinarySearchTree.height(BST5.getRoot()), BinarySearchTree.validateBST(BST5.getRoot()));

        // Test 6: Add n integers to a BST in a random order
        for (int i = 0; i < n; i++) { BST6.insert(r.nextInt(1000000)); }
        System.out.printf("|  %-15s  |  %-15s  |  %-15s  |\n" + bar + "\n", "Test 6", 
                BinarySearchTree.height(BST6.getRoot()), BinarySearchTree.validateBST(BST6.getRoot()));

        // Test 7: Add n integers to a BST in a random order
        for (int i = 0; i < n; i++) { BST7.insert(r.nextInt(1000000)); }
        System.out.printf("|  %-15s  |  %-15s  |  %-15s  |\n" + bar + "\n", "Test 7", 
                BinarySearchTree.height(BST7.getRoot()), BinarySearchTree.validateBST(BST7.getRoot()));
    }
}
