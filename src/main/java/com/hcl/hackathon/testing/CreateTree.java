package com.hcl.hackathon.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateTree {

//    follow up question
//    zigzag vertical order traversal
    
    
    public static Node createTree(){
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
        
        return root1;
    }
    
    public static void main(String[] args) {
        Node root = createTree();
        Map<Integer,List<Integer>> map = new HashMap<>();
        traverse(root,0,map);
        System.out.println(map);
    }
    
    public static void traverse(Node root,int level, Map<Integer, List<Integer>> map){
        if(root==null)
            return;
        if(map.containsKey(level)){
            List<Integer> temp = map.get(level);
            if(Math.abs(level)%2==1) {
                temp.add(root.val);
                map.put(level, temp);
            }else {
                temp.add(0,root.val);
                map.put(level, temp);
            }
        }
        else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            map.put(level,temp);
        }
        
        traverse(root.left,level-1,map);
        traverse(root.right, level + 1, map);
        
    }
    
//    time complexity = O(N) N = no of nodes
//    space complexity = O(N) N = no of nodes
    

}

