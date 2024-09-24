package com.hcl.hackathon.testing;

public class Node {
    
    Node left=null;
    int val ;
    Node right = null;
    
    public Node(Node left, int val, Node right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }
    public Node(int val) {
        this.val = val;
    }
    
    public Node getLeft() {
        return left;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }
    
    public int getVal() {
        return val;
    }
    
    public void setVal(int val) {
        this.val = val;
    }
    
    public Node getRight() {
        return right;
    }
    
    public void setRight(Node right) {
        this.right = right;
    }
}
