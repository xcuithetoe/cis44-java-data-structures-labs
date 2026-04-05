import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List<GeneralTreeNode> children; // added a type 

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit Parent, then visit children)
     */
    public void traversePreorder() {
        // Your code here
        // 1. Print this node's name
        System.out.println(this.name + " ");
        // 2. Recursively call traversePreorder on each child
        for(GeneralTreeNode child : children) {
            child.traversePreorder();
        }

    }

    /**
     * Performs a postorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit children, then visit Parent)
     */
    public void traversePostorder() {
        // Your code here
        // 1. Recursively call traversePostorder on each child
        for(GeneralTreeNode child : children) {
            child.traversePostorder();
        }
        // 2. Print this node's name
        System.out.println(this.name + " ");

    }
}

