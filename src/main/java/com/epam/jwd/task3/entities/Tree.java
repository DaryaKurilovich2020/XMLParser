package com.epam.jwd.task3.entities;

import java.io.Serializable;

public class Tree implements Serializable {
    private Node root;
    private Node currentFather;

    public Tree() {
    }

    public Node getRoot() {
        return root;
    }

    public void insert(Node node) {
        if (root == null) {
            root = node;
            currentFather = node;
        } else {
            currentFather.getChildNodes().add(node);
            node.setFather(currentFather);
        }
    }

    public Node getCurrentFather() {
        return currentFather;
    }

    public void setCurrentFather(Node currentFather) {
        this.currentFather = currentFather;
    }

}