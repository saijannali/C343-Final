package HW7;
import java.io.*;
import java.util.*;

class Node <E> {
    private Node<E> left;
    private Node<E> right;
    private E data;
    private int bFactor;

    Node(E data) {
        this.data = data;
        left = null;
        right = null;
        this.bFactor = 0;
    }

    void setBF(int bf) {
    	this.bFactor = bf;
    }
    int getBF() {
    	return this.bFactor;
    }
    void setData(E d) {
        data = d;
    }

    E getData() {
        return data;
    }

    void setLeft(Node<E> i) {
        left = i;
    }

    void setRight(Node<E> i) {
        right = i;
    }

    Boolean hasLeft() {
        return left != null;
    }
    
    Node<E> getLeft() {
        return left;
    }

    Boolean hasRight() {
        return right != null;
    }
    Node<E> getRight() {
        return right;
    }
}

class AVL <E extends Comparable<?super E>> {
    private Node<E> root;
    AVL() {
        root = null;
    }
    Node<E> getRoot() { 
        return root; 
    }
    void inOrder() {
        inOrder(root);
        System.out.println();
    }
    void inOrder(Node<E>root) {
        if(root == null) return;
        inOrder(root.getLeft());
        inOrder(root.getRight());
    }

    void insert(E data) {
        root = insert(root, data);
    }
    Node<E> insert(Node<E> root, E data) {
        if (root == null) {
            return new Node<E>(data);
        } else {
            Node<E> cur;
            if (root.getData().compareTo(data) > 0) {
                cur = insert(root.getLeft(), data);
                root.setLeft(cur);
            } else {
                cur = insert(root.getRight(), data);
                root.setRight(cur);
            }
            return root;
        }
    }
    //apply left rotate to the root node
    void rotateLeft() {
        if (root.hasRight()) {
            Node temp = root.getRight();
            root.setRight(temp.getLeft());
            temp.setLeft(root);
            root = temp;
        }
    }

    //apply right rotate to the root node
    void rotateRight() {
        if (root.hasLeft()) {
            Node temp = root.getLeft();
            root.setLeft(temp.getRight());
            temp.setRight(root);
            root = temp;
        }
    }
    
    void Balance() {
    	
    }
    int RHeight(Node n) {
    	if ( n == null)
    		return 0;
    	else
    	{
    		int Rheight = RHeight(n.getRight());
    		return Rheight+1;
    	}
    }
    int LHeight(Node n) {
    	if (n == null)
    		return 0;
    	else {
    		int Lheight = LHeight(n.getLeft());
    		return Lheight+1;
    	}
    }
    void balanceFactor() {
    	balanceFactor(root);
    }
    int balanceFactor(Node<E> root) {
    	if(root == null) {
    		return 0;
    	}
    	int leftBF = balanceFactor(root.getLeft());
    	int rightBF = balanceFactor(root.getRight());
    	
    	root.setBF(leftBF-rightBF);
    	
    	if(leftBF < rightBF) {
    		return rightBF +1;
    	}
    	else {
    		return leftBF + 1;
    	}
    }
}
public class Solution {
	 public static void main(String[] argv) {
	        int n;
	        Scanner in = new Scanner(System.in);
	        n = in.nextInt();
	        AVL<Integer> tree = new AVL<Integer>();
	        for(int i = 0; i < n; i ++) {
	            tree.insert(in.nextInt());
	        }
	        in.close();
	        //if BST is correctly built, items will be displayed in sorted order using
	        //in-order traversal
	        
	        System.out.println("Rheight: " + (tree.RHeight(tree.getRoot())-1));    
	    }
}
