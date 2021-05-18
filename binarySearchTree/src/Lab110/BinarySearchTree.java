package Lab110;

import java.util.Iterator;

/**
 *
 * @author Brandon Neri
 * @version 04/17/2021
 *
 * BinarySearchTree.java is a Java class that is an implementation
 * of a Binary Search Tree. It includes a method to verify if 
 * trees are in fact a Binary Search Tree. This class extends the 
 * AbstractBinaryTree.java class which is based off of classes 
 * previously used in lab assignments.
 *
 */
public class BinarySearchTree extends AbstractBinaryTree<Integer> {

    /**
     *
     * Represent a node of binary tree
     */
    public static class Node implements Position<Integer> {

        private int data;
        private Node left;
        private Node right;
        private Node parent;

        /**
         *
         * The default constructor for the Node Class. Assigns
         * data to the new node, set left and right children to null.
         *
         * @param data a given integer to be stored at a node
         */
        private Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        /**
         *
         * @return the instance variable data
         */
        public int getData() {
            return data;
        }

        /**
         *
         * Updates the instance variable data.
         *
         * @param data a given integer
         */
        public void setData(int data) {
            this.data = data;
        }

        /**
         *
         * @return the instance variable left
         */
        public Position<Integer> getLeft() {
            return left;
        }

        /**
         *
         * Updates the instance variable left.
         *
         * @param p a given position
         */
        public void setLeft(Position<Integer> p) {
            Node left = (Node) p;
            this.left = left;
        }

        /**
         *
         * @return the instance variable right
         */
        public Position<Integer> getRight() {
            return right;
        }

        /**
         *
         * Updates the instance variable right.
         *
         * @param p a given position
         */
        public void setRight(Position<Integer> p) {
            Node right = (Node) p;
            this.right = right;
        }

        /**
         *
         * @return the instance variable parent
         */
        public Position<Integer> getParent() {
            return parent;
        }

        /**
         *
         * Updates the instance variable parent.
         *
         * @param p a given position
         */
        public void setParent(Position<Integer> p) {
            Node parent = (Node) p;
            this.parent = parent;
        }

        /**
         *
         * Returns the Integer at a given position or node.
         * 
         * @return the element at a given node
         * @throws IllegalStateException
         */
        @Override
        public Integer getElement() throws IllegalStateException {
            return this.data;
        }
    }

    //Represent the root of binary tree  
    private Node root;
    private int size = 0;

    /**
     *
     * The default constructor to the BinarySearchTree Class.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     *
     * @return the instance variable root
     */
    public Node getRoot() {
        return root;
    }

    /**
     *
     * The insert method will add new node to the binary search tree.
     *
     * @param data a given integer
     */
    public void insert(int data) {
        //Create a new node  
        Node newNode = new Node(data);

        //Check whether tree is empty  
        if (root == null) {
            root = newNode;
            return;
        } else {
            //current node point to root of the tree  
            Node current = root, parent = null;

            while (true) {
                //parent keep track of the parent node of current node.  
                parent = current;

                //If data is less than current's data, node will be inserted to the left of tree  
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } //If data is greater than current's data, node will be inserted to the right of tree  
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     *
     * The minNode method will find out the minimum node and return it.
     *
     * @param p a given position in a tree
     * @return the minimum node in the tree
     */
    public static Position<Integer> minNode(Position<Integer> p) {
        Node root = (Node) p;
        if (root.left != null) {
            return (Position<Integer>) minNode(root.left);
        } else {
            return (Position<Integer>) root;
        }
    }

    /**
     *
     * The deleteNode method will delete the given node from the binary search tree.
     *
     * @param p a given position in the tree
     * @param value a value to be removed
     * @return the node that was deleted
     */
    public Position<Integer> deleteNode(Position<Integer> p, int value) {
        Node node = (Node) p;
        if (p == null) {
            return null;
        } else {
            //value is less than node's data then, search the value in left subtree  
            if (value < node.data) {
                node.left = (Node) deleteNode(node.left, value);
            } //value is greater than node's data then, search the value in right subtree  
            else if (value > node.data) {
                node.right = (Node) deleteNode(node.right, value);
            } //If value is equal to node's data that is, we have found the node to be deleted  
            else {
                //If node to be deleted has no child then, set the node to null  
                if (node.left == null && node.right == null) {
                    node = null;
                } //If node to be deleted has only one right child  
                else if (node.left == null) {
                    node = node.right;
                } //If node to be deleted has only one left child  
                else if (node.right == null) {
                    node = node.left;
                } //If node to be deleted has two children node  
                else {
                    //then find the minimum node from right subtree  
                    Node temp = (Node) minNode(node.right);
                    //Exchange the data between node and temp  
                    node.data = temp.data;
                    //Delete the node duplicate node from right subtree  
                    node.right = (Node) deleteNode(node.right, temp.data);
                }
            }
            return (Position<Integer>) node;
        }
    }

    /**
     *
     * The inorderTraversal method will perform in order traversal on binary search tree.
     *
     * @param p a given position in a tree
     */
    public void inorderTraversal(Position<Integer> p) {
        Node node = (Node) p;
        //Check whether tree is empty  
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {
            if (node.left != null) {
                inorderTraversal(node.left);
            }
            System.out.print(node.data + " ");
            if (node.right != null) {
                inorderTraversal(node.right);
            }
        }
    }
    
    /**
     *
     * The validateBST method is a method that returns a boolean: 
     * true if the BST is in fact a BST, and false if it is not.
     *
     * @param root a given root of a tree
     * @return a boolean if a given tree is a Binary Search Tree
     */
    public static boolean validateBST(Node root) {
        // Default case
        if (root == null) {
            return true;
        }
        // Check left side of tree
        if (root.left != null && root.left.data > root.data) {
            return false;
        }
        // Check right side of tree
        if (root.right != null && root.right.data < root.data) {
            return false;
        }
        return true;
    }

    /**
     *
     * Returns the height of a given BST.
     * 
     * @param node a given node in a tree
     * @return the height of the subtree rooted at Position p
     */
    public static int height(Node node) {
        if (node == null) {
            return 0;
        }

        LinkedQueue<Node> temp = new LinkedQueue<>();
        temp.enqueue(node);
        int height = 0;

        while (true) {
            int heightCount = temp.size();
            if (heightCount == 0) {
                return height - 1;
            }
            height++;
            while (heightCount > 0) {
                Node newNode = temp.first();
                temp.dequeue();
                if (newNode.left != null) {
                    temp.enqueue(newNode.left);
                }
                if (newNode.right != null) {
                    temp.enqueue(newNode.right);
                }
                heightCount--;
            }
        }
    }

    /**
     *
     * @return the value of the root node
     */
    @Override
    public Position<Integer> root() {
        return root;
    }

    /**
     *
     * @param p a given position
     * @return the parent node in a tree
     * @throws IllegalArgumentException
     */
    @Override
    public Position<Integer> parent(Position<Integer> p) throws IllegalArgumentException {
        Node node = (Node) p;
        return (Position<Integer>) node.getParent();
    }

    /**
     * 
     * @return the size of the BST
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     *
     * @param p a given position in a tree
     * @return the left child of a tree
     * @throws IllegalArgumentException
     */
    @Override
    public Position<Integer> left(Position<Integer> p) throws IllegalArgumentException {
        Node node = (Node) p;
        return (Position<Integer>) node.getLeft();
    }

    /**
     *
     * @param p a given position in a tree
     * @return the right child of a tree
     * @throws IllegalArgumentException
     */
    @Override
    public Position<Integer> right(Position<Integer> p) throws IllegalArgumentException {
        Node node = (Node) p;
        return (Position<Integer>) node.getRight();
    }
    
    /**
     * 
     * @return an Iterator for a BST
     */
    @Override
    public Iterator<Integer> iterator() { // Method not needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @return an Iterable of the positions in a BST
     */
    @Override
    public Iterable<Position<Integer>> positions() { // Method not needed
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
