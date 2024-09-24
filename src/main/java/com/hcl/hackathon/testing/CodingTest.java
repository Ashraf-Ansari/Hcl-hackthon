package com.hcl.hackathon.testing;

public class CodingTest {
    
    void createTree(){
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        Node root7 = new Node(7);
        Node root8 = new Node(8);
        Node root9 = new Node(9);
        
        root1.setLeft(root2);
        root1.setRight(root3);
        
        root2.setRight(root5);
        root2.setLeft(root4);
        
        root3.setLeft(root6);
        root3.setRight(root7);
        
        root6.setRight(root8);
        
        root7.setRight(root9);
    }

}
